package kp;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import kp.CustomCanvas.MyCanvas;
import kp.Misc.TMatrix;

public class Controller {

    @FXML
    private AnchorPane center;

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
                state
        );
        Figure fig = new Figure(50,25);
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
        center.getChildren().add(canvas);
    }

}
