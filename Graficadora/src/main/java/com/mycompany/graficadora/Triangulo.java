
package com.mycompany.graficadora;

import java.util.ArrayList;

/**
 *
 * @author leinad
 */
public class Triangulo extends Figure {

    private int a;
    private int h;
    private Algoritmo alg;
    private Punto A;
    private Punto B;
    private Punto C;
    private Punto centro;
    ArrayList<Punto> vertices;

    public Triangulo(int ID, int a) {
        super(ID);
        this.a = a;
        h = ((int) (a * Math.sqrt(3)) / 2);
        alg = new Algoritmo();
        A = new Punto(0, 0);
        B = new Punto((a / 2), h);
        C = new Punto(a, A.getX());
        vertices();
    }

    private void vertices() {
        vertices = new ArrayList<>();
        vertices.add(A);
        vertices.add(B);
        vertices.add(C);
    }

    public void getCentro() {
        int cx = A.getX() + B.getX() + C.getX();
        int cy = A.getY() + B.getY() + C.getY();
        centro = new Punto(cx / 3, cy / 3);
    }

    @Override
    public ArrayList<Punto> dibujar() {

        ArrayList<Punto> puntos = new ArrayList<>();

        alg.DDA(A, B, puntos);
        alg.DDA(B, C, puntos);
        alg.DDA(C, A, puntos);

        return puntos;
    }

    @Override
    public void traslacion(int dx, int dy) {
        for (Punto vertice : vertices) {
            vertice.setX(vertice.getX() + dx);
            vertice.setY(vertice.getY() + dy);
        }
        getCentro();
    }

    @Override
    public void rotar(double angulo) {
        Punto pivote = centro;
        double anguloRadianes = Math.toRadians(angulo);
        double cos = Math.cos(anguloRadianes);
        double sen = Math.sin(anguloRadianes);

        traslacion(-pivote.getX(), -pivote.getY());  //lo lleva al origen

        for (Punto vertice : vertices) {
            double xprima = vertice.getX() * cos - vertice.getY() * sen;
            double yprima = vertice.getX() * sen + vertice.getY() * cos;

            long x = Math.round(xprima);
            long y = Math.round(yprima);

            vertice.setX((int) x);
            vertice.setY((int) y);
        }
        
        traslacion(pivote.getX(), pivote.getY());
    }

    @Override
    public void escalar(double valor) {

        Punto pivote = centro;

        traslacion(-pivote.getX(), -pivote.getY());

        for (Punto vertice : vertices) {
            vertice.setX((int) (vertice.getX() * valor));
            vertice.setY((int) (vertice.getY() * valor));
        }

        traslacion(pivote.getX(), pivote.getY());
    }

    @Override
    public ArrayList<Punto> pintar(int width, int height, int escala) {
        boolean [][] bordes = new boolean [height][width];
        ArrayList<Punto> escalaReal = dibujar();
        for (Punto punto : escalaReal) {
            int xpixel = punto.getX() * escala;
            if(xpixel == width) xpixel -= escala;
            int ypixel = (height - (punto.getY() * escala))-escala;
            if(ypixel < 0) ypixel = 0;
            if(validos(xpixel,ypixel,width,height))bordes [xpixel][ypixel] = true;
        }
        int xpixel = centro.getX() * escala;
        if(xpixel == width) xpixel -= escala;
        int ypixel = (height - (centro.getY() * escala))-escala;
        if(ypixel < 0) ypixel = 0;
        Punto cp = new Punto(0, 0);
        if(validos(xpixel,ypixel,width,height)){
            cp.setX(xpixel);
            cp.setY(ypixel);
        }
        return alg.cuatroVecinos(bordes, escala,cp);
    }

    private boolean validos(int xpixel, int ypixel, int width, int height) {
        return (xpixel > 0 && xpixel < width)&&(ypixel > 0 && ypixel < height);
    }

}
