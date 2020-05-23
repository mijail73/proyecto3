/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3icc;

import java.util.ArrayList;

/**
 *
 * @author oscar
 */
public class Animal {
    private String nombre;
    private final ArrayList<Parte> partes = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Parte> getPartes() {
        return partes;
    }
    
    /**
     * Agrega una parte a un animal, i.e. si la fabrica tiene un Leon en su
     * catalogo pero no fabrica la cola en ese momendo, pasa el tiempo y la
     * fabrica ya puede producir la cola del leon entonces se agrega la cola
     * del leon como parte del animal.
     * Si la parte ya existe y el color ya existe entonces incrementa el numero
     * de partes de dicha parte.
     * Si la parte ya existe pero es de otro color la agrega a las partes Animal.
     * Si la parte no existe la agrega a la lista de partes Animal.
     * Al final ordena la lista por la cantidad de partes.
     * @param nombre
     * @param color
     * @param canditidad
     */
    public void agregaParte(String nombre, String color, int canditidad) {
        if(partes == null) {
            Parte primero = new Parte(nombre, color, canditidad);
            partes.add(primero);
        } else {
            boolean parteYaExistia = false;
            for(int i = 0; i < partes.size(); i++) {
               if(partes.get(i).getNombre().equals(nombre) &&
                       partes.get(i).getColor().equals(color)) {
                   partes.get(i).setCantidad(partes.get(i).getCantidad() +
                           canditidad);
                   parteYaExistia = true;
                   break;
               }
            }
            if(!parteYaExistia) {
                Parte agregar = new Parte(nombre, color, canditidad);
                partes.add(agregar);
            }
        }
        partes.sort((a, b) -> a.getCantidad() - b.getCantidad());
    }

    @Override
    public String toString() {
        String cadena = "";
        cadena = partes.stream().map((x) -> "\t\t\t" + x.toString() + "\n").
                reduce(cadena, String::concat);
        return "Animal{" + "nombre=" + nombre + ", partes=\n" + cadena + "\t\t}";
    }
    
}
