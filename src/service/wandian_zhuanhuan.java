package service;

import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class wandian_zhuanhuan {
    public String change(String wandian){
        String t="";
        String abc="[a-zA-Z]{2}";
        String number="[0-9]{4}";
        Pattern pattern_abc=Pattern.compile(abc);
        Pattern pattern_number=Pattern.compile(number);
        if(pattern_abc.matcher(wandian).matches()){
                    if(wandian.equals("wd")|| wandian.equals("WD")){
                        t="晚点未定";
                    }else if (wandian.equals("ty") || wandian.equals("TY")){
                        t="停运";
                    }else{
                        t="输入格式错误";
                    }
        }else if(pattern_number.matcher(wandian).matches()){
                    String[] time=wandian.split("");
                    t+="晚点";
                    if (time[0].equals("0")){
                             if(time[1].equals("0")){

                             }else{
                                 t+=time[1]+"小时";
                             }
                    }else{
                        t+=time[0]+time[1]+"小时";
                    }
                   if (time[2].equals("0")){
                           if (time[3].equals("0")){
                                     t+="";
                           }else{
                               t+=time[3]+"分钟";
                           }
                   }else {
                    t+=time[2]+time[3]+"分钟";
                   }

        }else{
            t="输入格式错误";
        }
        if (wandian.equals("") || wandian.equals("0000")){
            t="";
        }
        return t;
    }
}
