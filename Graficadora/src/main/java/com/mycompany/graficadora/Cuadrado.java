
package com.mycompany.graficadora;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Cuadrado extends Figure{
    Punto v1,v2,v3,v4,centro;
    ArrayList<Punto> vertices;
    Algoritmo algoritmos;
    
    public Cuadrado(Punto v1,int ID,int lado){
        super(ID);
        this.v1 = v1;
        v2 = new Punto(v1.getX()+lado,v1.getY());
        v3 = new Punto(v1.getX(),v1.getY()+lado);
        v4 = new Punto(v1.getX()+ lado,v1.getY()+lado);
        centro();
        vertices();
        algoritmos = new Algoritmo();
    }
    
    private void vertices(){
        vertices = new ArrayList<>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
    }
    
    private void centro() {
        int cx = v1.getX() + v2.getX() + v3.getX() + v4.getX();
        int cy = v1.getY() + v2.getY() + v3.getY() + v4.getY(); 
        centro = new Punto(cx/4, cy/4);
    }
    

    @Override
    public ArrayList<Punto> dibujar() {
        ArrayList<Punto> puntos = new ArrayList<>();
        algoritmos.DDA(this.v1, this.v2, puntos);
        algoritmos.DDA(this.v1, this.v3, puntos);
        algoritmos.DDA(this.v3, this.v4, puntos);
        algoritmos.DDA(this.v2, this.v4, puntos);
        //grosor
        if(grosor == true){
            puntos = algoritmos.agregarPuntosGrosor(this,puntos);
        }
        return puntos;
    }

    @Override
    public void traslacion(int dx, int dy) {
        for (Punto vertice : vertices) {
            vertice.setX(vertice.getX()+ dx);
            vertice.setY(vertice.getY()+ dy);
        }
        centro();
    }

    @Override
    public void rotar(double anguloGrados) {
        double anguloRadianes = Math.toRadians(anguloGrados);
        double coseno = Math.cos(anguloRadianes);
        double seno = Math.sin(anguloRadianes);
        Punto pivote = centro;
        traslacion(-pivote.getX(), -pivote.getY());
        for (Punto vertice : vertices) {
            double xp = vertice.getX() * coseno - vertice.getY() * seno;
            double yp = vertice.getX() * seno + vertice.getY() * coseno;
            long x = Math.round(xp);
            long y = Math.round(yp);
            vertice.setX((int)x);
            vertice.setY((int)y);
        }
        traslacion(pivote.getX(), pivote.getY());
    }

    @Override
    public void escalar(double valor) {
        Punto pivote = centro;
        traslacion(-pivote.getX(), -pivote.getY());
        for (Punto vertice : vertices) {
            vertice.setX((int)(vertice.getX() * valor));
            vertice.setY((int)(vertice.getY() * valor));
        }
        traslacion(pivote.getX(), pivote.getY());
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
        int xp = centro.getX() * escala;
        int yp = (height - (centro.getY() * escala))-escala;
        if(validos(xp,yp,width,height)){
            Punto pivote = new Punto(xp,yp);
            return algoritmos.cuatroVecinos(bordes, escala, pivote);
        }else{
            boolean flag = false;
            for (int i = 0;i < 4 && !flag;i++) {
                int xpp = vertices.get(i).getX() * escala;
                int ypp = (height - (vertices.get(i).getY() * escala))-escala;
                flag = validos(xpp, ypp, width, height);
            }
            ArrayList<Punto> nulo = new ArrayList<>();
            nulo.add(new Punto(-1,-1));
            if(flag){
                Punto pivote = algoritmos.buscarPivote(bordesP, escala, width, height, new Punto(xp,yp));
                if(pivote != null) return algoritmos.cuatroVecinos(bordes, escala,pivote);
                else return nulo;
            }else return nulo;
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
        return centro;
    }

}