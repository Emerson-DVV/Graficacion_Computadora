
package com.mycompany.graficacionporcomputadora;

public class Cuadrado {
    private int x,y,distancia,id;   

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistancia() {
        return distancia;
    }

    public int getId() {
        return id;
    }
    public Cuadrado(int x,int y, int diatancia,int id){
        this.x = x;
        this.y = y;
        this.id = id;
        this.distancia = diatancia;
    }
         
}
