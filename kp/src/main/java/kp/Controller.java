package kp;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import kp.CustomCanvas.MyCanvas;
import kp.Misc.TMatrix;
import kp.Misc.Vector;

import java.util.ArrayList;

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
        ArrayList<ArrayList<Vector>> p = new ArrayList<>();
        ArrayList<Vector> l1 = new ArrayList<>();
        l1.add(new Vector(-10,-10,-5,1));
        l1.add(new Vector(-5,-10,5,1));
        l1.add(new Vector(5,-10,5,1));
        l1.add(new Vector(10,-10,-5,1));
        ArrayList<Vector> l2 = new ArrayList<>();
        l2.add(new Vector(-10,-5,0,1));
        l2.add(new Vector(-5,-5,0,1));
        l2.add(new Vector(5,-5,0,1));
        l2.add(new Vector(10,-5,0,1));
        ArrayList<Vector> l3 = new ArrayList<>();
        l3.add(new Vector(-10,5,0,1));
        l3.add(new Vector(-5,5,0,1));
        l3.add(new Vector(5,5,0,1));
        l3.add(new Vector(10,5,0,1));
        ArrayList<Vector> l4 = new ArrayList<>();
        l4.add(new Vector(-10,10,5,1));
        l4.add(new Vector(-5,10,0,1));
        l4.add(new Vector(5,10,5,1));
        l4.add(new Vector(10,10,0,1));
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);

        Figure fig = new Figure(p);
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
