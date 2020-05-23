/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3icc;

/**
 * Objeto que nos sirve para modelar la parte de un animal
 * @author oscar
 */
public class Parte {
    private String nombre;
    private String color;
    private int cantidad;
    
    public Parte(String nombre, String color, int cantidad) {
        this.nombre = nombre;
        this.color = color;
        this.cantidad = cantidad;
    }
    
    public Parte(Parte a) {
        this.nombre = a.nombre;
        this.color = a.color;
        this.cantidad = a.cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Parte{" + "nombre=" + nombre + ", color=" + color +
                ", cantidad=" + cantidad + '}';
    }
}
