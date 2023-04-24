
package com.mycompany.graficadora;

import java.util.ArrayList;

public class Cuadrado extends Figure{
    int lado;
    Punto v1,v2,v3,v4;
    Algoritmo alg;
    
    public Cuadrado(Punto v1,int ID,int lado){
        super(ID);
        this.v1 = v1;
        this.ID = ID;
        this.lado = lado;
        generarVertices();
        alg = new Algoritmo();
    }
    
    private void generarVertices() {
        v2 = new Punto(v1.getX()+lado,v1.getY());
        v3 = new Punto(v1.getX(),v1.getY()+lado);
        v4 = new Punto(v1.getX()+ lado,v1.getY()+lado);
    }

    @Override
    public ArrayList<Punto> dibujar() {
        ArrayList<Punto> puntos = new ArrayList<>();
        alg.DDA(this.v1, this.v2, puntos);
        alg.DDA(this.v1, this.v3, puntos);
        alg.DDA(this.v3, this.v4, puntos);
        alg.DDA(this.v2, this.v4, puntos);
        return puntos;
    }

    @Override
    public void traslacion(int dx, int dy) {
        v1.setX(v1.getX()+dx);
        v1.setY(v1.getY()+dy);
        generarVertices();
    }

    @Override
    public void rotar(double angulo) {
        //implementar
    }

    @Override
    public void escalar(int valor) {
        //implementar
    }
}
