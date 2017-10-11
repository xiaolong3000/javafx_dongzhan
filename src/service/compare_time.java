package service;

import sample.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/8/12 0012.
 */
public class compare_time {
    public static int comparetime_old(String now,String xianshi,String wandian){


        int flag=0;
        String[] aa=now.split(":");
        String[] bb=xianshi.split(":");
        int a1,a2,b1,b2;
        a1=Integer.parseInt(aa[0]);
        a2=Integer.parseInt(aa[1]);
        b1=Integer.parseInt(bb[0]);
        b2=Integer.parseInt(bb[1]);
        String reg="晚点([1-9]{0,2})(小时){0,1}([1-9]{0,2})(分钟){0,1}";
        Pattern pattern=Pattern.compile(reg);
        Matcher matcher=pattern.matcher(wandian);

        if(matcher.find()){

//            if (matcher.group(2).equals("") || matcher.group(2).equals(null)){
//                if (!matcher.group(1).equals("")){
//                    b2 += Integer.parseInt(matcher.group(1));
//                }
//            }
//           if (matcher.group(2).equals("小时")){
//               b1 += Integer.parseInt(matcher.group(1));
//               if (!matcher.group(3).equals("")){
//                   b2 += Integer.parseInt(matcher.group(3));
//               }
//           }

            if (wandian.contains("小时")){
                b1 += Integer.parseInt(matcher.group(1));
                if (wandian.contains("分钟")){
                    b2 += Integer.parseInt(matcher.group(3));
                }
            }else if (wandian.contains("分钟")){
                b2 += Integer.parseInt(matcher.group(1));
            }
           // System.out.println(wandian+"     "+xianshi+"          "+a2+"         "+b2);

           if (b2>=60){
                b2-=60;
                b1+=1;
           }

        }

        if(a1>b1)
        { flag=1;}
        else if (a1==b1){
                     if(a2>b2){
                                flag=1;
                       }else if (a2==b2){
                         flag=0;
                     }else if (a2<b2){
                           flag=-1;
                     }
        }else if (a1<b1){
            flag=-1;
        }

        if(wandian.contains("停运")||wandian.contains("未定")){
            flag=-1;
        }

        return flag;

    }

    public static int comparetime(String now,String xianshi,String wandian,int tingjiantime){

        int flag=0;
        if(xianshi.equals(""))
        {
            return -1;
        }
        String[] aa=now.split(":");
        String[] bb=xianshi.split(":");
        int a1,a2,b1,b2;
        a1=Integer.parseInt(aa[0]);
        a2=Integer.parseInt(aa[1]);
        b1=Integer.parseInt(bb[0]);
        b2=Integer.parseInt(bb[1]);
        String reg="晚点([1-9]{0,2})(小时){0,1}([1-9]{0,2})(分钟){0,1}";
        Pattern pattern=Pattern.compile(reg);
        Matcher matcher=pattern.matcher(wandian);

        if(matcher.find()){

//            if (matcher.group(2).equals("") || matcher.group(2).equals(null)){
//                if (!matcher.group(1).equals("")){
//                    b2 += Integer.parseInt(matcher.group(1));
//                }
//            }
//           if (matcher.group(2).equals("小时")){
//               b1 += Integer.parseInt(matcher.group(1));
//               if (!matcher.group(3).equals("")){
//                   b2 += Integer.parseInt(matcher.group(3));
//               }
//           }

            if (wandian.contains("小时")){
                b1 += Integer.parseInt(matcher.group(1));
                if (wandian.contains("分钟")){
                    b2 += Integer.parseInt(matcher.group(3));
                }
            }else if (wandian.contains("分钟")){
                b2 += Integer.parseInt(matcher.group(1));
            }
            // System.out.println(wandian+"     "+xianshi+"          "+a2+"         "+b2);


        }

        b2-= tingjiantime;//提前minute分钟停止显示
        if (b2>=60){
            b2-=60;
            b1+=1;
        }
        if (b2<0){
            b1-=1;
            b2+=60;
        }

        if(a1>b1)
        { flag=1;}
        else if (a1==b1){
            if(a2>b2){
                flag=1;
            }else if (a2==b2){
                flag=0;
            }else if (a2<b2){
                flag=-1;
            }
        }else if (a1<b1){
            flag=-1;
        }

        if(wandian.contains("停运")||wandian.contains("未定")){
            flag=-1;
        }
       // System.out.println(a1+"  "+a2+"  "+b1+"   "+b2);
        return flag;

    }

public static String getrealtime(String time){

        if (time.contains("AM")){
            time=time.replace("AM","");
            time=time.trim();
        }

        if (time.contains("PM")){
            time=time.replace("PM","");
            time=time.trim();
            String[] a=time.split(":");
            int b=Integer.parseInt(a[0]);
            b+=12;
            time=""+b+":"+a[1];
        }

        return time;
}

}
