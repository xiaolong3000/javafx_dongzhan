package service;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Border;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static javafx.scene.paint.Color.*;

/**
 * Created by Administrator on 2017/8/4 0004.
 */
public class MyTC_checi extends TableCell<checi,String> {
 private TableColumn<checi, String> param;
    @Override
    protected void updateItem(String  item, boolean empty) {
        super.updateItem(item, empty);
        this.setBorder(Border.EMPTY);

        if (!isEmpty()) {
            setFont(Font.font("微软雅黑", FontWeight.BOLD,32));
            String color=param.getTableView().getItems().get(this.getIndex()).toString();
            if (color.contains("红色"))
                this.setTextFill(RED);
            if (color.contains("绿色"))
                this.setTextFill(GREEN);
            if (color.contains("黄色"))
                this.setTextFill(YELLOW);
            if (color.contains("蓝色"))
                this.setTextFill(BLUE);


            setText(item);

        }
    }
   public MyTC_checi(TableColumn<checi, String> param){
        this.param=param;
    }
}
