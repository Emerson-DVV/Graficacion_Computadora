
package com.mycompany.graficadora;

public class Cuadrado{
    int ID,lado;
    Punto v1,v2,v3,v4;
    
    public Cuadrado(Punto v1,int ID,int lado){
        this.v1 = v1;
        this.ID = ID;
        this.lado = lado;
        generarVertices();
    }

    public void update(int movex,int movey){
        v1.setX(v1.getX()+movex);
        v1.setY(v1.getY()+movey);
        generarVertices();
    }
    
    private void generarVertices() {
        v2 = new Punto(v1.getX()+lado,v1.getY());
        v3 = new Punto(v1.getX(),v1.getY()+lado);
        v4 = new Punto(v1.getX()+ lado,v1.getY()+lado);
    }
}
