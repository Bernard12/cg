package lab7.Misc;

import javafx.scene.paint.Color;

public class MyCircle {

    private Vector center;
    private int r;
    private Color col;

    public MyCircle(Vector center, int r, Color c) {
        this.center = center;
        this.r = r;
        this.col = c;
    }

    public Vector getCenter() {
        return center;
    }

    public void setCenter(Vector center) {
        this.center = center;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Color getCol() {
        return col;
    }

    public void setCol(Color col) {
        this.col = col;
    }
}
