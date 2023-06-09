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
    JPanel panel;
    int width,height,escala;
    Graphics2D graficos;
    ArrayList<Figure> figuras;
    
    public Lienzo(JPanel panel){
        this.panel = panel;
        width = panel.getWidth();
        height = panel.getHeight();
        escala = 2;
        graficos = (Graphics2D)panel.getGraphics();
        figuras = new ArrayList<>();
    }
    public ArrayList<Figure> getListaFigura(){
        return figuras;
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
    public void ReDibujar(){
        panel.removeAll();
        panel.paint(graficos); 
        for (Figure figura : figuras) {
            Dibujar(figura);
            if(figura.color != Color.WHITE){
                ArrayList<Punto> pintadop;
                if(figura.cambio){
                    pintadop = figura.pintar(width, height, escala);
                    figura.cambio = false;
                }
                else pintadop = figura.pintado;
                graficos.setColor(figura.color);
                for (Punto punto : pintadop) {
                    graficos.fillRect(punto.getX(), punto.getY(), escala, escala);
                }
            }else figura.cambio = false;
            graficarID(figura);
        }
    }

    public void Dibujar(Figure f){
        if(f.segmentado){
            DibujarSegmentado(f);
        }else{
            ArrayList<Punto> list;
            if(f.cambio){
                list = f.dibujar();
            }
            else list = f.bordes;
            for (Punto punto : list) {
                GraficarPunto(punto.getX(), punto.getY());
            }
        }
    }

    public void DibujarSegmentado(Figure f){
        if(f instanceof Circunferencia){
            int cont = 0;
            int tamanioOriginal = f.dibujar().size();
            ArrayList<Punto> list;
            if(f.cambio){
                list = f.dibujar();
            }
            else list = f.bordes;
            for(int j = 0 ; j < list.size() ; j++){
                Punto punto = list.get(j);
                if(cont == 40 && j < tamanioOriginal){
                    cont = 0;
                    j += 48;
                }else{
                    GraficarPunto(punto.getX(), punto.getY());
                }
                cont++;
            }
        }else{ //cuadrado y triangulo
            int cont = 0;
            ArrayList<Punto> list;
            if(f.cambio){
                list = f.dibujar();
            }
            else list = f.bordes;
            for(int j = 0 ; j < list.size() ; j++){
                Punto punto = list.get(j);
                    if(cont == 10){
                        cont = 0;
                        j += 5;
                    }else{
                        GraficarPunto(punto.getX(), punto.getY());
                    }
                cont++;
            }
        }
    }
    
    private void graficarID(Figure f){
        Punto centro = f.getCentro();        
        int xpixel = centro.getX() * escala;
        if(xpixel == width) xpixel -= escala;
        int ypixel = (height - (centro.getY() * escala))-escala;
        if(ypixel < 0) ypixel = 0;
        graficos.setColor(Color.RED);
        graficos.drawString(f.getID() + "", xpixel, ypixel);
    }
    
    private void GraficarPunto(int x, int y){
        int xpixel = x * escala;
        int ypixel = (height - (y * escala))-escala;
        graficos.setColor(Color.BLACK);
        graficos.fillRect(xpixel, ypixel, escala, escala);
    }  
}

