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


    Figure(ArrayList<ArrayList<Vector>> points) {
        central = points;
        p = new ArrayList<>();
        generatePoints();
        int a = 5/2;
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
        for (double x = 0; x < 1; x += 0.1) {
            ArrayList<Vector> l = new ArrayList<>();
            for (double y = 0; y < 1; y += 0.1) {
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
        for(int i = 0; i < p.size(); i++){
            drawer.draw(canvas,p.get(i));
        }
    }

}
