package ua.azbest.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import ua.azbest.dao.VideocardDAO;
import ua.azbest.parser.CoreParser;
import ua.azbest.parser.VideoParser;
import ua.azbest.part.Videocard;

public class MainController {

    @FXML
    CheckBox chb;
    @FXML
    Button parse;
    @FXML
    Button tobase;
    @FXML
    ChoiceBox chip;


    public void initialize(){
        chip.getItems().addAll("sdfg","gfhjgh","rtyer");
    }

    @FXML
    public void toBase() {
        VideocardDAO.create(new VideoParser().getList());
    }

    @FXML
    public void onClickMethod(){
        chb.setText("Thanks!");
        CoreParser coreParser = new CoreParser();
        coreParser.getList();
    }

}
