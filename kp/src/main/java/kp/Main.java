package kp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        final Parent root = FXMLLoader.load(getClass().getResource("/scheme2/lab2.fxml"));
        final Scene scene = new Scene(root);
        stage.setTitle("Лабораторная работа №3(Бочка), Симахин Иван");
        stage.setScene(scene);
        stage.show();
        stage.setMinWidth(scene.getWindow().getWidth());
        stage.setMinHeight(scene.getWindow().getHeight());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
