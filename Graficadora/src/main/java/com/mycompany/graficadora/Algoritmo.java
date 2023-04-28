
package com.mycompany.graficadora;

import java.util.ArrayList;

public class Algoritmo {
    public void DDA(Punto a, Punto b,ArrayList<Punto> puntos){
        int dx = b.getX() - a.getX();
        int dy = b.getY() - a.getY();
        int pasos = Math.max(Math.abs(dx),Math.abs(dy));
        float xInc = dx/(float) pasos;
        float yInc = dy/(float) pasos;
        float x = a.getX();
        float y = a.getY();
        for (int i = 0; i <= pasos; i++) {
            puntos.add(new Punto(Math.round(x),Math.round(y)));
            x += xInc;
            y += yInc;
        }
    }
    
    public void BresenhamCirc(int xc, int yc, int r, ArrayList<Punto> puntos){
        if (r <= 0) {
            drawCircle(puntos, xc, yc, 0, 0); //Dibuja un punto en el centro de la circunferencia
        } else {
            int x = 0;
            int y = r;
            int d = 3 - 2 * r;
            drawCircle(puntos, xc, yc, x, y);
            while (x <= y) {
                x = x + 1;
                if (d < 0) {
                    d = d + 4 * x + 6;
                } else {
                    y = y - 1;
                    d = d + 4 * (x - y) + 10;
                }
                drawCircle(puntos, xc, yc, x, y);
            }
        }
        
    }
    
    private void drawCircle(ArrayList<Punto> puntos, int xc, int yc, int x, int y) {
        puntos.add(new Punto(xc + x, yc + y));
        puntos.add(new Punto(xc - x, yc + y));
        puntos.add(new Punto(xc + x, yc - y));
        puntos.add(new Punto(xc - x, yc - y));
        puntos.add(new Punto(xc + y, yc + x));
        puntos.add(new Punto(xc - y, yc + x));
        puntos.add(new Punto(xc + y, yc - x));
        puntos.add(new Punto(xc - y, yc - x));
    }
}
