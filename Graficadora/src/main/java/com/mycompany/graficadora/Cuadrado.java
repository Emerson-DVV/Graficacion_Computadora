
package com.mycompany.graficadora;

import java.util.ArrayList;
/**
 *
 * @author emer
 */
public class Cuadrado{
    private Punto v1, v2, v3, v4;
    private ArrayList<Punto> puntos,vertices;
    
    public Cuadrado(Punto v1, Punto v2){
        vertices = new ArrayList<>();
        this.v1 = v1;
        vertices.add(v1);
        this.v2 = v2;
        vertices.add(v2);
        double distancia = Math.sqrt(Math.pow(v1.getX()-v2.getX(),2)+ Math.pow(v1.getY()-v2.getY(),2));
        v3 = new Punto(v1.getX(),(int)(v1.getY()+ distancia));
        vertices.add(v3);
        v4 = new Punto(v2.getX(),(int)(v2.getY()+ distancia));
        vertices.add(v4);
        puntos = new ArrayList<>();
    }
    
    public ArrayList<Punto> listaP(){
        DDA(v1,v2,puntos);
        DDA(v3,v4,puntos);
        DDA(v1,v3,puntos);
        DDA(v2,v4,puntos);
        return puntos;
    }
    
    private void DDA(Punto a, Punto b,ArrayList<Punto> puntos){
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

    public ArrayList<Punto> getPuntos() {
        return puntos;
    }

    public ArrayList<Punto> getVertices() {
        return vertices;
    }
    
}
