package lab1;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import lab1.CustomCanvas.MyCanvas;
import lab1.Misc.TMatrix;

public class Controller {

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
        double width = center.getPrefWidth();
        double height = center.getPrefHeight();

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

        center.getChildren().add(canvas);
    }

}
