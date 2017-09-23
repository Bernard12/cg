package lab;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import lab.CustomCanvas.MyCanvas;
import lab.Misc.TMatrix;

public class Controller {

    @FXML
    private void initialize() {
        Slider[] params = {pA, pB, pa, pb, pStep};

        TMatrix state = new TMatrix(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}}
                );
        Graphic graphic = new Graphic(params);

        MyCanvas canvas = new MyCanvas(
                center.getPrefWidth(),
                center.getPrefHeight()
        );

        AnchorPane.setTopAnchor(canvas, 0.0);
        AnchorPane.setBottomAnchor(canvas, 0.0);
        AnchorPane.setLeftAnchor(canvas, 0.0);
        AnchorPane.setRightAnchor(canvas, 0.0);

        for (Slider slider : params) {
            slider.valueProperty().addListener((observableValue, number, t1) -> {
                canvas.resize(canvas.getWidth(),canvas.getHeight());
                graphic.draw(canvas,state);
            });
        }

        center.getChildren().add(canvas);
    }

    @FXML
    private AnchorPane center;

    @FXML
    private Slider pA;

    @FXML
    private Slider pB;

    @FXML
    private Slider pa;

    @FXML
    private Slider pb;

    @FXML
    private Slider pStep;

}
