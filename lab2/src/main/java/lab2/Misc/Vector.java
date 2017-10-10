package lab2.Misc;

public class Vector {

    private final double x, y, z,h;

    public Vector(double x, double y, double z, double h) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.z = z;
    }

    // scalar production
    public static double dotProduct(Vector a,Vector b) {
        return a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
    }

    // vector production
    public static Vector crossProduct(Vector a,Vector b) {
        return new Vector(
                a.getY() * b.getZ() - a.getZ() * b.getY(),
                a.getZ() * b.getX() - a.getX() * b.getZ(),
                a.getX() * b.getY() - a.getY() * b.getX(),
                a.getH());
    }

    public static double tripleProduct(Vector a,Vector b,Vector c){
        return dotProduct(a,crossProduct(b,c));
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
