package communication;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import window.MainWindow;

import javax.swing.*;
import java.net.InetAddress;
import java.nio.ByteOrder;

/**
 * Created by lin on 2016/11/11.
 */
public class BuildConnection {
    private final InetAddress hostAddress;
    private final static int serverPort = 4747;
    int roomId;
    MainWindow mainWindow;

    public BuildConnection(InetAddress hostAddress, int roomId, MainWindow mainWindow) {
        this.hostAddress = hostAddress;
        this.roomId = roomId;
        this.mainWindow = mainWindow;
    }


    public void connect() {
        new Thread(new Runnable() {
            public void run() {
                EventLoopGroup group = new NioEventLoopGroup();
                try {
                    Bootstrap bootstrap = new Bootstrap();
                    bootstrap.group(group).channel(NioSocketChannel.class)
                            .option(ChannelOption.TCP_NODELAY, true)
                            .handler(new ChannelInitializer<SocketChannel>() {
                                protected void initChannel(SocketChannel socketChannel) throws Exception {
                                    socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(ByteOrder.LITTLE_ENDIAN, 20480, 0, 4, 0, 12, true));
                                    socketChannel.pipeline().addLast(new BuildConnectionHandler(mainWindow, roomId));

                                }
                            });

                    ChannelFuture future = bootstrap.connect(hostAddress, serverPort).sync();
                    future.channel().closeFuture().sync();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mainWindow, "连接失败，请检查服务器地址");
                    System.exit(0);
                } finally{
                    group.shutdownGracefully();
                }
            }
        }).start();
    }
}
