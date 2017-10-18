package lab1.Misc;


public class TMatrix {

    private final double[][] matrix;

    public TMatrix(double[][] matrix){
        this.matrix = matrix;
    }

    /**
     * @param vector input vector
     * @return vector after matrix product
     */
    public Vector transform(Vector vector) {
        double _00 = this.matrix[0][0];
        double _01 = this.matrix[0][1];
        double _02 = this.matrix[0][2];
        double _10 = this.matrix[1][0];
        double _11 = this.matrix[1][1];
        double _12 = this.matrix[1][2];
        double _20 = this.matrix[2][0];
        double _21 = this.matrix[2][1];
        double _22 = this.matrix[2][2];
        double x = vector.getX() * _00 + vector.getY() * _10 + vector.getH() * _20;
        double y = vector.getX() * _01 + vector.getY() * _11 + vector.getH() * _21;
        double h = vector.getX() * _02 + vector.getY() * _12 + vector.getH() * _22;
        return new Vector(x,y,h);
    }

    public TMatrix multyPly(TMatrix m) {
        double[][] t = {{0, 0 , 0}, {0, 0, 0},{0, 0, 0}};
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
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