package test;

import ftp.f1;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static sample.config.df;
import static sample.config.df_year;
import static sample.config.zhukong_ip;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class serverHandler extends ChannelInboundHandlerAdapter {
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
      //  System.out.println(msg.toString());
       List<Character> messagelist=new ArrayList<>();
          ByteBuf in=(ByteBuf)msg;
          try{
              while (in.isReadable()){
                  //System.out.println((char)in.readByte());
                  messagelist.add((char)in.readByte());
                  System.out.flush();
              }
              //System.out.println(messagelist.toString()+"      here   ");
              if(messagelist.toString().contains("b")){
                               f1 ftp=new f1(zhukong_ip, 21, "ls", "ls");
                               ftp.ftpLogin();
                               ftp.downfile("base.xls","d:\\showexcel");
                               ftp.ftpLogOut();


//                  try {
//                      Robot robot=new Robot();
//                      robot.mouseMove(100,100);
//                      robot.mousePress(InputEvent.BUTTON1_MASK);
//                      robot.mouseRelease(InputEvent.BUTTON1_MASK);
//                      robot.mouseMove(500,500);
//                      robot.delay(100);
//
//
//                  } catch (AWTException e) {
//                      e.printStackTrace();
//                  }
              }else if (messagelist.toString().contains("a")){
                  String[] gettime=messagelist.toString().split("#");

                  if (gettime.length==2){
                           String[] thetime=gettime[1].split(",");
                     // System.out.println(gettime[1].split(",")[0]);
                      String year=thetime[1].trim()+thetime[2].trim()+thetime[3].trim()+thetime[4].trim();
                      String month=thetime[5].trim()+thetime[6].trim();
                      String day=thetime[7].trim()+thetime[8].trim();
                      String hour=thetime[10].trim()+thetime[11].trim();
                      String minute=thetime[13].trim()+thetime[14].replace("]","").trim();
                     Runtime runtime=Runtime.getRuntime();
                     runtime.exec("cmd.exe /c date "+year+"-"+month+"-"+day);
                     runtime.exec("cmd.exe /c time "+hour+":"+minute+":00");


                  }
                  f1 ftp=new f1(zhukong_ip, 21, "ls", "ls");
                  ftp.ftpLogin();
                  ftp.downfile(df_year.format(new Date())+".xls","d:\\showexcel");
                  ftp.ftpLogOut();
              }
          }finally {
              ReferenceCountUtil.release(msg);
          }


       // ctx.write(msg);
    }


    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception{
        System.out.println("server complete");
      //  ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) throws Exception{
        System.out.println("server exception:  "+cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }




}
