package lab.Misc;

public class TMatrix {

    private final double[][] matrix;

    public TMatrix(double[][] matrix){
        this.matrix = matrix;
    }

    public Vector transform(Vector vector) {
        //System.out.println("Before: " + vector.getX() + ' ' + vector.getY());
        double _00 = this.matrix[0][0];
        double _01 = this.matrix[0][1];
        double _10 = this.matrix[1][0];
        double _11 = this.matrix[1][1];
        double x = vector.getX() * _00 + vector.getY() * _10;
        double y = vector.getX() * _01 + vector.getY() * _11;
        //System.out.println("After: " + res.getX() + ' ' + res.getY());
        return new Vector(x,y);
    }

    public TMatrix multyPly(TMatrix m) {
        double[][] t = {{0, 0}, {0, 0}};
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    t[i][j] += this.matrix[i][k]*m.getMatrix()[j][k];
                }
            }
        }
        return new TMatrix(t);
    }

    public double[][] getMatrix() {
        return matrix;
    }
}
