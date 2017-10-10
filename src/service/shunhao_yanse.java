package service;

public class shunhao_yanse {
    public static String change(String shunnhao){
        String color="";
        switch (shunnhao){
            case "1-8":
                color="红色";
                break;
            case "1-16":
                color="绿色";
                break;
            case "8-1":
                color="蓝色";
                break;
            case "16-1":
                color="黄色";
                break;
        }
        return  color;
    }

}
