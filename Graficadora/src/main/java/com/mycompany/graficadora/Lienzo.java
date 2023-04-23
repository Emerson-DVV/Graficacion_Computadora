package com.mycompany.graficadora;

import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Emer
 */
public class Lienzo{
    private JPanel panel;
    private int width,height,escala;
    private Graphics2D graficos;
    private Algoritmo alg;
    private ArrayList<Cuadrado> cuadrados;
    public Lienzo(JPanel panel){
        this.panel = panel;
        width = panel.getWidth();
        height = panel.getHeight();
        escala = 2;
        graficos = (Graphics2D)panel.getGraphics();
        alg = new Algoritmo();
        cuadrados = new ArrayList<>();
    }
    
    public void Grilla(){
        //graficos.clearRect(0, 0, width, height);
        
        for (int x = 0; x < width; x += escala) {
            graficos.drawLine(x, 0, x, height); // Verticales
        }
        for (int y = 0; y < height; y += escala) {
            graficos.drawLine(0, y, width, y); // Horizontales
        }
        
    }
    public void aniadir(Cuadrado c){
        cuadrados.add(c);
    }
    
    public Cuadrado getCuadrado(int ID){
        Cuadrado ans = null;
        for (Cuadrado cuadrado : cuadrados) {
            if(cuadrado.ID == ID){
                ans = cuadrado;
            }
        }
        return ans;
    }
    public void ReDibujar(){
        graficos.clearRect(1, 1, width-1, height-1);
        for (Cuadrado cuadrado : cuadrados) {
            Dibujar(cuadrado);
        }
    }
    
    public void Dibujar(Cuadrado c){
        ArrayList<Punto> puntos = new ArrayList<>();
        alg.DDA(c.v1, c.v2, puntos);
        alg.DDA(c.v1, c.v3, puntos);
        alg.DDA(c.v3, c.v4, puntos);
        alg.DDA(c.v2, c.v4, puntos);
        for (Punto punto : puntos) {
            GraficarPunto(punto.getX(), punto.getY());
        }
    }
    
    private void GraficarPunto(int x, int y){
        int xpixel = x * escala;
        if(xpixel == width) xpixel -= escala;
        int ypixel = (height - (y * escala))- escala;
        if(ypixel < 0) ypixel = 0;
        graficos.fillRect(xpixel, ypixel, escala, escala);
    }
    
}
