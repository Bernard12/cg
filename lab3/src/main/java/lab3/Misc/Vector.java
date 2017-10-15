package lab3.Misc;


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

    public static Vector sub(Vector a,Vector b) {
        return new Vector(
                b.getX() - a.getX(),
                b.getY() - a.getY(),
                b.getZ() - a.getZ(),
                b.getH()
        );
    }

    public static double degree(Vector a, Vector b){
        double res = Vector.dotProduct(a,b);
        res /= a.lenght();
        res /= b.lenght();
        return Math.toDegrees(Math.acos(res));
    }

    public final double lenght(){
        return Math.sqrt(x*x + y*y + z*z);
    }

    public final double getX() {
        return x;
    }

    public final double getY() {
        return y;
    }

    public final double getH() {
        return h;
    }

    public final double getZ() {
        return z;
    }
}
