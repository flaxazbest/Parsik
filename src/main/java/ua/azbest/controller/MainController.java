package ua.azbest.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainController {

    @FXML
    CheckBox chb;
    @FXML
    Button parse;
    @FXML
    ChoiceBox chip;

    @FXML
    public void initialize(){
        chip.getItems().addAll("sdfg","gfhjgh","rtyer");
    }

    @FXML
    public void onClickMethod(){
        chb.setText("Thanks!");
    }

}
