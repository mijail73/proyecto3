package lista;

/*
 * Clase Nodo define los elementos que debe tener
 * un Nodo de una lista
 * @autor Aaron Cervantes Lopez
 * @version 1.0
 */
public class Nodo{
  // Atributos de la clase
  private Object elemento;
  private Nodo siguiente;
  
  /*
   * Metodo constructor de un Nodo
   */
  public void Nodo(){
    this.elemento = 0;
    this.siguiente = null;
  }
  
  // Metodos Getters and Setter
  public Object getElemento(){
    return elemento;
  }
  
  public void setElemento(Object elemento){
    this.elemento = elemento;
  }
  
  public Nodo getSiguiente(){
    return siguiente;
  }
  
  public void setSiguiente(Nodo siguiente){
    this.siguiente = siguiente;
  }
  
}