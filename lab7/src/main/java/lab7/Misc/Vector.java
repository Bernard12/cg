package lab7.Misc;

public class Vector {
    private double x,y,h;

    public Vector(double x, double y, double h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getH() {
        return h;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setH(double h) {
        this.h = h;
    }
}
