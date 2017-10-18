package lab1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
    @author  Simakhinm Ivan
    Option 17:
    x = a * t + b * sin(t)
    y = a - b * cos(t)
    @value t is from A to B
 */

public class Main extends Application {

    /*
        Starting point
     */
    @Override
    public void start(Stage stage) throws Exception{
        final Parent root = FXMLLoader.load(getClass().getResource("/scheme/lab1.fxml"));
        final Scene scene = new Scene(root,600,400);
        stage.setTitle("Лабораторная работа 1");
        stage.setScene(scene);
        stage.show();
        stage.setMinWidth(scene.getWindow().getWidth());
        stage.setMinHeight(scene.getWindow().getHeight());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
