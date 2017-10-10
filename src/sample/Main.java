package sample;

import javafx.application.Application;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import test.server;


import java.util.Timer;




public class Main extends Application {

    public final static Timer timer_xianshi=new Timer();
  //  public static ScheduledService<Integer> scheduledService=null;
    public final static Timer timer_wandian=new Timer();
   // pblic finalu static Thread th_xia=new Thread();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.setAlwaysOnTop(true);







        primaryStage.setTitle("信阳车站");
        Scene scene=new Scene(root, 400, 352);
        scene.getStylesheets().add("css/tableview.css");
        Task task=new Task() {
            @Override
            protected Object call() throws Exception {
                test.server server=new server(12306);
                server.start();
                return null;
            }
        };
        Thread th=new Thread(task);
        th.setDaemon(true);
        th.start();

        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
             //   scheduledService.cancel();
                timer_xianshi.cancel();
                timer_wandian.cancel();
                //th_xia.interrupt();
                th.interrupt();

            }

        });
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }



}
