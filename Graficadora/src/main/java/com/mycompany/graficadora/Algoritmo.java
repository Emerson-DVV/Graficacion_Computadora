
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
}
