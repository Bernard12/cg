package lab7;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import lab7.CustomCanvas.MyCanvas;
import lab7.Misc.TMatrix;
import lab7.Misc.Vector;

import java.util.ArrayList;

/*
    Class to connect view(data from window) and logic
 */
public class Controller {

    @FXML
    private AnchorPane cent7;

    @FXML
    private Slider w1;

    @FXML
    private Slider w2;

    @FXML
    private Slider w3;

    @FXML
    private Slider w4;

    @FXML
    private Slider w5;

    @FXML
    private void initialize() {
        Slider[] params = {w1, w2, w3, w4, w5};
        ArrayList<Vector> points = new ArrayList<>();
        points.add(new Vector(-8, 4, 10));
        points.add(new Vector(-6, 5, 10));
        points.add(new Vector(0, 3, 10));
        points.add(new Vector(6, 5, 10));
        points.add(new Vector(8, 4, 10));

        TMatrix state = new TMatrix(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}}
        );
        Graphic graphic = new Graphic(params,points);

        MyCanvas canvas = new MyCanvas(
                cent7.getPrefWidth(),
                cent7.getPrefHeight()
        );
        double width = cent7.getPrefWidth();
        double height = cent7.getPrefHeight();

        AnchorPane.setTopAnchor(canvas, 0.0);
        AnchorPane.setBottomAnchor(canvas, 0.0);
        AnchorPane.setLeftAnchor(canvas, 0.0);
        AnchorPane.setRightAnchor(canvas, 0.0);

        for (Slider slider : params) {
            slider.valueProperty().addListener((observableValue, number, t1) -> {
                canvas.init();
                graphic.draw(canvas, state);
            });
        }

        canvas.widthProperty().addListener((observableValue, number, t1) -> {
            double sc = t1.doubleValue()/width;
            state.getMatrix()[2][2] = sc;
        });
        canvas.heightProperty().addListener((observableValue, number, t1) -> {
            double sc = t1.doubleValue()/height;
            state.getMatrix()[2][2] = sc;
        });

        cent7.getChildren().add(canvas);
    }

}
