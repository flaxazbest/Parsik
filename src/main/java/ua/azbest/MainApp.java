package ua.azbest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/hello.fxml";
        String styleFile = "/styles/slider.css";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("Color converter");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        //scene.getStylesheets().add(MainApp.class.getResource(styleFile).toExternalForm());
        stage.show();
    }
}