package controllers;

import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import readfile.readexcel;
import sample.config;
import service.*;
import test.client;


import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static sample.config.*;

import static sample.zhukong.timer_zhukong;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class zhukong_Control implements Initializable{
    @FXML
    private BorderPane pane;
@FXML
private TableView<zhongkong> t1;
@FXML
private TableView<checi> t2;
@FXML
private TableView<wandian> t3;
@FXML
private TableView<checi> t4;
@FXML
private TableView<wandian> t5;

@FXML
private Button tijiao;
@FXML
private Button base;
@FXML
private Button jiache;
//@FXML
//private Button shuaxin;
//@FXML
//private Button chongzhi;
@FXML
private TableColumn<zhongkong,String> id;
@FXML
private TableColumn<zhongkong,String> t1_checi;
    @FXML
    private TableColumn<zhongkong,String> t1_kaiche;
    @FXML
    private TableColumn<zhongkong,String> t1_xianshi;
    @FXML
    private TableColumn<zhongkong,String> t1_zhant;
    @FXML
    private TableColumn<zhongkong,String> t1_dibiao;
    @FXML
    private TableColumn<zhongkong,String> t1_shunhao;
    @FXML
    private TableColumn<zhongkong,String> t1_wandian;
   @FXML
   private TableColumn<zhongkong,String> t1_houche;


    @FXML
    private TextArea textarea;

    @FXML
    private TableColumn<checi,String> t2_checi;
    @FXML
    private TableColumn<checi,String> t2_dibiao;
    @FXML
    private TableColumn<checi,String> t2_zhant;
    @FXML
    private TableColumn<checi,String> t2_wandian;

    @FXML
    private TableColumn<wandian,String> t3_wandiancheci;
    @FXML
    private TableColumn<wandian,String> t3_wandianzhant;
    @FXML
    private TableColumn<wandian,String> t3_wandianshijian;



    @FXML
    private TableColumn<checi,String> t4_checi;
    @FXML
    private TableColumn<checi,String> t4_dibiao;
    @FXML
    private TableColumn<checi,String> t4_zhant;
    @FXML
    private TableColumn<checi,String> t4_wandian;

    @FXML
    private TableColumn<wandian,String> t5_wandiancheci;
    @FXML
    private TableColumn<wandian,String> t5_wandianzhant;
    @FXML
    private TableColumn<wandian,String> t5_wandianshijian;






    private final ObservableList<wandian> data3= FXCollections.observableArrayList(
    );
    private final ObservableList<wandian> data5= FXCollections.observableArrayList(
    );
    private final ObservableList<checi> data4= FXCollections.observableArrayList(
    );
    private final ObservableList<checi> data2= FXCollections.observableArrayList(
    );
    private final ObservableList<zhongkong> data1= FXCollections.observableArrayList(

    );
    private static final DataFormat SERIALIZED_MIME_TYPE = new DataFormat("application/x-java-serialized-object");
    private int tag=0;
    private  String path_now=base_path+"\\"+df_year.format(new Date())+".xls";


     ColorAdjust colorAdjust_red=new ColorAdjust();
    ColorAdjust colorAdjust_yellow=new ColorAdjust();
    ColorAdjust colorAdjust_green=new ColorAdjust();
    @Override
    @SuppressWarnings("unchecked")
    public void initialize(URL location, ResourceBundle resources) {
        colorAdjust_red.setContrast(0.1);
        colorAdjust_red.setHue(-0.05);
        colorAdjust_red.setBrightness(0.1);
        colorAdjust_red.setSaturation(0.9);

        colorAdjust_yellow.setContrast(0.1);
        colorAdjust_yellow.setHue(0.24);
        colorAdjust_yellow.setBrightness(0.1);
        colorAdjust_yellow.setSaturation(0.9);

        colorAdjust_green.setContrast(0.1);
        colorAdjust_green.setHue(0.50);
        colorAdjust_green.setBrightness(0.1);
        colorAdjust_green.setSaturation(0.9);


        t2_checi.setCellValueFactory(new PropertyValueFactory<>("checi"));
        t2_zhant.setCellValueFactory(new PropertyValueFactory<>("zhant"));
        t2_wandian.setCellValueFactory(new PropertyValueFactory<>("wandianshijian"));
        t2_dibiao.setCellValueFactory(new PropertyValueFactory<>("dibiao"));
        t3_wandiancheci.setCellValueFactory(new PropertyValueFactory<>("wandiancheci"));
        t3_wandianshijian.setCellValueFactory(new PropertyValueFactory<>("wandianshijian"));
        t3_wandianzhant.setCellValueFactory(new PropertyValueFactory<>("wandianzhant"));

        t4_checi.setCellValueFactory(new PropertyValueFactory<>("checi"));
        t4_zhant.setCellValueFactory(new PropertyValueFactory<>("zhant"));
        t4_wandian.setCellValueFactory(new PropertyValueFactory<>("wandianshijian"));
        t4_dibiao.setCellValueFactory(new PropertyValueFactory<>("dibiao"));
        t5_wandiancheci.setCellValueFactory(new PropertyValueFactory<>("wandiancheci"));
        t5_wandianshijian.setCellValueFactory(new PropertyValueFactory<>("wandianshijian"));
        t5_wandianzhant.setCellValueFactory(new PropertyValueFactory<>("wandianzhant"));

        t1_checi.setCellValueFactory(new PropertyValueFactory<>("checi"));
        t1_dibiao.setCellValueFactory(new PropertyValueFactory<>("dibiao"));
        t1_kaiche.setCellValueFactory(new PropertyValueFactory<>("kaichetime"));
        t1_shunhao.setCellValueFactory(new PropertyValueFactory<>("shunhao"));
        t1_wandian.setCellValueFactory(new PropertyValueFactory<>("wandiantime"));
        t1_xianshi.setCellValueFactory(new PropertyValueFactory<>("xianshitime"));
        t1_zhant.setCellValueFactory(new PropertyValueFactory<>("zhant"));
        t1_houche.setCellValueFactory(new PropertyValueFactory<>("houche"));

//
//        File file_now=new File(path_now);
//        String[][] data;
//        if(file_now.exists()){
//           data=new readexcel().result(path_now);
//        }else{
//             data=new readexcel().result(base_file_path);
//        }
//
//         for(int i=0;i<data.length;i++){
//             String now=df.format(new Date());
//             if(compare_time.comparetime(now,data[i][1],data[i][6])<0) {
//                 zhongkong zhongkong = new zhongkong();
//                 zhongkong.setCheci(data[i][0]);
//                // System.out.println(data[i][0]);
//                 zhongkong.setKaichetime(data[i][1]);
//                 zhongkong.setXianshitime(data[i][2]);
//                 zhongkong.setZhant(data[i][3]);
//                 zhongkong.setDibiao(data[i][4]);
//                 zhongkong.setShunhao(data[i][5]);
//                 zhongkong.setWandiantime(data[i][6]);
//                 zhongkong.setQuanneng(data[i][7]);
//                 data1.add(zhongkong);
//             }
//         }
        t1.setItems(data1);
        t2.setItems(data2);
        t3.setItems(data3);
        t4.setItems(data4);
        t5.setItems(data5);


        t1.setRowFactory(tv1->{
              TableRow<zhongkong> row=new TableRow<>();

              row.setOnDragDetected(event -> {
                  if (! row.isEmpty()) {
                      Integer index = row.getIndex();
                      Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
                      db.setDragView(row.snapshot(null, null));
                      ClipboardContent cc = new ClipboardContent();
                      cc.put(SERIALIZED_MIME_TYPE, index);
                      db.setContent(cc);
                      event.consume();
                  }
              });

              row.setOnDragOver(event -> {
                  Dragboard db = event.getDragboard();
                  if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                      if (row.getIndex() != ((Integer)db.getContent(SERIALIZED_MIME_TYPE)).intValue()) {
                          event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                          event.consume();
                      }
                  }
              });
//
//              row.setOnDragDropped(event -> {
//                  Dragboard db = event.getDragboard();
//                  if (db.hasContent(SERIALIZED_MIME_TYPE)) {
//                      int draggedIndex = (Integer) db.getContent(SERIALIZED_MIME_TYPE);
//                     zhongkong zhongkong = t1.getItems().remove(draggedIndex);
//
//                      int dropIndex ;
//
//                      if (row.isEmpty()) {
//                          dropIndex = t1.getItems().size() ;
//                      } else {
//                          dropIndex = row.getIndex();
//                      }
//
//                      t1.getItems().add(dropIndex, zhongkong);
//
//                      event.setDropCompleted(true);
//                      t1.getSelectionModel().select(dropIndex);
//                      event.consume();
//
//                  }
//              });
              return row;
          });
         t2.setRowFactory(tv2->{
             TableRow<checi> row=new TableRow<>();
             row.setOnDragOver(event -> {
                 Dragboard db = event.getDragboard();
                 if (db.hasContent(SERIALIZED_MIME_TYPE)&&t2.getItems().size()<4) {
                     //  if (row.getIndex() != ((Integer)db.getContent(SERIALIZED_MIME_TYPE)).intValue()) {
                     int draggedIndex = (Integer) db.getContent(SERIALIZED_MIME_TYPE);
                     zhongkong zzz=t1.getItems().get(draggedIndex);
                     if (Integer.parseInt(zzz.getHouche().trim())==1) {//1楼
                         event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                         event.consume();
                     }
                     //   }
                 }
             });

             row.setOnDragDropped(event -> {
                 Dragboard db = event.getDragboard();
                 if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                     int draggedIndex = (Integer) db.getContent(SERIALIZED_MIME_TYPE);
                     zhongkong z = t1.getItems().remove(draggedIndex);
                         int dropIndex;
                         if (t2.getItems().get(0).getchechi().equals("")) {
                             t2.getItems().remove(0);
                         }
                         if (row.isEmpty()) {
                             dropIndex = t2.getItems().size();
                             //   System.out.println(dropIndex);
                         } else {
                             dropIndex = row.getIndex();
                         }

                         t2.getItems().add(dropIndex, new checi(z));
                         event.setDropCompleted(true);
                        // t2.getSelectionModel().select(dropIndex);
                         event.consume();
                     }


             });

             return row;
         });
        t4.setRowFactory(tv4->{
            TableRow<checi> row=new TableRow<>();
            row.setOnDragOver(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasContent(SERIALIZED_MIME_TYPE)&&t4.getItems().size()<4) {
                    int draggedIndex = (Integer) db.getContent(SERIALIZED_MIME_TYPE);
                    zhongkong zzz=t1.getItems().get(draggedIndex);
                    if (Integer.parseInt(zzz.getHouche().trim())==2) {
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                        event.consume();
                    }
                }
            });

            row.setOnDragDropped(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                    int draggedIndex = (Integer) db.getContent(SERIALIZED_MIME_TYPE);
                    zhongkong z = t1.getItems().remove(draggedIndex);

                        int dropIndex2;
                        if (t4.getItems().get(0).getchechi().equals("")) {
                            t4.getItems().remove(0);
                        }
                        if (row.isEmpty()) {
                            dropIndex2 = t4.getItems().size();
                            //   System.out.println(dropIndex);
                        } else {
                            dropIndex2 = row.getIndex();
                        }
                        t4.getItems().add(dropIndex2, new checi(z));
                        event.setDropCompleted(true);
                     //   t4.getSelectionModel().select(dropIndex);

                        event.consume();
                    }
            });
            return row;
        });



        tijiao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                try {
                  tag=1;//防止读写冲突
                  wExcel(t2,t4,textarea.getText());
                  tag=0;
                  SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd-HH:mm");
                    ExecutorService executorService= Executors.newFixedThreadPool(config.ips.length);
                    for (int i=0;i<config.ips.length;i++) {
                        final int index=i;
                        executorService.execute(new Runnable() {
                            @Override
                            public void run() {
                                test.client client = new client(config.ips[index], 12306);
                                try {
                                    client.start("aaaaaaa#" + simpleDateFormat.format(new Date()));//防止传输过程中丢失
                                //    System.out.println(index);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    executorService.shutdown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        tijiao.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               tijiao.setEffect(colorAdjust_red);
            }
        });
        tijiao.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               tijiao.setEffect(null);
            }
        });



        base.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ExecutorService executorService= Executors.newFixedThreadPool(config.ips.length);
                    for (int i=0;i<config.ips.length;i++) {
                        final int index=i;
                        executorService.execute(new Runnable() {
                            @Override
                            public void run() {
                                test.client client = new client(config.ips[index], 12306);
                                try {
                                    client.start("bbbbbbbbbbbbbbbbbbbbb");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                    }
                    executorService.shutdown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        base.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                base.setEffect(colorAdjust_yellow);
            }
        });
        base.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                base.setEffect(null);
            }
        });


        jiache.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               final Stage stage=new Stage();
               stage.initModality(Modality.WINDOW_MODAL);
               Pane root=new Pane();
               Label l1=new Label("车次:");
               TextField t1=new TextField();

                JFXTimePicker blueDatePicker = new JFXTimePicker();
                blueDatePicker.setDefaultColor(Color.valueOf("#3f51b5"));
                blueDatePicker.setOverLay(true);

            l1.setLayoutX(0);
            l1.setLayoutY(0);
            t1.setLayoutX(150);
            t1.setLayoutY(0);
            blueDatePicker.setLayoutX(0);
            blueDatePicker.setLayoutY(150);
            root.getChildren().add(l1);
            root.getChildren().add(t1);
            root.getChildren().add(blueDatePicker);







                Scene scene = new Scene(root, 300, 250);
                stage.setScene(scene);
                stage.setTitle("加车");

                stage.show();


            }
        });





       t1.setEditable(true);
       t3.setEditable(true);
       t5.setEditable(true);
       t2.setEditable(true);
       t4.setEditable(true);
        t3_wandianshijian.setCellFactory(TextFieldTableCell.<wandian>forTableColumn());
        t5_wandianshijian.setCellFactory(TextFieldTableCell.<wandian>forTableColumn());
        t2_wandian.setCellFactory(TextFieldTableCell.<checi>forTableColumn());
        t4_wandian.setCellFactory(TextFieldTableCell.<checi>forTableColumn());
        t1_wandian.setCellFactory(TextFieldTableCell.<zhongkong>forTableColumn());
        t1_wandian.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<zhongkong,String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent event) {
                int index=t1.getSelectionModel().getFocusedIndex();
                zhongkong w= (zhongkong) event.getTableView().getItems().get(index);
                w.setWandiantime(new wandian_zhuanhuan().change((String) event.getNewValue()));
                event.getTableView().getItems().set(index,w);
                try {
                    wExcel_small(w.getCheci(),6,new wandian_zhuanhuan().change((String) event.getNewValue()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                int size=event.getTableView().getItems().size();
//                for(int j=0;j<size;j++){
//                    System.out.println(event.getTableView().getItems().get(j));
//                }
               // System.out.println(event.getTableView().getItems().get(index));
            }
        });
        t3_wandianshijian.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<wandian,String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent event) {
                int index=t3.getSelectionModel().getFocusedIndex();
                wandian w= (wandian) event.getTableView().getItems().get(index);
                w.setWandianshijian(new wandian_zhuanhuan().change((String) event.getNewValue()));
                event.getTableView().getItems().set(index,w);
                try {
                    wExcel_small(w.getWandiancheci(),6,new wandian_zhuanhuan().change((String) event.getNewValue()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                int size=event.getTableView().getItems().size();
//                for(int j=0;j<size;j++){
//                    System.out.println(event.getTableView().getItems().get(j));
//                }
                //System.out.println(event.getTableView().getItems().get(index));
            }
        });
        t5_wandianshijian.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<wandian,String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent event) {
                int index=t5.getSelectionModel().getFocusedIndex();
                wandian w= (wandian) event.getTableView().getItems().get(index);

                w.setWandianshijian(new wandian_zhuanhuan().change((String) event.getNewValue()));
                event.getTableView().getItems().set(index,w);
                try {
                    wExcel_small(w.getWandiancheci(),6,new wandian_zhuanhuan().change((String) event.getNewValue()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                int size=event.getTableView().getItems().size();
//                for(int j=0;j<size;j++){
//                    System.out.println(event.getTableView().getItems().get(j));
//                }
                //System.out.println(event.getTableView().getItems().get(index));
            }
        });
       t2_wandian.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<checi, String>>() {
           @Override
           public void handle(TableColumn.CellEditEvent<checi, String> event) {
               int index=t2.getSelectionModel().getFocusedIndex();
               checi w=(checi)event.getTableView().getItems().get(index);
               w.setWandianshijian(new wandian_zhuanhuan().change((String) event.getNewValue()));
               event.getTableView().getItems().set(index,w);
               try {
                   wExcel_small(w.getWandianshijian(),6,new wandian_zhuanhuan().change((String) event.getNewValue()));
                   t2.getItems().remove(index);
                   t3.getItems().add(new wandian(w));
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });
        t4_wandian.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<checi, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<checi, String> event) {
                int index=t4.getSelectionModel().getFocusedIndex();
                checi w=(checi)event.getTableView().getItems().get(index);
                w.setWandianshijian(new wandian_zhuanhuan().change((String) event.getNewValue()));
                event.getTableView().getItems().set(index,w);
                try {
                    wExcel_small(w.getWandianshijian(),6,new wandian_zhuanhuan().change((String) event.getNewValue()));
                    t4.getItems().remove(index);
                    t5.getItems().add(new wandian(w));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });




        t1_zhant.setCellFactory(TextFieldTableCell.<zhongkong>forTableColumn());
        t1_zhant.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<zhongkong, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<zhongkong, String> event) {
                int index=t1.getSelectionModel().getFocusedIndex();
                zhongkong z=(zhongkong) event.getTableView().getItems().get(index);
                z.setZhant(" "+(String)event.getNewValue());
                try {
                    wExcel_small(z.getCheci(),3," "+(String)event.getNewValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t1_houche.setCellFactory(TextFieldTableCell.<zhongkong>forTableColumn());
        t1_houche.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<zhongkong, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<zhongkong, String> event) {
                int index=t1.getSelectionModel().getFocusedIndex();
                zhongkong z=(zhongkong) event.getTableView().getItems().get(index);
                z.setHouche((String)event.getNewValue());
                try {
                    wExcel_small(z.getCheci(),9," "+(String)event.getNewValue());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        t1_shunhao.setCellFactory(TextFieldTableCell.<zhongkong>forTableColumn());
        t1_shunhao.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<zhongkong, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<zhongkong, String> event) {
                int index=t1.getSelectionModel().getFocusedIndex();
                zhongkong z=(zhongkong) event.getTableView().getItems().get(index);
               z.setShunhao(event.getNewValue());
               z.setDibiao(shunhao_yanse.change(event.getNewValue()));
                try {
                    wExcel_small(z.getCheci(),5,event.getNewValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

         t1.setOnMouseClicked(new EventHandler<MouseEvent>() {//删除车次
             @Override
             public void handle(MouseEvent event) {
                 if(event.getClickCount()==3){
                     int index=t1.getSelectionModel().getFocusedIndex();
                     Alert confirmation=new Alert(Alert.AlertType.CONFIRMATION,"确认删除该车次吗？");
                   confirmation.setHeaderText("删除？");
                     Optional<ButtonType> result=confirmation.showAndWait();
                     if (result.isPresent()&&result.get()==ButtonType.OK){
                         excel_delete(new checi(t1.getItems().get(index)));
                         t1.getItems().remove(index);

                     }

                 }
             }
         });



        File file_now=new File(path_now);
        List<zhongkong> list1=new ArrayList<>();
        List<checi> list2=new ArrayList<>();
        List<wandian> list3=new ArrayList<>();
        List<checi> list4=new ArrayList<>();
        List<wandian> list5=new ArrayList<>();

        timer_zhukong.schedule(new TimerTask() {

            @Override
            public void run() {//自动运行的方法，t2，t3
                if (tag>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String now=df.format(new Date());
                list1.clear();
                list2.clear();
                list3.clear();
                list4.clear();
                list5.clear();

                String[][] data;
                if(file_now.exists()){
                    data=new readexcel().result(path_now);
                }else{
                    data=new readexcel().result(base_file_path);
                }

                for(int i=0;i<data.length;i++){

                    if(compare_time.comparetime(now,data[i][1],data[i][6],config.tingjian_time)<0) {
                        zhongkong zhongkong = new zhongkong();
                        zhongkong.setCheci(data[i][0]);
                        zhongkong.setKaichetime(data[i][1]);
                        zhongkong.setXianshitime(data[i][2]);
                        zhongkong.setZhant(data[i][3]);
                        zhongkong.setDibiao(data[i][4]);
                        zhongkong.setShunhao(data[i][5]);
                        zhongkong.setWandiantime(data[i][6]);
                        zhongkong.setQuanneng(data[i][7]);
                        zhongkong.setHouche(data[i][9].trim());

                      //  data1.add(zhongkong);
                        if (!zhongkong.getHouche().isEmpty()&&Integer.parseInt(zhongkong.getHouche())==1){//1候车厅
                                 if (compare_time.comparetime(now,zhongkong.getXianshitime(),zhongkong.getWandiantime(),0)>=0&&list2.size()<4){
                                     list2.add(new checi(zhongkong));
                                     continue;
                                 } else if (!zhongkong.getWandiantime().equals("")){
                                     list3.add(new wandian(zhongkong));
                                    continue;
                                 }
                        }
                        if (!zhongkong.getHouche().isEmpty()&&Integer.parseInt(zhongkong.getHouche())>1){//2候车厅
                            if (compare_time.comparetime(now,zhongkong.getXianshitime(),zhongkong.getWandiantime(),0)>=0&&list4.size()<4){
                                list4.add(new checi(zhongkong));
                                continue;

                            }else if (!zhongkong.getWandiantime().equals("")){
                                list5.add(new wandian(zhongkong));
                                 continue;
                            }
                        }

                        list1.add(zhongkong);

                    }
                }
                if (!textarea.getText().equals(data[0][8]))
                         textarea.setText(data[0][8]);



                if (list2.size()==0){
                    list2.add(new checi());
                }
                if (list4.size()==0){
                    list4.add(new checi());
                }
                compare_wandian compare_wandian=new compare_wandian();
                if (!compare_wandian.compare_zhongkong(list1,data1)){
                    data1.clear();
                    data1.addAll(list1);
                }
                if (!compare_wandian.compare_checi(list2,data2)){
                    data2.clear();
                    data2.addAll(list2);
                }
                if (!compare_wandian.compare_wandian(list3,data3)){
                    data3.clear();
                    data3.addAll(list3);
                }
                if (!compare_wandian.compare_checi(list4,data4)){
                    data4.clear();
                    data4.addAll(list4);
                }
                if (!compare_wandian.compare_wandian(list5,data5)){
                    data5.clear();
                    data5.addAll(list5);
                }




//                for(int k=0;k<t2.getItems().size();k++){//删除t2中已经到时间的数据
//                    if(t2.getItems().size()>0&&!t2.getItems().get(k).getchechi().equals("")) {
//                        if (compare_time.comparetime(now, t2.getItems().get(k).getKaicheshijian(),t2.getItems().get(k).getWandianshijian()) >= 0) {
//                            t2.getItems().remove(k);
//                            k=0;
//                        }
//                    }
//
//                    if (t2.getItems().size()==0){//添加一个空的
//                        t2.getItems().add(new checi());
//                    }
//                }
//
//                for(int g=0;g<t3.getItems().size();g++){//t3中的数据处理，删除到时间的，移动要显示的
//                    if(t3.getItems().size()>0) {
//                        if (compare_time.comparetime(now, t3.getItems().get(g).getKaicheshijian(), t3.getItems().get(g).getWandianshijian()) >= 0) {
//                            t3.getItems().remove(g);
//                            g=0;
//
//                        }
//                        if (compare_time.comparetime(now, t3.getItems().get(g).getXianshishijian(), t3.getItems().get(g).getWandianshijian()) >= 0) {
//                            if (t2.getItems().get(0).getchechi().equals("")){
//                                      t2.getItems().remove(0);
//                            }
//                            if (t2.getItems().size() < 4) {
//                                wandian w = t3.getItems().remove(g);
//                                t2.getItems().add(new checi(w));
//                                g=0;
//                            }
//                        }
//                    }
//                }
//
//
//                for(int k=0;k<t4.getItems().size();k++){//删除t4中已经到时间的数据
//                    if(t4.getItems().size()>0&&!t4.getItems().get(k).getchechi().equals("")) {
//                        if (compare_time.comparetime(now, t4.getItems().get(k).getKaicheshijian(),t4.getItems().get(k).getWandianshijian()) >= 0) {
//                            t4.getItems().remove(k);
//                            k=0;
//                        }
//                    }
//                    if (t4.getItems().size()==0){//添加一个空的
//                        t4.getItems().add(new checi());
//                    }
//                }
//
//                for(int g=0;g<t5.getItems().size();g++){//t5中的数据处理，删除到时间的，移动要显示的
//                    if(t5.getItems().size()>0) {
//                        if (compare_time.comparetime(now, t5.getItems().get(g).getKaicheshijian(), t5.getItems().get(g).getWandianshijian()) >= 0) {
//                            t5.getItems().remove(g);
//                            g=0;
//
//                        }
//                        if (compare_time.comparetime(now, t5.getItems().get(g).getXianshishijian(), t5.getItems().get(g).getWandianshijian()) >= 0) {
//                            if (t4.getItems().get(0).getchechi().equals("")){
//                                t4.getItems().remove(0);
//                            }
//                            if (t4.getItems().size() < 4) {
//                                wandian w = t5.getItems().remove(g);
//                                t4.getItems().add(new checi(w));
//                                g=0;
//                            }
//
//
//                        }
//                    }
//                }
//
//
//
//                for(int i=0;i<t1.getItems().size();i++){//处理t1
//                    if (t1.getItems().get(i).getZhant().trim().equals("1")) {
//                        if (compare_time.comparetime(now, t1.getItems().get(i).getXianshitime(), t1.getItems().get(i).getWandiantime()) >= 0) {
//                            if (t2.getItems().get(0).getchechi().equals("")) {
//                                t2.getItems().remove(0);
//                            }
//                            if (t2.getItems().size() < 4) {
//                                zhongkong zhongkong = t1.getItems().remove(i);
//                                t2.getItems().add(new checi(zhongkong));
//                                if (i > 0) {
//                                    i = -1;//因为for循环后会直接更新i
//                                    continue;
//                                }
//                            }
//                        }
//                        if (!t1.getItems().get(i).getWandiantime().equals("")) {
//                            zhongkong zhongkong = t1.getItems().remove(i);
//                            t3.getItems().add(new wandian(zhongkong));
//                            if (i > 0) {
//                                i = -1;//因为for循环后会直接更新i
//                                continue;
//                            }
//                        }
//
//                    }//处理一站台
//
//
//                    if (Integer.parseInt(t1.getItems().get(i).getZhant().trim())>1) {//二三四站台
//                        if (compare_time.comparetime(now, t1.getItems().get(i).getXianshitime(), t1.getItems().get(i).getWandiantime()) >= 0) {
//                            if (t4.getItems().get(0).getchechi().equals("")) {
//                                t4.getItems().remove(0);
//                            }
//                            if (t4.getItems().size() < 4) {
//                                zhongkong zhongkong = t1.getItems().remove(i);
//                                t4.getItems().add(new checi(zhongkong));
//                                if (i > 0) {
//                                    i = -1;//因为for循环后会直接更新i
//                                    continue;
//                                }
//                            }
//
//
//                        }
//                        if (!t1.getItems().get(i).getWandiantime().equals("")) {
//                            zhongkong zhongkong = t1.getItems().remove(i);
//                            t5.getItems().add(new wandian(zhongkong));
//                            if (i > 0) {
//                                i = -1;//因为for循环后会直接更新i
//                                continue;
//                            }
//                        }
//
//                    }//处理二三四站台
//                }
//                for(int i=0;i<t1.getItems().size();i++){//处理t1,再次循环一遍
//                     if (t1.getItems().get(i).getZhant().trim().equals("1")) {
//                         if (compare_time.comparetime(now, t1.getItems().get(i).getXianshitime(), t1.getItems().get(i).getWandiantime()) >= 0) {
//                             if (t2.getItems().get(0).getchechi().equals("")) {
//                                 t2.getItems().remove(0);
//                             }
//                             if (t2.getItems().size() < 4) {
//                                 zhongkong zhongkong = t1.getItems().remove(i);
//                                 t2.getItems().add(new checi(zhongkong));
//                             }
//                         }
//                         if (!t1.getItems().get(i).getWandiantime().equals("")) {
//                             zhongkong zhongkong = t1.getItems().remove(i);
//                             t3.getItems().add(new wandian(zhongkong));
//                         }
//                     }else{
//                         if (compare_time.comparetime(now, t1.getItems().get(i).getXianshitime(), t1.getItems().get(i).getWandiantime()) >= 0) {
//                             if (t4.getItems().get(0).getchechi().equals("")) {
//                                 t4.getItems().remove(0);
//                             }
//                             if (t4.getItems().size() < 4) {
//                                 zhongkong zhongkong = t1.getItems().remove(i);
//                                 t4.getItems().add(new checi(zhongkong));
//                             }
//                         }
//                         if (!t1.getItems().get(i).getWandiantime().equals("")) {
//                             zhongkong zhongkong = t1.getItems().remove(i);
//                             t5.getItems().add(new wandian(zhongkong));
//                         }
//                     }
//                }//第二次循环
            }
        },0,60*1000);
    }

    final String theQuannneng[]={"a","b","c","d"};
    private void excel_delete(checi c){
        File file_now=new File(base_path+"\\"+df_year.format(new Date())+".xls");//写excel路径

        String[][] data;
        if(file_now.exists()){
            data=new readexcel().result(path_now);
        }else{
            data=new readexcel().result(base_file_path);
            try {
                file_now.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        for (int i=0;i<data.length;i++){
            if (data[i][0].equals(c.getchechi())&&data[i][4].equals(c.getdibiao())){
                for (int j=0;j<8;j++){
                    data[i][j]="";
                }
                data[i][9]="";
                break;
            }
        }

try{
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet("Sheet1");
        HSSFRow r=sheet.createRow(0);
        int col=0;
        HSSFCell c1=r.createCell(col);
        c1.setCellValue("车次");
        col++;
        HSSFCell c2=r.createCell(col);
        c2.setCellValue("开车时间");
        col++;
        HSSFCell c3=r.createCell(col);
        c3.setCellValue("显示时间");
        col++;
        HSSFCell c4=r.createCell(col);
        c4.setCellValue("站台");
        col++;
        HSSFCell c5=r.createCell(col);
        c5.setCellValue("地标");
        col++;
        HSSFCell c8=r.createCell(col);
        c8.setCellValue("车厢");
        col++;
        HSSFCell c6=r.createCell(col);
        c6.setCellValue("晚点时间");
        col++;
        HSSFCell c7=r.createCell(col);
        c7.setCellValue("权能");
        col++;
        col++;
        HSSFCell c9=r.createCell(col);
        c9.setCellValue("候车");


        for (int j=1;j<data.length+1;j++){

            HSSFRow rr=sheet.createRow(j);
            for (int k=0;k<data[j-1].length;k++){
                HSSFCell cell=rr.createCell(k);
                cell.setCellValue(data[j-1][k]);
            }
        }
        FileOutputStream out=new FileOutputStream(file_now);
        workbook.write(out);
        out.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }







    }
    private void wExcel(TableView<checi> t2,TableView<checi> t4,String text) throws Exception{//写t2
              File file_now=new File(base_path+"\\"+df_year.format(new Date())+".xls");//写excel路径

        String[][] data;
        if(file_now.exists()){
            data=new readexcel().result(path_now);
        }else{
            data=new readexcel().result(base_file_path);
            file_now.createNewFile();
        }
        try {
            data[0][8]=text;
            for (int i=0;i<data.length;i++){
                data[i][7]="e";
            }

//            for (int i=0;i<t1.getItems().size();i++){
//                       String cc=t1.getItems().get(i).getCheci();
//                       for (int j=0;j<data.length;j++){
//                           if (data[j][0].equals(cc)){
//                               data[j][6]=t1.getItems().get(i).getWandiantime();
//                               continue;
//                           }
//                       }
//            }//t1的晚点写入，现在不需要了
//            for (int i=0;i<t3.getItems().size();i++){
//                String cc=t3.getItems().get(i).getWandiancheci();
//                for (int j=0;j<data.length;j++){
//                    if (data[j][0].equals(cc)){
//                        data[j][6]=t3.getItems().get(i).getWandianshijian();
//                        continue;
//                    }
//                }
//            }//t3的晚点写入
            for(int i=0;i<t2.getItems().size();i++){
                String cc=t2.getItems().get(i).getchechi();
                for(int j=0;j<data.length;j++){
                    if (data[j][0].equals(cc)){
                       data[j][7]=theQuannneng[i];

                        continue;
                    }
                }
            }
//            for (int i=0;i<t5.getItems().size();i++){
//                String cc=t5.getItems().get(i).getWandiancheci();
//                for (int j=0;j<data.length;j++){
//                    if (data[j][0].equals(cc)){
//                        data[j][6]=t5.getItems().get(i).getWandianshijian();
//                        continue;
//                    }
//                }
//            }//t5的晚点写入
            for(int i=0;i<t4.getItems().size();i++){
                String cc=t4.getItems().get(i).getchechi();
                for(int j=0;j<data.length;j++){
                    if (data[j][0].equals(cc)){
                        data[j][7]=theQuannneng[i];

                        continue;
                    }
                }
            }


            HSSFWorkbook workbook=new HSSFWorkbook();
            HSSFSheet sheet=workbook.createSheet("Sheet1");
            HSSFRow r=sheet.createRow(0);
            int col=0;
            HSSFCell c1=r.createCell(col);
            c1.setCellValue("车次");
            col++;
            HSSFCell c2=r.createCell(col);
            c2.setCellValue("开车时间");
            col++;
            HSSFCell c3=r.createCell(col);
            c3.setCellValue("显示时间");
            col++;
            HSSFCell c4=r.createCell(col);
            c4.setCellValue("站台");
            col++;
            HSSFCell c5=r.createCell(col);
            c5.setCellValue("地标");
            col++;
            HSSFCell c8=r.createCell(col);
            c8.setCellValue("车厢");
            col++;
            HSSFCell c6=r.createCell(col);
            c6.setCellValue("晚点时间");
            col++;
            HSSFCell c7=r.createCell(col);
            c7.setCellValue("权能");
            col++;
            col++;
            HSSFCell c9=r.createCell(col);
            c9.setCellValue("候车");


            for (int j=1;j<data.length+1;j++){

                  HSSFRow rr=sheet.createRow(j);
                  for (int k=0;k<data[j-1].length;k++){
                      HSSFCell cell=rr.createCell(k);
                      cell.setCellValue(data[j-1][k]);
                  }
            }
            FileOutputStream out=new FileOutputStream(file_now);
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

   private void wExcel_small(String checi,int index,String value) throws Exception{
        tag=1;
       File file_now=new File(base_path+"\\"+df_year.format(new Date())+".xls");//写excel路径
       String[][] data;
       if(file_now.exists()){
           data=new readexcel().result(path_now);
       }else{
           data=new readexcel().result(base_file_path);
           file_now.createNewFile();
       }

       for (int i=0;i<data.length;i++){
           if (data[i][0].equals(checi)){
               data[i][index]=value;

               if (index==5){
                   data[i][4]=shunhao_yanse.change(value);
               }

           }
       }

       HSSFWorkbook workbook=new HSSFWorkbook();
       HSSFSheet sheet=workbook.createSheet("Sheet1");
       HSSFRow r=sheet.createRow(0);
       int col=0;
       HSSFCell c1=r.createCell(col);
       c1.setCellValue("车次");
       col++;
       HSSFCell c2=r.createCell(col);
       c2.setCellValue("开车时间");
       col++;
       HSSFCell c3=r.createCell(col);
       c3.setCellValue("显示时间");
       col++;
       HSSFCell c4=r.createCell(col);
       c4.setCellValue("站台");
       col++;
       HSSFCell c5=r.createCell(col);
       c5.setCellValue("地标");
       col++;
       HSSFCell c8=r.createCell(col);
       c8.setCellValue("车厢");
       col++;
       HSSFCell c6=r.createCell(col);
       c6.setCellValue("晚点时间");
       col++;
       HSSFCell c7=r.createCell(col);
       c7.setCellValue("权能");
       col++;
       col++;
       HSSFCell c9=r.createCell(col);
       c9.setCellValue("候车");


       for (int j=1;j<data.length+1;j++){
           HSSFRow rr=sheet.createRow(j);
           for (int k=0;k<data[j-1].length;k++){
               HSSFCell cell=rr.createCell(k);
               cell.setCellValue(data[j-1][k]);
           }
       }

       FileOutputStream out=new FileOutputStream(file_now);
       workbook.write(out);
       out.close();
       tag=0;//读写保护

}

}
