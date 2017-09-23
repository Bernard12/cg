package lab.Misc;

public class Vector {
    private final double x,y,h;

    public Vector(double x, double y, double h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final double getH() {
        return h;
    }
}
