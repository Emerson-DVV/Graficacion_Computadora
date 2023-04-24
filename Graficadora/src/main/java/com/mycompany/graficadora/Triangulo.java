/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graficadora;

import java.util.ArrayList;

/**
 *
 * @author leinad
 */
public class Triangulo extends Figure {

    private int a;
    private int h;
    private int r;
    private Algoritmo alg;
    private Punto A;
    private Punto B;
    private Punto C;

    public Triangulo(int ID, int a) {
        super(ID);
        this.a = a;
        h = ((int) (a * Math.sqrt(3)) / 2);
        r = (2 * h) / 2;
        alg = new Algoritmo();
        A = new Punto(0, 0);
        B = new Punto((a / 2), h);
        C = new Punto(a, A.getX());
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
        A.setX(A.getX() + dx);
        A.setY(A.getY() + dy);

        B.setX(B.getX() + dx);
        B.setY(B.getY() + dy);

        C.setX(C.getX() + dx);
        C.setY(C.getY() + dy);

//        B = new Punto((a / 2) + A.getX(), h + A.getY());
//        C = new Punto((a + A.getX()), A.getY());
    }

    @Override
    public void rotar(double angulo) {
        int dx = A.getX();
        int dy = A.getY();

        traslacion(-dx, -dy);

        A.setX((int) Math.round(A.getX() * Math.cos(angulo) - A.getY() * Math.sin(angulo)));
        A.setY((int) Math.round(A.getX() * Math.sin(angulo) + A.getY() * Math.cos(angulo)));

        B.setX((int) Math.round(B.getX() * Math.cos(angulo) - B.getY() * Math.sin(angulo)));
        B.setY((int) Math.round(B.getX() * Math.sin(angulo) + B.getY() * Math.cos(angulo)));

        C.setX((int) Math.round(C.getX() * Math.cos(angulo) - C.getY() * Math.sin(angulo)));
        C.setY((int) Math.round(C.getX() * Math.sin(angulo) + C.getY() * Math.cos(angulo)));

        traslacion(dx, dy);

    }

    @Override
    public void escalar(int valor) {
        a = a * valor / 2;
        h = ((int) (a * Math.sqrt(3)) / 2);
        B = new Punto((a / 2) + A.getX(), h + A.getY());
        C = new Punto((a + A.getX()), A.getY());
    }

}
