package com.mycompany.graficadora;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Emer
 */
public class Graficador {
    private JPanel panel;
    private int width,height,escala;
    private Graphics2D graficos;
    public Graficador(JPanel panel){
        this.panel = panel;
        width = panel.getWidth();
        height = panel.getHeight();
        escala = 10;
        graficos = (Graphics2D)panel.getGraphics();
    }
    
    public void Griya(){
        //graficos.clearRect(0, 0, width, height);
        
        for (int x = 0; x < width; x += escala) {
            graficos.drawLine(x, 0, x, height); // Verticales
        }
        for (int y = 0; y < height; y += escala) {
            graficos.drawLine(0, y, width, y); // Horizontales
        }
    }
    
    public void GPunto(int x, int y){
        int xpixel = x * escala;
        if(xpixel == width) xpixel -= escala;
        int ypixel = (height - (y * escala))- escala;
        if(ypixel < 0) ypixel = 0;
        graficos.fillRect(xpixel, ypixel, escala, escala);
    }
}
