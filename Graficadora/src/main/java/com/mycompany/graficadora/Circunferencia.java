package com.mycompany.graficadora;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class Circunferencia extends Figure {

    private int xc, yc, r;

    public Circunferencia(int ID, int xc, int yc, int r) {
        super(ID);
        this.xc = xc;
        this.yc = yc;
        this.r = r;
    }

    public void scaling(int value) { //Escalacion de la circunferencia

    }

    @Override
    public ArrayList<Punto> dibujar() {
        ArrayList<Punto> puntos = new ArrayList();
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
        return puntos;
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

    @Override
    public void traslacion(int dx, int dy) {
        xc = xc + dx;
        yc = yc + dy;
    }

    @Override
    public void rotar(double angulo) {
        //no rota
    }

    @Override
    public void escalar(int valor) {
        r = r + (valor); //La circunferencia solo requiere disminuir o aumentar el radio para escalarlo.
        dibujar();
    }
}
