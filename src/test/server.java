package test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class server {
    private final int port;
    public server(int port){
        this.port=port;
    }
    public void start() throws Exception{
        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap=new ServerBootstrap();
            serverBootstrap.group(eventLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,100)
                    .localAddress(this.port)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            System.out.println("client :" +channel.remoteAddress());
                            channel.pipeline().addLast(new serverHandler());
                        }
                    });
            ChannelFuture channelFuture=serverBootstrap.bind().sync();
            System.out.println("started and listen on "+channelFuture.channel().localAddress());
            channelFuture.channel().closeFuture().sync();
        }finally {
            eventLoopGroup.shutdownGracefully();

        }
    }

    public static void main(String[] args) {
        try {
            new server(12306).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
