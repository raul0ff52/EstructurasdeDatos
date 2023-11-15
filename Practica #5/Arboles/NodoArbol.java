/**
 * Clase NodoArbol que representa un nodo de un argol generico
 * 
 */

public class NodoArbol <T> {
  private T dato;
  private boolean esBinario = false;
  private NodoArbol <T> primerHijo;
  private NodoArbol <T> siguienteHermano;

  /**
   * Constructor de la clase nodoArbol 
   * @param dato El dato que se almacenara en el nodo
   */
  public NodoArbol (T dato) {
    this.dato = dato;
    primerHijo = null;
    siguienteHermano = null;
  }

  /**
   * Metodo que agrega un hijo al nodo 
   * @param hijo El nodo hijo que se agregara al nodo
   */
  public void agregarHijo (NodoArbol <T> hijo) {
    if (primerHijo == null) {
      primerHijo = hijo;
    } else {
      NodoArbol<T> hermano = this.primerHijo;

      if (esBinario) {
        if (hermano.siguienteHermano != null) {
          System.err.println("El nodo ya tiene un hijo, no se debe agregar " + hijo.getDato());	
        } else {
          hermano.siguienteHermano = hijo;
        }
      } else {
        while (hermano.siguienteHermano != null) {
          hermano = hermano.siguienteHermano;
        }
        hermano.siguienteHermano = hijo;
      }      
    }
  }


  /**
   * Metodo que obtiene el primero hijo del nodo
   * @return El primer hijo del nodo
   */
  public NodoArbol<T> obtenerPrimerHijo () {
    return primerHijo;
  }

  /**
   * Metodo para obtener el siguiente hermano del nodo
   * @return El siguiente hermano del nodo
   */
  public NodoArbol<T> obtenerSiguienteHermano () {
    return siguienteHermano;
  }

  /**
   * Metodo que obtine el dato alamacenado en el nodo
   * @return El dato almacenado en el nodo
   */
  public T getDato () {
    return dato;
  }


  /**
   * Metodo para checar si el nodo es binario
   * @return Verdadero si el nodo es binario
   */
  public boolean esBinario () {
    return esBinario;
  }


  /**
   * Metodo para establecer si el nodo es binario
   * @param esBinario Indica si el nodo es binario
   */
  public void setEsBinario (boolean esBinario) {
    this.esBinario = esBinario;
  }

  /**
   * Metodo para impirmir el nodo y sus hijos en prefijo
   */
  public void imprimirEnPrefijo() {
    System.out.print(dato + "\t");
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPrefijo();
      hijo = hijo.siguienteHermano;
    }
  }

  /**
   * Metodo para impirmir el nodo y sus hijos en infijo
   */
  public void imprimirEnInfijo() {
    NodoArbol<T> hijo = primerHijo;

    if (hijo != null) {
      hijo.imprimirEnInfijo();
    }

    System.out.print(dato + "\t");
    while (hijo != null) {
      hijo = hijo.siguienteHermano;
      if (hijo != null) {
        hijo.imprimirEnInfijo();
      }
    }
  }

  /**
   * Metodo para imprimir el nodo y sus hijos en posfijo
   */
  public void imprimirEnPosfijo() {
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPosfijo();
      hijo = hijo.siguienteHermano;
    }

    System.out.print(dato + "\t");
  }
}