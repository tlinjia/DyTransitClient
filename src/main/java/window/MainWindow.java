package window;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import communication.BuildConnection;
import json.Json;

import javax.swing.*;
import java.awt.Font;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lin on 2016/10/14.
 */
public class MainWindow extends JFrame {
    private static MainWindow mainWindow;
    private String ip;
    int roomId;
    public JTextArea jTextArea;

    private MainWindow() {
        JPanel jPanel = new JPanel();
        jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        jTextArea.setSize(300, 300);
        jTextArea.setFont(new Font(null, Font.PLAIN, 15));
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setBounds(10, 10, 460, 660);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jPanel.add(jScrollPane);
        jPanel.setSize(500, 700);
        jPanel.setLayout(null);

        this.setSize(500, 720);
        add(jPanel);

        this.ip = JOptionPane.showInputDialog(this, "输入中转服务器IP", "连接", 1);
        if (this.ip == null) {
            System.exit(0);
        }
        String room = JOptionPane.showInputDialog(this, "输入房间号", "确定", 1);
        if (room == null) {
            System.exit(0);
        }
        try{
            this.roomId = Integer.valueOf(room);
        }catch (NumberFormatException e){
            try {
                URL url= new URL("http://open.douyucdn.cn/api/RoomApi/room/"+room);
                ObjectMapper mapper = new ObjectMapper();
                mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
                Json json1 = mapper.readValue(url,Json.class);
                this.roomId = json1.getData().getRoomId();
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(this, "获取房间信息失败,检查房间号或网络");
                System.exit(0);
            }
        }
        if ((Integer)roomId == null) {
            System.exit(0);
        }
        this.setTitle("弹幕助手");
        this.setResizable(false);
        this.setVisible(true);
    }


    public static MainWindow getMainWindow() {
        if (mainWindow == null) {
            mainWindow = new MainWindow();
        }
        return mainWindow;
    }

    public void start() {
        try {
            InetAddress inetAddress = InetAddress.getByName(this.ip);
            //连接服务器
            BuildConnection connection = new BuildConnection(inetAddress,roomId,mainWindow);
            connection.connect();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "连接失败，请检查服务器地址");
            System.exit(0);
        }
    }


    public void display(String s) {
        jTextArea.append(s);
        jTextArea.setCaretPosition(jTextArea.getText().length());
    }


}
