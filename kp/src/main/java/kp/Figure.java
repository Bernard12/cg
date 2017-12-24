package kp;

import kp.CustomCanvas.MyCanvas;
import kp.Misc.Vector;

import java.util.ArrayList;

/**
 * Class containing all point of Frustum
 */
public class Figure {
    private ArrayList<ArrayList<Vector>> central;
    private ArrayList<ArrayList<Vector>> p;
    private double step = 0.1;


    Figure(ArrayList<ArrayList<Vector>> points) {
        central = points;
        p = new ArrayList<>();
        generatePoints();
    }

    public void update(){
        p.clear();
        p = new ArrayList<>();
        generatePoints();
    }

    private long binom(int n,int k) {
        if (k > n - k) {
            k = n - k;
        }
        long b = 1;
        for (int i = 1, m = n; i <= k; i++, m--) {
            b = b * m / i;
        }
        return b;
    }

    private double choose(int n,int i,double t) {
        long bi = binom(n, i);
        double res = Math.pow(t, i);
        double ares = Math.pow(1 - t, n - i);
        return bi*res*ares;
    }

    private void generatePoints() {
        for (double x = 0; x < 1; x += step) {
            ArrayList<Vector> l = new ArrayList<>();
            for (double y = 0; y < 1; y += step) {
                l.add(point(x, y));
            }
            p.add(l);
        }
    }

    private Vector point(double x,double y) {
        double tx = 0;
        double ty = 0;
        double tz = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                double px = central.get(i).get(j).getX();
                double py = central.get(i).get(j).getY();
                double pz = central.get(i).get(j).getZ();

                double t1 = choose(3,i,x);
                double t2 = choose(3,j,y);
                tx += px*t1*t2;
                ty += py*t1*t2;
                tz += pz*t1*t2;
            }
        }
        return new Vector(tx*3,ty*3,tz*3,1);
    }

    public void draw(MyCanvas canvas) {
        Drawer drawer = new Drawer();
        for(int i = 0; i < p.size() - 1; i++){
            drawer.draw(canvas,p.get(i),p.get(i+1));
        }
    }

    public ArrayList<ArrayList<Vector>> getCentral() {
        return central;
    }

    public void setCentral(ArrayList<ArrayList<Vector>> central) {
        this.central = central;
    }

    public ArrayList<ArrayList<Vector>> getP() {
        return p;
    }

    public void setP(ArrayList<ArrayList<Vector>> p) {
        this.p = p;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }
}
