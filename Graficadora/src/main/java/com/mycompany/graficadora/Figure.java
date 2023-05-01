package com.mycompany.graficadora;

import java.util.ArrayList;
/**
 *
 * @author Sergi
 */
public abstract class Figure {
    protected int ID;
    protected boolean pintado;
    public Figure(int ID){
        this.ID = ID;
    }
    
    public abstract ArrayList<Punto> dibujar();
    public abstract void traslacion(int dx, int dy);
    public abstract void rotar(double angulo);
    public abstract void escalar(int valor);
    public abstract void rellenar(Lienzo l);
}