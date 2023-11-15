
/**
 * Clase arbol que representa un arbol generico
 */
public class Arbol <T> {
  private NodoArbol <T> raiz;
  private boolean esBinario = false;
  boolean estaVacio = false;


  /**
   * Constructor de la clase Arbol
   * @param dato El dato que se alamacenara en la raiz del arbol
   * @param esBinario Indidca si es binario
   */
  public Arbol (T dato, boolean esBinario) {
    raiz = new NodoArbol <T> (dato);
    raiz.setEsBinario(esBinario);
    this.esBinario = esBinario;
  }
   
  /**
   * Este metodo obtiene la raiz del arbol
   * @return
   */
  public NodoArbol <T> obtenerRaiz() {
    return raiz;
  }

  
  /**
   * Este metodo  verifica si es binario
   * @return
   */
  public boolean esBinario() {
    return esBinario;
  }
    
  
  /**
   * Ese metodo agrega un nuevo nodo al arbol 
   * @param nodoRaiz nodo donde se va agregar el nuevo nodo
   * @param nodoAgregado Es el nuevo nodo a agregar
   */
  public void agregarNodoArbol(NodoArbol <T> nodoRaiz, NodoArbol <T> nodoAgregado) {
    if (esBinario) {
      nodoAgregado.setEsBinario(esBinario);
    }

    nodoRaiz.agregarHijo(nodoAgregado);
  }




  
  /**
   * Este metodo imprime el arbol 
   * @param recorrido El tipo de recorrido (pre, inf, pos)
   */
  public void imprimirArbol(Recorrido recorrido) {
    switch (recorrido.ordinal()) {
      case 0:
        System.out.println("Prefijo: ");
        raiz.imprimirEnPrefijo();
        break;

      case 1:
        System.out.println("\nInfijo: ");
        raiz.imprimirEnInfijo();
        break;

      case 2:
        System.out.println("\nPosfijo: ");
        raiz.imprimirEnPosfijo();
        break;
    
      default:
        break;
    }
  }

   /**
   * Método para la impresion del subarbol a partir de cierto nodo dependiendo del arbol
   * en cada uno de los tipos de recorrido
   * @param nodoSubArbol
   */
  public void imprimirSubArbol(NodoArbol<T> nodoSubArbol) {
    System.out.println("Impresión en Prefijo: ");
    nodoSubArbol.imprimirEnPrefijo();
    System.out.println();

    System.out.println("Impresión en Infijo: ");
    nodoSubArbol.imprimirEnInfijo();
    System.out.println();

    System.out.println("Impresión en Posfijo");
    nodoSubArbol.imprimirEnPosfijo();

  }
  
  /**
   * Booleano que nos retornará la comprobacion del estado del arbol, si esta vacio o no
   * @return
   */
  public boolean estaVacio() {
    return estaVacio;
  }

  /**
   * Metodo que nos retornara la altura obtenida del arbol correspondiente
   * @return
   */
  public int obtenerAltura() {
    return obtenerAltura(raiz);
  }

  /**
   * Logica detras del metodo obtener altura, utilizando un if que comprueba la existencia de un nodo,
   * así un else que nos dara la altura con ayuda de los nodos hijos y hermanos y se le sumara 1 por el 
   * nodo raiz
   * @param nodo
   * @return
   */
  private int obtenerAltura(NodoArbol<T> nodo) {
    if (nodo == null) {
      return 0;
    } else {
      int altura = 0;
      NodoArbol<T> hijo = nodo.obtenerPrimerHijo();
      while (hijo != null) {
        altura = Math.max(altura, obtenerAltura(hijo));
        hijo = hijo.obtenerSiguienteHermano();
      }
      return altura + 1;
    }
}
}