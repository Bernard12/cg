package lab2.Misc;


public class TMatrix {

    private final double[][] matrix;

    public TMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public Vector transform(Vector vector) {
        // All matrix elements from 00 to 33
        double _00 = this.matrix[0][0];
        double _01 = this.matrix[0][1];
        double _02 = this.matrix[0][2];
        double _03 = this.matrix[0][3];
        double _10 = this.matrix[1][0];
        double _11 = this.matrix[1][1];
        double _12 = this.matrix[1][2];
        double _13 = this.matrix[1][3];
        double _20 = this.matrix[2][0];
        double _21 = this.matrix[2][1];
        double _22 = this.matrix[2][2];
        double _23 = this.matrix[2][3];
        double _30 = this.matrix[3][0];
        double _31 = this.matrix[3][1];
        double _32 = this.matrix[3][2];
        double _33 = this.matrix[3][3];

        double x = vector.getX() * _00 + vector.getY() * _10 + vector.getZ() * _20 + vector.getH() * _30;
        double y = vector.getX() * _01 + vector.getY() * _11 + vector.getZ() * _21 + vector.getH() * _31;
        double z = vector.getX() * _02 + vector.getY() * _12 + vector.getZ() * _22 + vector.getH() * _32;
        double h = vector.getX() * _03 + vector.getY() * _13 + vector.getZ() * _23 + vector.getH() * _33;

        //double y = vector.getX() * _01 + vector.getY() * _11 + vector.getH() * _21;
        //double z = 0;
        //double h = vector.getX() * _02 + vector.getY() * _12 + vector.getH() * _22;
        return new Vector(x, y, z, h);
    }

    public TMatrix multyPly(TMatrix m) {
        double[][] t = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    t[i][j] += this.matrix[i][k] * m.getMatrix()[j][k];
                }
            }
        }
        return new TMatrix(t);
    }

    public double[][] getMatrix() {
        return matrix;
    }
}