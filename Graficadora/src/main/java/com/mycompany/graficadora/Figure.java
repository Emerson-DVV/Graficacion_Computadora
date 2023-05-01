package com.mycompany.graficadora;

import java.awt.Color;
import java.util.ArrayList;
/**
 *
 * @author Sergi
 */
public abstract class Figure {
    protected int ID;
    protected Color color;
    protected boolean grosor,segmentado;
    public Figure(int ID){
        this.ID = ID;
        color = Color.WHITE;
        grosor = segmentado = false;
    }
    public abstract int getID();
    public abstract Punto getCentro();
    public abstract ArrayList<Punto> dibujar();
    public abstract void traslacion(int dx, int dy);
    public abstract void rotar(double angulo);
    public abstract void escalar(double valor);
    public abstract ArrayList<Punto> pintar(int width,int height,int escala);
}