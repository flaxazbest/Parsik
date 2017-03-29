package ua.azbest.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import ua.azbest.colors.*;

public class MainController {

    @FXML
    CheckBox chb;

    @FXML
    public void initialize(){

    }

    @FXML
    public void onClickMethod(){
        chb.setText("Thanks!");
    }

}
