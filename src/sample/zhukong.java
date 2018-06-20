package sample;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import test.client;
import test.server;

import java.util.Timer;

import static javafx.application.Application.launch;

/**
 * Created by Administrator on 2017/8/6 0006.
 */
public class zhukong extends Application {
    public final static Timer timer_zhukong=new Timer();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("zhukong.fxml"));

        primaryStage.setTitle("信阳车站");
        primaryStage.setScene(new Scene(root, 1200, 600));
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

        primaryStage.setOnCloseRequest(event->{

            timer_zhukong.cancel();
            th.interrupt();
        });
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
