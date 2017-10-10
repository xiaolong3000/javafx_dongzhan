package test;

import controllers.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Main;
import service.checi;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class changetable {
    public static void main(String[] args) {
        checi c=new checi();
        Point point=MouseInfo.getPointerInfo().getLocation();
//        System.out.println(point.x);
//        System.out.println(point.y);
//        point.setLocation(100,100);
//        System.out.println(point.x);
        try {
            Robot robot=new Robot();
            robot.mouseMove(100,100);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.mouseMove(500,500);
            robot.delay(100);


        } catch (AWTException e) {
            e.printStackTrace();
        }


    }
}
