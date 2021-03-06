package controllers;



import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;


import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.RotateEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Duration;
import readfile.readexcel;
import sample.Main;
import sample.config;
import service.*;
import test.jacobdemo;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import test.jacobdemo;


import static javafx.scene.paint.Color.*;
import static sample.Main.timer_wandian;
import static sample.Main.timer_xianshi;
import static sample.config.*;
import static sample.config.base_path;
import static sample.config.df_year;

/*
显示端控制
 */
public class Controller implements Initializable{
    private final  int ZHANGTAI=1;
      private final ObservableList<checi> data = FXCollections.observableArrayList(//初始化
           //   new checi()
    );


    private final ObservableList<wandian> data1=FXCollections.observableArrayList(//晚点
          //  new wandian()
    );
    @FXML
    private GridPane gridpane;
    @FXML
    private   TableView<checi> tableview;
    @FXML
    private TableColumn<checi,String> checi;
    @FXML
    private TableColumn<checi,String> zhant;
    @FXML
    private  VBox vbox;
    @FXML
    private TableColumn<checi,String> dibiao;
    @FXML
    private TableView<wandian> tableview1;
    @FXML
    private TableColumn<wandian,String> wandiancheci;
    @FXML
    private TableColumn<wandian,String> wandianshijian;
    @FXML
    private TableColumn<wandian,String> wandianzhant;

    @FXML
    private Text text;




      TimerTask timerTask=null;




    private  String path_now=base_path+"\\"+df_year.format(new Date())+".xls";


    @Override
    @SuppressWarnings("unchecked")
    public void initialize(URL location, ResourceBundle resources) {

        vbox.setStyle(" -fx-border-color: #09bf0c;");
        tableview.setItems(data);
        tableview1.setItems(data1);
        checi.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getchechi()));
        zhant.setCellValueFactory(new PropertyValueFactory<>("zhant"));
        dibiao.setCellValueFactory(new PropertyValueFactory<>("dibiao"));
        wandiancheci.setCellValueFactory(new PropertyValueFactory<>("wandiancheci"));
        wandianshijian.setCellValueFactory(new PropertyValueFactory<>("wandianshijian"));
        wandianzhant.setCellValueFactory(new PropertyValueFactory<>("wandianzhant"));
        tableview.setFixedCellSize(35.0);
        tableview1.setFixedCellSize(29.0);
        tableview.setRowFactory(new Callback<TableView<service.checi>, TableRow<service.checi>>() {
            TableCell<checi,String> tableCell=new TableCell<service.checi, String>();

            @Override
            public TableRow<checi> call(TableView<checi> param) {
                return new TableRow<checi>(){



                    @Override
                    protected void updateItem(checi item, boolean empty) {
                        super.updateItem(item, empty);
                       setStyle("-fx-background-color: black");
                       this.setBorder(Border.EMPTY);
                       // setStyle("-fx-padding:-9 0 0 0; -fx-pref-height:40px;");
                        setItem(item);
                    }




                };

            }
        });
        tableview1.setRowFactory(new Callback<TableView<wandian>, TableRow<wandian>>() {
            @Override
            public TableRow<wandian> call(TableView<wandian> param) {
                return new TableRow<wandian>(){
                    @Override
                    protected void updateItem(wandian item, boolean empty) {
                        super.updateItem(item, empty);
                        setStyle("-fx-background-color: black");
                        setBorder(Border.EMPTY);

                        setItem(item);
                    }


                };
            }
        });
        wandiancheci.setCellFactory(new Callback<TableColumn<wandian,String>, TableCell<wandian,String>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<wandian,String>(){
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        this.setBorder(Border.EMPTY);
                        if (!isEmpty()) {
                            this.setTextFill(Color.RED);
                            setFont(Font.font("微软雅黑", FontWeight.BOLD,28));
                            setText(item);
                        }
                    }
                };
            }
        });
        wandianshijian.setCellFactory(new Callback<TableColumn<wandian,String>, TableCell<wandian,String>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<wandian,String>(){

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        this.setBorder(Border.EMPTY);
                        if (!isEmpty()) {
                            this.setTextFill(RED);
                            setFont(Font.font("微软雅黑", FontWeight.BOLD,28));
                            setText(item);

                        }
                    }
                };
            }



        });
        wandianzhant.setCellFactory(new Callback<TableColumn<wandian,String>, TableCell<wandian,String>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<wandian,String>(){
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        this.setBorder(Border.EMPTY);
                        if (!isEmpty()) {
                            this.setTextFill(RED);
                            setBackground(new Background(new BackgroundFill(BLACK,CornerRadii.EMPTY, Insets.EMPTY)));
                            setFont(Font.font("微软雅黑", FontWeight.BOLD,28));
                            setText(item);
                        }
                    }
                };
            }
        });
        dibiao.setCellFactory(new Callback<TableColumn<service.checi, String>, TableCell<service.checi, String>>() {
            @Override
            public TableCell<checi, String> call(TableColumn<checi, String> param) {
                return new MyTC_checi(param);
            }
        });
        checi.setCellFactory(new Callback<TableColumn<service.checi, String>, TableCell<service.checi, String>>() {
            @Override
            public TableCell<checi, String> call(TableColumn<checi, String> param) {
                return new MyTC_checi(param);}
        });
        zhant.setCellFactory(new Callback<TableColumn<checi,String>, TableCell<checi,String>>() {
            @Override
            public TableCell<checi, String> call(TableColumn<checi, String> param) {
                return new MyTC_checi(param);}
        });





   SimpleDateFormat df=new SimpleDateFormat("ss");

    timerTask=new TimerTask() {
        @Override
        public void run() {
          //  System.out.println(df.format(new Date()));
          if (df.format(new Date()).equals("00"))
           show_tableview();
        }
    };
    timer_xianshi.schedule(timerTask,0,1000);




    }
private void changeText(Text text,String wenben){
    text.setText(wenben);
    Double width=tableview.getPrefWidth();
    text.setWrappingWidth(text.getText().length()*39+width);
    text.setFill(Color.RED);
    TranslateTransition tt=new TranslateTransition(Duration.millis(90000),text);
    // tt.setToX(-text.getText().length()-tableview.getPrefWidth());
    tt.setFromX(width);
    //   System.out.println(text.getText().length());
    tt.setToX(-text.getText().length()*39);
    tt.setCycleCount(Timeline.INDEFINITE);
    // tt.setAutoReverse(true);
    tt.play();
}




voice voice=new voice();
public void show_tableview() {
  List<checi> list_shang=new ArrayList<>();
  List<checi> test_shang=new ArrayList<>();
  List<wandian> list_xia=new ArrayList<>();
  list_shang.clear();
  list_xia.clear();

    File file_now=new File(path_now);
    String[][] data_excel;
    if(file_now.exists()){
        data_excel=new readexcel().result(path_now);
    }else{
        data_excel=new readexcel().result(base_file_path);
    }
    String now = df.format(new Date());
    for (int i = 0; i < data_excel.length; i++) {
        if (compare_time.comparetime(now, data_excel[i][1], data_excel[i][6],config.tingjian_time) < 0) {
            if (!data_excel[i][9].isEmpty()&&Integer.parseInt(data_excel[i][9].trim())==ZHANGTAI) {//站台显示端
                zhongkong zhongkong = new zhongkong();
                zhongkong.setCheci(data_excel[i][0]);
                zhongkong.setKaichetime(data_excel[i][1]);
                zhongkong.setXianshitime(data_excel[i][2]);
                zhongkong.setZhant(" "+data_excel[i][3].trim());
                zhongkong.setDibiao(data_excel[i][4]);
                zhongkong.setShunhao(data_excel[i][5]);
                zhongkong.setWandiantime(data_excel[i][6]);
                zhongkong.setQuanneng(data_excel[i][7]);

                if (compare_time.comparetime(now,zhongkong.getXianshitime(),zhongkong.getWandiantime(),1)>=0){
                   test_shang.add(new checi(zhongkong));
                   if (test_shang.size()>=4){
                       System.out.println("here   "+new Date()+"  "+test_shang.size()+"  "+zhongkong.getCheci());
                   }
                }
                if (compare_time.comparetime(now,zhongkong.getXianshitime(),zhongkong.getWandiantime(),1)>=0&&list_shang.size()<4){
                   list_shang.add(new checi(zhongkong));
                    continue;
                }
                if (!zhongkong.getWandiantime().equals("")){
                    list_xia.add(new wandian(zhongkong));
//                    if (data1.get(0).getWandiancheci().equals("")){
//                        data1.remove(0);
//                    }

                }



            }
        }
    }
    if (list_shang.size()==0){
           list_shang.add(new checi());
    }
    if (list_xia.size()==0){
        list_xia.add(new wandian());
    }

    compare_wandian compare_wandian=new compare_wandian();
    if (!compare_wandian.compare_checi(list_shang,data)){
        data.clear();
        data.addAll(list_shang);
        tableview.refresh();

    }
    if (!compare_wandian.compare_wandian(list_xia,data1)){
        data1.clear();
        data1.addAll(list_xia);
        tableview1.refresh();
    }

    //滚动显示文字
    String wenben=data_excel[0][8];
//    if (!wenben.equals(text.getText()))
//    {
        changeText(text,wenben);
      //  System.out.println(text);
   // }

    //下屏滚动
    if (data1.size()>3) {
        for (int i = 0; i < data1.size(); i++) {
            try {
                Thread.sleep(4 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tableview1.scrollTo(i);
            //jacobdemo.speak(voice.getvoice(data1.get(i).getWandiancheci(),data1.get(i).getWandianshijian()));//读出来
        }
    }





//
//
//  Map<Integer,checi> map=new HashMap<>();
//    for (zhongkong z : data_here) {
//        if (compare_time.comparetime(now,z.getKaichetime(),z.getWandiantime())<0){
//            if (z.getQuanneng().equals("a")){
//                map.put(0,new checi(z));
//            }
//            if (z.getQuanneng().equals("b")){
//                map.put(1,new checi(z));
//            }
//            if (z.getQuanneng().equals("c")){
//                map.put(2,new checi(z));
//            }
//            if (z.getQuanneng().equals("d")){
//                map.put(3,new checi(z));
//            }
//        }
//        if (compare_time.comparetime(now, z.getXianshitime(), z.getWandiantime()) >= 0 && data_shang.size() < 4) {
//            if (compare_time.comparetime(now, z.getKaichetime(), z.getWandiantime()) < 0) {
//
//                data_shang.add(new checi(z));
//
//                continue;
//            }
//        }
//        if (!z.getWandiantime().equals("")) {
//
//            data_xia.add(new wandian(z));
//        }
//    }//上屏优先
//   for (int i=0;i<map.size();i++){//调整上屏
//
//           if (data_shang.size() > i) {
//               checi z=data_shang.get(i);
//               data_shang.set(i, map.get(i));
//               if (!z.getWandianshijian().equals("")){
//                   data_xia.add(new wandian(z));
//               }
//           } else {
//               data_shang.add(i, map.get(i));
//           }
//
//   }
//if (data_shang.size()==0){
//        data_shang.add(new checi());
//}
//if (data_xia.size()==0){
//    data_xia.add(new wandian());
//}
//if (data_shang.size()>0&&data_shang.get(0).getchechi().equals("")){
//    data_shang.remove(0);
//}
//if (data_xia.size()>0&&data_xia.get(0).getWandiancheci().equals("")){
//    data_xia.remove(0);
//}
//    tableview.setItems(data_shang);
//    tableview1.setItems(data_xia);
//

  //  System.out.println("here");

}




    public void changetable(MouseEvent mouseEvent) {

        //scheduledService.restart();
      //   System.out.println("123");
         show_tableview();//立即刷新
        System.out.println("刷新了    "+new Date());





    }






}
