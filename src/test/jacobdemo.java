package test;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;


/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class jacobdemo {
    private static ActiveXComponent activeXComponent;
    private static Dispatch dispatch;
    static{
        activeXComponent=new ActiveXComponent("Sapi.SpVoice");
        dispatch=activeXComponent.getObject();
    }
    public static void speak(String text){
        Dispatch.call(dispatch,"Speak",new Variant(text));
    }

    public static void main(String[] args) {

        //speak();
    }
}
