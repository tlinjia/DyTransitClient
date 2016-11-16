package communication;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import window.MainWindow;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Map;

import static util.Formatter.decodeMessage;
import static util.Formatter.getText;

/**
 * Created by lin on 2016/11/11.
 */
public class BuildConnectionHandler extends ChannelInboundHandlerAdapter {
    int roomId;
    MainWindow mainWindow;

    public BuildConnectionHandler(MainWindow mainWindow, int roomId) {
        this.roomId = roomId;
        this.mainWindow = mainWindow;
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        mainWindow.display("连接成功\n");
        mainWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ctx.writeAndFlush(Unpooled.copiedBuffer("goodbye".getBytes())).addListener(new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        ctx.channel().close();
                        System.exit(0);
                    }
                });
            }
        });
        ByteBuf buf = Unpooled.copiedBuffer(("RoomId=" + this.roomId).getBytes());
        ctx.writeAndFlush(buf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] b = new byte[buf.readableBytes()];
        buf.readBytes(b);
        System.out.println(new String (b,"utf-8"));
        String text = getText(decodeMessage(new String(b, "utf-8")));
        if (text != null) {
            mainWindow.display(text+"\n");
        }
        buf.release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
