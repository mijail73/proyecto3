/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3icc;

import java.util.ArrayList;


/**
 * Un alebrije se crea en una Fabrica, por lo que necesitamos tener una fabrica
 * de dicha fabrica accederemos a su catalogo, de su catalogo a los animales
 * y de los animales a las partes, ocuparemos partes de dichos animales para 
 * crear nuestro alebrije. Asi entonces un alibrije es una Lista de partes de
 * animales. Cada vez que agerremos una pieza (parte de animal) de una fabrica
 * esta parte decrementara su valor en uno, si dicha parte llega a cero, 
 * se borrara dicha parte de la fabrica. (o lo que es lo mismo, se borra el 
 * elemento de la lista de partes, del animal del catalogo de la fabrica.)
 * Para la creacion de un alebrije el limite es el stock de partes de la fabrica
 * y tu imaginación.
 * @author oscar
 */
public class Alebrije {
    private final String nombre;
    private final ArrayList<Parte> partes = new ArrayList<>();
    private final Fabrica fabrica;
    
    public Alebrije(String nombre, Fabrica fabrica) {
        this.nombre = nombre;
        this.fabrica = fabrica;
    }
    
    /**
     * Muestra las partes de la fabrica ordenados lexicograficamente el nombre
     * del animal.
     * @param a 
     */
    public void mostrarPartes(Fabrica a) {
        for (int i = 0; i < a.getCatalogo().getAnimales().size(); i++) {
            for(int j = 0; j < a.getCatalogo().getAnimales().get(i)
                    .getPartes().size(); j++) {
                System.out.println("Animal[" + a.getCatalogo().getAnimales()
                        .get(i).getNombre() + "]" + "Parte[" + j + "]" +
                        a.getCatalogo().getAnimales().get(i)
                    .getPartes().get(j));
            }
        }
    }
    
    /**
     * Agrega una parte de un animal al Alebrije.
     * Requiere el nombre del animal y el indice de la parte de dicho animal.
     * Verifica que en nombre del animal exista en el catalogo de la fabrica.
     * Verifica que el indice de la parte este en el rango de las partes del 
     * animal de la fabrica.
     * Si agrega la parte entonces decrementa en uno el stock de dicha parte
     * de la fabrica, si la cantidad de piezas llega a cero entonces borramos 
     * esa parte de animal de la fabrica.
     * @param nombre
     * @param indiceParte 
     */
    public void agregaParte(String nombre, int indiceParte) {
        Animal contenido = fabrica.getCatalogo().getAnimales().stream()
                .filter(x -> x.getNombre().toLowerCase()
                .equals(nombre.toLowerCase()))
                .findFirst()
                .orElse(null);
        if(contenido == null) {
            System.out.println("Porfavor ingresa el nombre de un animal "
                    + "existente en la fabrica.");
        } else if(indiceParte > contenido.getPartes().size() - 1 ||
                indiceParte < 0) {
            System.out.println("Porfavor ingresa un indice de parte de animal "
                    + "existente en la fabrica.");
        } else {
            for (int i = 0; i < fabrica.getCatalogo().getAnimales().size();
                    i++) {
                if(fabrica.getCatalogo().getAnimales().get(i).getNombre()
                        .toLowerCase().equals(nombre.toLowerCase())) {
                    Parte alebrije = new Parte(fabrica.getCatalogo()
                            .getAnimales().get(i).getPartes().get(indiceParte));
                    alebrije.setCantidad(1);
                    partes.add(alebrije);
                    // Decrementamos
                    fabrica.getCatalogo().getAnimales().get(i).getPartes()
                            .get(indiceParte).setCantidad(fabrica.getCatalogo()
                                    .getAnimales().get(i).getPartes()
                                    .get(indiceParte).getCantidad() - 1);
                    //Si llega a cero borramos dicha parte
                    if(fabrica.getCatalogo().getAnimales().get(i).getPartes()
                            .get(indiceParte).getCantidad() == 0) {
                        fabrica.getCatalogo().getAnimales().get(i).getPartes()
                                .remove(indiceParte);
                    }
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
        String cadena = "";
        cadena = partes.stream().map(x -> "\t" + x.toString() + "\n")
                .reduce(cadena, String::concat);
        return "Alebrije{" + "nombre=" + nombre + ", fabrica=" +
                fabrica.getNombre() + ", partes=\n" + cadena +  '}';
    }
}