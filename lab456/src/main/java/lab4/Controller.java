package lab4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;


public class Controller {


    @FXML
    private Slider r;

    @FXML
    private Slider g;

    @FXML
    private Slider b;

    @FXML
    private Slider amb;

    @FXML
    private Slider dif;

    @FXML
    private Slider spec;

    @FXML
    private Button bt;

    @FXML
    private void initialize() {
        bt.setOnAction(event -> {
            System.out.println(1);
            Main.red = (float) r.getValue();
            Main.green = (float) g.getValue();
            Main.blue = (float) b.getValue();
            Main.amb = (float) amb.getValue();
            Main.dif = (float) dif.getValue();
            Main.spec = (float) spec.getValue();
        });
    }
}
