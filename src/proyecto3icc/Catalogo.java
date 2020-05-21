/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3icc;

import java.util.ArrayList;

/**
 *
 * @author mijail
 */
public class Catalogo {
    private String nombre;
    private int elementos;
    private ArrayList<Animal> animales;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getElementos() {
        return animales.size();
    }

    public void setElementos(int elementos) {
        this.elementos = elementos;
    }

    public ArrayList<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(ArrayList<Animal> animales) {
        this.animales = animales;
    }
    
}
