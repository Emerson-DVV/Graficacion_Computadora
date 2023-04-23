
package com.mycompany.graficacionporcomputadora;

import java.awt.Graphics;
import java.util.ArrayList;

public class Lienzo {
    
    private ArrayList<Cuadrado> cuadrados;
    
    public Lienzo(){
        cuadrados = new ArrayList<>();
    }
    
    public void aniadirCuadrado(Cuadrado c){
        cuadrados.add(c);
    }
    
    public void dibujar(Graphics g){
        for (Cuadrado c : cuadrados) {
            g.fillRect(c.getX(), c.getY(), c.getDistancia(), c.getDistancia());
        }
    }
}
