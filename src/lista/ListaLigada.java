package lista;

/*
 * Clase ListaLigada con sus operaciones basicas
 * @autor Aaron Cervantes Lopez
 * @version 1.0
 */
public class ListaLigada implements ListaInterfaz{
  // Atributos de la clase
  private Nodo cabeza;
  private int tamanio;
  
  /*
   * Cosntructor por defecto
   */
  public void ListaLigada(){
    cabeza = null;
    tamanio = 0;
  }
  
  @Override
  public int tamanio(){
    return tamanio;
  }
  
  @Override
  public ListaInterfaz cola(){
    ListaLigada resultado = new ListaLigada();
    // Crea una copia de la Lista
    Nodo aux = cabeza;
    // Si la lista es vacia
    if(estaVacia()){
      return null;
    }else{
      // Quita la cabeza y regresa los nodos siguientes
      // de la lista
      aux = aux.getSiguiente();
      while(aux != null){
        resultado.insertaFinal(aux.getElemento());
        aux = aux.getSiguiente();
      }
    }
    return resultado;
  }
  
  @Override
  public void insertaPrimero(Object objeto){
    // Define un nuevo nodo
    Nodo nuevo = new Nodo();
    // Agrega el elemento al nodo
    nuevo.setElemento(objeto);
    // Consulta si la Lista esta vacia
    if(estaVacia()){
      // Inicializa la lista agregando como cabeza al nuevo nodo
      cabeza = nuevo;
      // Caso contrario va agregando los nodos al inicio de la lista
    }else{
      // Une el nuevo nodo con la lista existente
      nuevo.setSiguiente(cabeza);
      // Renombra al nuevo nodo como el inicio de la lista
      cabeza = nuevo;
    }
    // Incrementa el contador de tamanio de la lista
    tamanio++;
  }
  
  @Override
  public void inserta(Object objeto, int indice){
    // Verifica si la posicion ingresada se encuentra en el rango
    // entre 0 y el tamanio de la lista
    if(indice>=0 && indice<=tamanio){
      Nodo nuevo = new Nodo();
      nuevo.setElemento(objeto);
      // Consulta si el nuevo nodo a ingresar va al inicio de la lista
      if(indice == 0){
        // Inserta el nuevo nodo al inicio de la lista
        nuevo.setSiguiente(cabeza);
        cabeza = nuevo;
      }else{
        // Si el nodo a inserta va al final de la lista
        if(indice == tamanio){
          Nodo aux = cabeza;
          // Recorre la lista hasta llegar al ultimo nodo
          while(aux.getSiguiente() != null){
            aux = aux.getSiguiente();
          }
          // Inserta el nuevo nodo despues del ultimo
          aux.setSiguiente(nuevo);
        }else{
          // si el nodo a insertar va en el medio de la lista
          Nodo aux = cabeza;
          // Recorre la lista hasta llegar al nodo anterior
          // a la posicion en la cual se insertara el nuevo nodo
          for(int i =0; i < (indice-1); i++){
            aux = aux.getSiguiente();
          }
          // Guarda el nodo siguiente al nodo en la posicion
          // en la cual va a insertar el nuevo nodo
          Nodo siguiente = aux.getSiguiente();
          // Inserta el nuevo nodo en la posicion indicada
          aux.setSiguiente(nuevo);
          // Une el nuevo nodo con el resto de la lista
          nuevo.setSiguiente(siguiente);
        }
      }
      // Incrementa el contador de tama�o de la lista
      tamanio++;
    }
  }
  
  @Override
  public void insertaFinal(Object objeto){
    // Define un nuevo nodo
    Nodo nuevo = new Nodo();
    // Agrega el elemento al nodo
    nuevo.setElemento(objeto);
    // Consulta si la Lista esta vacia
    if(estaVacia()){
      cabeza = nuevo;
      // Caso contrario recorre la lista hasta llegar
      // al ultimo nodo e insertar el nuevo
    }else{
      // Crea una copia de la Lista
      Nodo aux = cabeza;
      // Recorre la lista hasta llegar al ultimo nodo
      while(aux.getSiguiente() != null){
        aux = aux.getSiguiente();
      }
      // Agrega el nuevo nodo al final de la lista
      aux.setSiguiente(nuevo);
    }
    tamanio++;
  }
  
  @Override
  public Object obtenPrimero(){
    return cabeza.getElemento();
  }
  
  @Override
  public Object obten(int indice){
    // Verifica si el indice ingresado se encuentra en el rango
    if(indice >= 0 && indice < tamanio){
      // Consulta si el indice es el inicio de la Lista
      if(indice == 0){
        // Regresa el elemento
        return cabeza.getElemento();
      }else{
        // Crea una copia de la Lista
        Nodo aux = cabeza;
        // Recorre la Lista hasta el indice indicado
        for(int i = 0; i < indice; i++){
          aux = aux.getSiguiente();
        }
        // Retorna el elemento del nodo
        return aux.getElemento();
      }
    }else{
      return null;
    }
  }
  
  @Override
  public void eliminaPrimero(){
    if(cabeza == null){
      return;
    }
    cabeza = cabeza.getSiguiente();
    tamanio--;
  }
  
  /*
   * Busca si existe un valor en la Lista
   * @param objeto elemento a buscar
   * @return true si existe el objeto en la lista
   */
  public boolean buscar(Object objeto){
    // Crea una copia de la Lista
    Nodo aux = cabeza;
    // Bandera para indicar si el elemento existe
    boolean encontrado = false;
    // Recorre la Lista hasta encontrar el elemento
    // o hasta llegar al final de ella
    while(aux != null && encontrado != true){
      // Consulta si el elemento es igual al elemento pasado
      if(objeto.equals(aux.getElemento())){
        // cambia el valor de la bandera
        encontrado = true;
      }else{
        // Avanza al siguiente nodo
        aux = aux.getSiguiente();
      }
    }
    // Retorna el valor de la bandera
    return encontrado;
  }
  
  @Override
  public void elimina(int indice){
    // Verifica si el indice ingresado esta en el rango 
    if(indice >= 0 && indice < tamanio){
      // Consulta si el nodo a eliminar es el primero
      if(indice == 0){
        cabeza = cabeza.getSiguiente();
        // En caso contrario busca el nodo en medio
        // o al final de la Lista
      }else{
        // Crea una copia de la Lista
        Nodo aux = cabeza;
        // Recorre la Lista hasta llegar al nodo anterior a eliminar
        for(int i = 0; i < indice-1; i++){
          aux = aux.getSiguiente();
        }
        // Guarda el nodo siguiente al nodo a eliminar
        Nodo siguiente = aux.getSiguiente();
        // Elimina la referencia al nodo apuntado al nodo siguiente
        aux.setSiguiente(siguiente.getSiguiente());
      }
      // Disminuye el contador de tamanio de la Lista
      tamanio--;
    }
  }
  
  @Override
  public int indice(Object objeto){
    // Consulta si el elemento existe en la Lista
    if(buscar(objeto)){
      // Crea una copia de la Lista
      Nodo aux = cabeza;
      // Contador para almacenar el indice del nodo
      int cont = 0;
      // Recorre la lista hasta llegar al nodo de referencia
      while(objeto != aux.getElemento()){
        // Incrementa el contador
        cont++;
        // Avanza al siguiente nodo
        aux.getSiguiente();
      }
      // Retorna el valor del contador
      return cont;
      // En caso contrario, regresa -1
    }else{
      return -1;
    }
  }
  
  @Override
  public boolean estaVacia(){
    return cabeza == null;
  }
  
  @Override
  public ListaInterfaz concatena(ListaInterfaz otra){
    // Se crea una lista que sera la lista concatenada
    ListaLigada resultado = new ListaLigada();
    // Se crea una copia de la lista
    Nodo iterador = cabeza;
    // Recorre la lista e ingresa los valores a resultado
    while(iterador != null){
      resultado.insertaFinal(iterador.getElemento());
      iterador = iterador.getSiguiente();
    }
    // Cast de objeto ListaInterfaz a ListaLigada
    ListaLigada aux = (ListaLigada) otra;
    iterador = aux.cabeza;
    // Recorre la lista otra agregando sus elementos
    // a resultado
    while(iterador != null){
      resultado.insertaFinal(iterador.getElemento());
      iterador = iterador.getSiguiente();
    }
    return resultado;
  }
  
  @Override
  public void limpia(){
    cabeza = null;
    tamanio = 0;
  }
  
  /*
   * Muestra los elementos de la Lista
   */
  public void listar(){
    // Verifica si la Lista contiene elementos
    if(!estaVacia()){
      // Crea una copia de la Lista
      Nodo aux = cabeza;
      int i = 0;
      // Recorre la Lista hasta el final
      while(aux != null){
        // Imprime en pantalla el valor del nodo
        System.out.print(i+".[ "+aux.getElemento()+" ]"+" -> ");
        // Avanza al siguiente nodo
        aux = aux.getSiguiente();
        i++;
      }
      System.out.print("|-");
      System.out.println();
    }
  }
  
  public static void main(String[] args){
    ListaLigada lista = new ListaLigada();
    
    lista.insertaFinal(7);
    lista.insertaFinal(11);
    lista.insertaFinal(13);
    lista.insertaPrimero(5);
    lista.insertaPrimero(3);
    lista.insertaPrimero(2);
    lista.inserta(4,2);
    
    System.out.println("-----Lista 1-----");
    lista.listar();
    
    System.out.println("-----Tama�o de la lista 1-----");
    System.out.println(lista.tamanio());
    
    System.out.println("-----Primer elemento de la lista 1-----");
    System.out.println(lista.obtenPrimero());
    
    System.out.println("-----Elemento del nodo en el indice 4 de la lista 1-----");
    System.out.println(lista.obten(4));
    
    ListaLigada lista2 = (ListaLigada) lista.cola();
    System.out.println("--------------Cola de la lista 1------------");
    lista2.listar();
    
    ListaLigada listaotra = new ListaLigada();
    
    listaotra.insertaFinal(8);
    listaotra.insertaPrimero(4);
    listaotra.insertaPrimero(12);
    listaotra.insertaPrimero(9);
    
    System.out.println("-----Otra lista-----");
    listaotra.listar();    
    
    ListaLigada lista3 = (ListaLigada) lista.concatena(listaotra);
    System.out.println("-----Lista 2 concetenada (lista 1 con otra lista)-----");
    lista3.listar();
    System.out.println("-----Tama�o de la lista 2-----");
    System.out.println(lista3.tamanio());
    
    System.out.println("-----Elimina el primer nodo de lista 2-----");
    lista3.eliminaPrimero();
    lista3.listar();
    System.out.println("-----Tama�o de la lista 2-----");
    System.out.println(lista3.tamanio());
    
    System.out.println("-----Elimina el nodo en el indice 5 de la lista 2-----");
    lista3.elimina(5);
    lista3.listar();
    System.out.println("-----Tama�o de la lista 2-----");
    System.out.println(lista3.tamanio());
    
    //System.out.println("-----Indice del elemento 7 en la lista 2-----");
    //System.out.println(lista3.indice(7));
    
    System.out.println("-----Elimina la lista 2-----\n");
    lista3.limpia();
    
    System.out.println("-----La lista 2 es vacia?");
    System.out.println(lista3.estaVacia());
  }
  
}