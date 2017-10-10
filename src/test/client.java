package test;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;


/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class client {
    private final String host;
    private final int port;
    public client(int port){
        this("127.0.0.1",port);
    }
    public client(String host,int port){
        this.host=host;
        this.port=port;
    }

    public void start(String text) throws Exception{
        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();
        try {
            Bootstrap bootstrap=new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(this.host,this.port))

                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            System.out.println("connected...");
                            socketChannel.pipeline().addLast(new clientHandler(text));
                        }
                    });
            System.out.println("created");
            ChannelFuture channelFuture=bootstrap.connect().sync();
            System.out.println("connected.....");
           channelFuture.channel().closeFuture().sync();
            System.out.println("closed");
        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        try {
            new client("10.103.17.23",12306).start("abcz");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
