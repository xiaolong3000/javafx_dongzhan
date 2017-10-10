package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class jiache_control implements Initializable{
    @FXML
    private TextField checi;
    @FXML
    private TextField kaiche;
    @FXML
    private TextField xianshi;
    @FXML
    private TextField zhant;
    @FXML
    private TextField dibiao;
    @FXML
    private TextField shunhao;
    @FXML
    private TextField houche;
    @FXML
    private Button button;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }
}
