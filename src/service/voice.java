package service;

/**
 * Created by Administrator on 2017/8/30 0030.
 */
public class voice {
    public String getvoice(String checi,String wandianshijian){
        String text="";
        if (checi.contains("G"))
        checi.replace("G","高");

         if (checi.contains("D"))
             checi.replace("D","动");

        String[] cc=checi.split("");
        for (int i=0;i<cc.length;i++){
            text+=cc[i]+" ";
        }
        text+="次      ";
        text+=wandianshijian;

        return text;
    }
}
