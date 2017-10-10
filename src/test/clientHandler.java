package test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class clientHandler extends ChannelInboundHandlerAdapter {

      private final ByteBuf firstMessage;
      public clientHandler(String text){
          firstMessage=Unpooled.buffer(128);

         firstMessage.writeBytes(text.getBytes());
      }



    public void channelActive(ChannelHandlerContext context) throws Exception{
        System.out.println("client channel active");
        context.writeAndFlush(firstMessage);
        context.close();
    }
    public void channelRead(ChannelHandlerContext context,Object msg) throws Exception{

        context.write(msg);
    }

     public void channelReadComplete(ChannelHandlerContext context){

          context.flush();

     }





    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) throws Exception{
        System.out.println("server exception:  "+cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }
}
