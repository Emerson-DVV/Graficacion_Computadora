package com.mycompany.graficadora;

import java.util.Objects;

/**
 *
 * @author Emer
 */
public class Punto {
    private int x,y;
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }
    
        // Implementación del método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punto punto = (Punto) o;
        return x == punto.x && y == punto.y;
    }

    // Implementación del método hashCode
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Punto{" + "x=" + x + ", y=" + y + '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
