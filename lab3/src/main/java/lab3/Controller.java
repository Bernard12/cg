package lab3;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import lab3.CustomCanvas.MyCanvas;
import lab3.Misc.Light;
import lab3.Misc.TMatrix;

public class Controller {

    @FXML
    private AnchorPane center;

    @FXML
    private Slider approx;

    @FXML
    private Slider sides;

    @FXML
    private Slider red;

    @FXML
    private Slider green;

    @FXML
    private Slider blue;

    @FXML
    private void initialize() {
        TMatrix state = new TMatrix(new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 2}}
        );


        MyCanvas canvas = new MyCanvas(
                center.getPrefWidth(),
                center.getPrefHeight(),
                new Light(Color.BLACK),
                state
        );

        Figure fig = new Figure(30,10);
        canvas.setFig(fig);
        double width = center.getPrefWidth();
        double height = center.getPrefHeight();

        RotationHandler rot = new RotationHandler(canvas,state);

        AnchorPane.setTopAnchor(canvas, 0.0);
        AnchorPane.setBottomAnchor(canvas, 0.0);
        AnchorPane.setLeftAnchor(canvas, 0.0);
        AnchorPane.setRightAnchor(canvas, 0.0);

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,rot);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,rot);

        approx.valueProperty().addListener((observableValue, oldV, newV) -> {
            System.out.println(newV);
            fig.setApprox(2*(int)newV.doubleValue());
            canvas.resize(canvas.getWidth(),canvas.getHeight());
        });

        center.getChildren().add(canvas);
    }
}
