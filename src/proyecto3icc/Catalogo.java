/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3icc;

import java.util.ArrayList;

/**
 * Un catalogo tienen nombre el numero de animales que lo conforman y una lista
 * de dichos animales. Podemos agregar y borrar animales en nuestro catalogo.
 * @author oscar
 */
public class Catalogo {
    private final String nombre;
    private int elementos;
    private final ArrayList<Animal> animales = new ArrayList<>();

    public Catalogo(String nombre) {
        this.nombre = nombre;
        elementos = 0;
    }

    public ArrayList<Animal> getAnimales() {
        return animales;
    }
    
    /**
     * Si un animal con el mismo nombre ya se encuentra en el catalogo entonces
     * no agregamos dicho animal y mandamos mensaje.
     * Si la lista de animales del catalogo es null entonces agregamos el 
     * animal al catalogo.
     * Si no existe un animal en el catalogo con el nombre del nuevo animal
     * entonces agregamos dicho animal al catalogo.
     * Si agrego el animal aumentamos nuetros elementos del catalogo.
     * Los ordena alfabeticamente al final.
     * @param animal 
     */
    public void agregaAnimal(Animal animal) {
        if(animales == null) {
            animales.add(animal);
            elementos++;
        }
        else {
            Animal contenido = animales.stream()
                    .filter(x -> x.getNombre().toLowerCase().
                            equals(animal.getNombre().toLowerCase()))
                    .findFirst()
                    .orElse(null);
            if(contenido == null) {
                animales.add(animal);
                elementos++;
            } else
                System.out.println("El animal ya se encuentra en el catalogo.");
        }
        animales.sort((a1, a2) -> a1.getNombre().compareTo(a2.getNombre()));
    }
    
    /**
     * Borra un Animal de nuestro catalogo, con una busqueda por nombre, es
     * decir si nuestro catalogo tiene un Animal con nombre de el parametro de
     * este metodo entonces borra el animal del catalog, en caso contrario
     * manda mensaje de que dicho animal no esta en el catalogo.
     * Si borra un animal decrementamos nuestros elemenots del catalogo.
     * @param nombre 
     */
    public void borraAnimal(String nombre) {
        if(!animales.removeIf(x -> x.getNombre().toLowerCase()
                .equals(nombre.toLowerCase()))) {
            System.out.println("Dicho animal no esta en la lista, por lo que no"
                    + "se borro nada.");
        } else
            elementos--;
    }

    @Override
    public String toString() {
        String cadena = "";
        cadena = animales.stream().map(x -> "\t\t" + x.toString() + "\n")
                .reduce(cadena, String::concat);
        return "\tCatalogo{" + "nombre=" + nombre + ", elementos=" + elementos + 
                ", animales=\n" + cadena + "\t}\n";
    }
}
