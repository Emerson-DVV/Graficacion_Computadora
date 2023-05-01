
package com.mycompany.graficadora;

import java.util.ArrayList;
import java.util.Stack;

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
    
    public ArrayList<Punto> cuatroVecinos(boolean [][] bordes,int escala,Punto centro){
        int width = bordes.length;
        int height = bordes[0].length;
        ArrayList<Punto> puntosValidos = new ArrayList<>();
        Stack<Punto> pila = new Stack<>();
        pila.push(centro);
        puntosValidos.add(centro);
        while(!pila.isEmpty()){
            Punto actual = pila.pop();
            int x = actual.getX();
            int y = actual.getY();
            if(validos(x,y,width,height)){
                if(!bordes[x][y]){
                    bordes[x][y] = true;
                    if(!bordes[x+escala][y]){
                        insertar(pila, puntosValidos,x + escala, y);
                    }
                    if(!bordes[x-escala][y]){
                        insertar(pila, puntosValidos,x - escala, y);
                    }
                    if(!bordes[x][y+escala]){
                        insertar(pila, puntosValidos,x, y + escala);
                    }
                    if(!bordes[x][y-escala]){
                        insertar(pila, puntosValidos,x, y - escala);
                    }
                }
            }    
        }
        return puntosValidos;
    }
    
    private boolean validos(int x, int y, int width, int height) {
        return (x > 0 && x < width)&&(y > 0 && y < height);
    }
    
    private void insertar(Stack<Punto> pila,ArrayList<Punto> puntosValidos,int x, int y){
        puntosValidos.add(new Punto(x,y));
        pila.push(new Punto(x,y));
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
    
    public ArrayList<Punto> agregarPuntosGrosor(ArrayList<Punto> puntos, int grosor){
        int tamanio = puntos.size();
        for(int j = 0 ; j < tamanio ; j++){
            Punto punto = puntos.get(j);
            for(int i = 0 ; i <= grosor  ; i++){
                puntos.add(new Punto(punto.getX(),punto.getY()+i));
                puntos.add(new Punto(punto.getX(),punto.getY()-i));
                puntos.add(new Punto(punto.getX()+i,punto.getY()));
                puntos.add(new Punto(punto.getX()-i,punto.getY()));
                puntos.add(new Punto(punto.getX()+i,punto.getY()+i));
                puntos.add(new Punto(punto.getX()+i,punto.getY()-i));
                puntos.add(new Punto(punto.getX()-i,punto.getY()+i));
                puntos.add(new Punto(punto.getX()-i,punto.getY()-i));
            }
        }
        return puntos;
    }
}