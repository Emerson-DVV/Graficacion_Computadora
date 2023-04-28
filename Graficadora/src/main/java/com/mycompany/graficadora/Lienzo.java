package com.mycompany.graficadora;

import java.awt.Color;
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
    private ArrayList<Figure> figuras;
    
    public Lienzo(JPanel panel){
        this.panel = panel;
        width = panel.getWidth();
        height = panel.getHeight();
        escala = 2;
        graficos = (Graphics2D)panel.getGraphics();
        figuras = new ArrayList<>();
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
    public void aniadir(Figure f){
        figuras.add(f);
    }
    
    public Figure getFigure(int ID){
        Figure ans = null;
        for (Figure figura : figuras) {
            if(figura.ID == ID){
                ans = figura;
            }
        }
        return ans;
    }
    public void ReDibujar(int caso){
        panel.removeAll();
        panel.paint(graficos);
        if(caso == 0){
            for (Figure figura : figuras) {
                Dibujar(figura);
            }
        }else{
            for (Figure figura : figuras) {
                DibujarSegmentado(figura);
            }
        }
    }

    public void Dibujar(Figure f){
        for (Punto punto : f.dibujar()) {
            GraficarPunto(punto.getX(), punto.getY());
        }
    }
    
    public void DibujarSegmentado(Figure f){
        for(int i = 0; i < f.dibujar().size(); i = i + 3){ //Valor i cantidad de puntos que se saltara para luego dibujarlos.
            Punto punto = f.dibujar().get(i);
            GraficarPunto(punto.getX(), punto.getY());
        }
    }
    
    private void GraficarPunto(int x, int y){
        int xpixel = x * escala;
        if(xpixel == width) xpixel -= escala;
        int ypixel = (height - (y * escala))- escala;
        if(ypixel < 0) ypixel = 0;
        graficos.setColor(Color.BLACK);
        graficos.fillRect(xpixel, ypixel, escala, escala);
    }
    
}
