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
        //grosor
        if(grosor == true){
            puntos = alg.agregarPuntosGrosor(puntos, 1);
        }
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
    public void escalar(double valor) {
        r = (int)(r * valor); //La circunferencia solo requiere disminuir o aumentar el radio para escalarlo.
    }
    
    @Override
    public ArrayList<Punto> pintar(int width,int height,int escala){
        boolean [][] bordes = new boolean [height+1][width+1];
        ArrayList<Punto> escalaReal = dibujar();
        for (Punto punto : escalaReal) {
            int xpixel = punto.getX() * escala;
            int ypixel = (height - (punto.getY() * escala))-escala;
            if(validos(xpixel,ypixel,width,height))bordes [xpixel][ypixel] = true;
        }
        int xpixel = xc * escala;
        int ypixel = (height - (yc * escala))-escala;
        Punto cp = new Punto(0, 0);
        if(validos(xpixel,ypixel,width,height)){
            cp.setX(xpixel);
            cp.setY(ypixel);
        }
        return alg.cuatroVecinos(bordes, escala,cp);
    }

    private boolean validos(int xpixel, int ypixel, int width, int height) {
        return (xpixel > 0 && xpixel < width)&&(ypixel > 0 && ypixel < height);
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public Punto getCentro() {
        Punto centro = new Punto(xc, yc);
        return centro;
    }

}
