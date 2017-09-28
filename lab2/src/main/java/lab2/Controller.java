package lab2;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import lab2.CustomCanvas.MyCanvas;
import lab2.Misc.TMatrix;

public class Controller {

    @FXML
    private AnchorPane center;

    @FXML
    private void initialize() {
        TMatrix state = new TMatrix(new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}}
        );

        MyCanvas canvas = new MyCanvas(
                center.getPrefWidth(),
                center.getPrefHeight()
        );

        /*double width = center.getPrefWidth();
        double height = center.getPrefHeight();

        AnchorPane.setTopAnchor(canvas, 0.0);
        AnchorPane.setBottomAnchor(canvas, 0.0);
        AnchorPane.setLeftAnchor(canvas, 0.0);
        AnchorPane.setRightAnchor(canvas, 0.0);

        canvas.widthProperty().addListener((observableValue, number, t1) -> {
            double sc = t1.doubleValue() / width;
            state.getMatrix()[2][2] = sc;
        });
        canvas.heightProperty().addListener((observableValue, number, t1) -> {
            double sc = t1.doubleValue() / height;
            state.getMatrix()[2][2] = sc;
        });*/

        center.getChildren().add(canvas);
    }

}
