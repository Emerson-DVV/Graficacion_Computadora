package com.mycompany.graficadora;

import java.util.ArrayList;
/**
 *
 * @author Emer
 */
public class Bresenham {
    public ArrayList<Punto> bresenham(int x1,int y1,int x2, int y2){
        ArrayList<Punto> ans = new ArrayList<>();
        int x = x1;
        int y = y1;
        int dx = Math.abs(x2  - x1);
        int dy = Math.abs(y2  - y1);
        float pendiente = dy / (float)dx;
        if(pendiente > 1){
            int aux;
            aux = dx; dx = dy; dy = aux;
            aux = x; x = y; y = aux;
            aux = x2; x2 = y2; y2 = aux;
        } 
        int M0 = 2 * (dy - dx);
        int MN0 = 2 * dy;
        int p = 2 * dy - dx;
        for (int i = 0; i < dx; i++) {
            if(p > 0){
                y = y < y2 ? y++ : y--;
                p += M0;
            }else{
                p += MN0;
            }
            x = x < x2 ? x++ : x--;
            ans.add(new Punto(x,y));
        }
        return ans;
    }
}
