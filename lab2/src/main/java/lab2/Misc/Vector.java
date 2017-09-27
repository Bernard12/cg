package lab2.Misc;

public class Vector {

    private final double x, y, z,h;

    public Vector(double x, double y, double z, double h) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.z = z;
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

    public final double getZ() {
        return z;
    }
}
