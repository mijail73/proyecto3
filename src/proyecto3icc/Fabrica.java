/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3icc;

/**
 *
 * @author oscar
 */
public class Fabrica {
    private final String nombre;
    private final Catalogo catalogo;

    public Fabrica(String nombre, Catalogo catalogo) {
        this.nombre = nombre;
        this.catalogo = catalogo;
    }

    public String getNombre() {
        return nombre;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }
    
    @Override
    public String toString() {
        return "Fabrica{" + "nombre=" + nombre + ", catalogo=\n" + catalogo + '}';
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Catalogo test = new Catalogo("2020-1");
        Animal Leon = new Animal("León");
        Animal Tigre = new Animal("Tigre");
        Leon.agregaParte("Pecho Leon", "Naranja", 3);
        Leon.agregaParte("cola Leon", "Amarilla", 6);
        Leon.agregaParte("cola Leon", "Amarilla", 6);
        System.out.println(Leon.toString());
        test.agregaAnimal(Leon);
        test.agregaAnimal(Tigre);
        System.out.println(test);
        test.agregaAnimal(Tigre);
        Fabrica miFabrica = new Fabrica("De La Rosa", test);
        System.out.println(miFabrica);
        Alebrije nuevo = new Alebrije("LeonTigre", miFabrica);
        System.out.println("\n\n\n\n");
        nuevo.mostrarPartes(miFabrica);
        nuevo.agregaParte("león", 0);
        //System.out.println("testtt");
        nuevo.mostrarPartes(miFabrica);
        nuevo.agregaParte("león", 0);
        //System.out.println("testtt");
        nuevo.mostrarPartes(miFabrica);
        nuevo.agregaParte("león", 0);
        //System.out.println("testtt");
        nuevo.mostrarPartes(miFabrica);
        nuevo.agregaParte("león", 0);
        System.out.println("testtt");
        System.out.println(miFabrica.toString());
        nuevo.mostrarPartes(miFabrica);
        nuevo.mostrarPartes(miFabrica);
        System.out.println(miFabrica.toString());
        System.out.println(nuevo);
        
    }
}
