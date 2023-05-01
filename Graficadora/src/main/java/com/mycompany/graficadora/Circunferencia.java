package com.mycompany.graficadora;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class Circunferencia extends Figure {

    private int xc, yc, r;
    private Algoritmo alg;

    public Circunferencia(int ID, int xc, int yc, int r) {
        super(ID);
        this.xc = xc;
        this.yc = yc;
        this.r = r;
        alg = new Algoritmo();
    }

    @Override
    public ArrayList<Punto> dibujar() {
        ArrayList<Punto> puntos = new ArrayList();
        alg.BresenhamCirc(xc, yc, r, puntos);
        return puntos;
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
    }
    
    @Override
    public void rellenar(Lienzo l){
    
    }
}
