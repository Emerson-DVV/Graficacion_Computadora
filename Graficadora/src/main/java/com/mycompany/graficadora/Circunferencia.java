package com.mycompany.graficadora;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
            puntos = alg.agregarPuntosGrosor(this,puntos);
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
        boolean [][] bordes = new boolean [width+1][height+1];
        Set<Punto> bordesP = new HashSet<>(); // Nuevo
        ArrayList<Punto> escalaReal = dibujar();
        for (Punto punto : escalaReal) {
            int xp = punto.getX() * escala;
            int yp = (height - (punto.getY() * escala))-escala;
            if(validos(xp,yp,width,height)){
                bordes [xp][yp] = true;
            }
            bordesP.add(new Punto(xp,yp));
        }
        int xp = xc * escala;
        int yp = (height - (yc * escala))-escala;
        if(validos(xp,yp,width,height)){
            Punto pivote = new Punto(xp,yp);
            return alg.cuatroVecinos(bordes, escala, pivote);
        }else{
            ArrayList<Punto> nulo = new ArrayList<>();
            nulo.add(new Punto(-1,-1));
            Punto pivote = alg.buscarPivote(bordesP, escala, width, height, new Punto(xp,yp));
            if(pivote != null) return alg.cuatroVecinos(bordes, escala,pivote);
            else return nulo;
        } 
    }

    private boolean validos(int xpixel, int ypixel, int width, int height) {
        return (xpixel >= 0 && xpixel <= width)&&(ypixel >= 0 && ypixel <= height);
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
