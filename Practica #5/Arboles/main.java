public class main{
    /**
 * Clase main que contiene la creacion de todos los nodos usados tanto en el arbol normal
 * como en el arbol binario, la estructura de enlazamiento de todos los nodos hermanos e hijos
 * en cada tipo de arbol y su impresion con cada tipo de recorrido, asi como la obtencion de datos
 * como la altura, subarbol, nodo raiz y la comprobacion de estado vacio
 */
public class Main {

    public static void main(String[] args) {
  
      /**
      * Creamos una variable arbol tipo string y la declaramos false
      * y el nodo A sería nuestra raiz
       */
      Arbol<String> arbol = new Arbol<>("A", false);
    
      /**
       * Creamos todos los nodos que vamos a utilizar
       * para el arbol normal a partir del nodo B 
       * hasta el Q
       */
      NodoArbol<String> nodoRaiz = arbol.obtenerRaiz();
      NodoArbol<String> nodoB = new NodoArbol<>("B");
      NodoArbol<String> nodoC = new NodoArbol<>("C");
      NodoArbol<String> nodoD = new NodoArbol<>("D");
      NodoArbol<String> nodoE = new NodoArbol<>("E");
      NodoArbol<String> nodoF = new NodoArbol<>("F");
      NodoArbol<String> nodoG = new NodoArbol<>("G");
      NodoArbol<String> nodoH = new NodoArbol<>("H");
      NodoArbol<String> nodoI = new NodoArbol<>("I");
      NodoArbol<String> nodoJ = new NodoArbol<>("J");
      NodoArbol<String> nodoK = new NodoArbol<>("K");
      NodoArbol<String> nodoL = new NodoArbol<>("L");
      NodoArbol<String> nodoM = new NodoArbol<>("M");
      NodoArbol<String> nodoN = new NodoArbol<>("N");
      NodoArbol<String> nodoO = new NodoArbol<>("O");
      NodoArbol<String> nodoP = new NodoArbol<>("P");
      NodoArbol<String> nodoQ = new NodoArbol<>("Q");
  
      /**
       * Creamos ahora la reación entre los nodos, declrando los
       * parentescos de hijos, hermanos y nietos de cada nodo
       */
      arbol.agregarNodoArbol(nodoRaiz, nodoB);
      arbol.agregarNodoArbol(nodoRaiz, nodoC);
      arbol.agregarNodoArbol(nodoRaiz, nodoD);
      arbol.agregarNodoArbol(nodoB, nodoE);
      arbol.agregarNodoArbol(nodoB, nodoF);
      arbol.agregarNodoArbol(nodoF, nodoJ);
      arbol.agregarNodoArbol(nodoF, nodoK);
      arbol.agregarNodoArbol(nodoF, nodoL);
      arbol.agregarNodoArbol(nodoD, nodoG);
      arbol.agregarNodoArbol(nodoD, nodoH);
      arbol.agregarNodoArbol(nodoD, nodoI);
      arbol.agregarNodoArbol(nodoG, nodoM);
      arbol.agregarNodoArbol(nodoI, nodoN);
      arbol.agregarNodoArbol(nodoI, nodoO);
      arbol.agregarNodoArbol(nodoM, nodoP);
      arbol.agregarNodoArbol(nodoM, nodoQ);
  
    System.out.println("\n--Árbol Ordinario--");
      
    /**
     * Imprimir cada tipo de recorrido del arbol normal 
     */
    System.out.println();
      arbol.imprimirArbol(Recorrido.PREFIJO);
      arbol.imprimirArbol(Recorrido.INFIJO);
      arbol.imprimirArbol(Recorrido.POSFIJO);
  
      /**
       * Impresion de la altura por medio del método obtenerAltura
       */
      System.out.println();
      System.out.println("\n--Altura del árbol: " + arbol.obtenerAltura());
  
      /**
       * Impresion del subarbol a partir del nodo B
       */
      System.out.println("\n--Subarbol B ");
          arbol.imprimirSubArbol(nodoB);
          System.out.println();
  
          /**
           *  Impresion que verifica si el arbol esta vacio o no
           */
          System.out.println("\n--¿El árbol está vacío?");
            System.out.println(arbol.estaVacio() ? "Sí\n" : "No\n");
  
          /* 
          * obtencion del nodo raiz del arbol 
          */
            String raiz = nodoRaiz.getDato();
          System.out.println("--Raíz del árbol: " + raiz);
  
           System.out.println("\n--Árbol Binario--");
  
          /**
           * Creadion de la variable arbolBin para ahora generar la estrutura
           * de un arbol binario con su nodo A raiz decladaro true
           */
           Arbol<String> arbolBin = new Arbol<String>("A", true);
  
          /**
           * Creación de cada nodo a usar mediante la variable arbolBin con sus respectivos
           * nodos hijos, hermanos y nietos, desde el B hasta el Q
           */
           NodoArbol<String> raizBin = arbolBin.obtenerRaiz();
          NodoArbol<String> nodoBinB = new NodoArbol<>("B");
          NodoArbol<String> nodoBinC = new NodoArbol<>("C");
          NodoArbol<String> nodoBinD = new NodoArbol<>("D");
          NodoArbol<String> nodoBinE = new NodoArbol<>("E");
          NodoArbol<String> nodoBinF = new NodoArbol<>("F");
          NodoArbol<String> nodoBinG = new NodoArbol<>("G");
          NodoArbol<String> nodoBinH = new NodoArbol<>("H");
          NodoArbol<String> nodoBinI = new NodoArbol<>("I");
          NodoArbol<String> nodoBinJ = new NodoArbol<>("J");
          NodoArbol<String> nodoBinK = new NodoArbol<>("K");
          NodoArbol<String> nodoBinL = new NodoArbol<>("L");
          NodoArbol<String> nodoBinM = new NodoArbol<>("M");
          NodoArbol<String> nodoBinN = new NodoArbol<>("N");
          NodoArbol<String> nodoBinO = new NodoArbol<>("O");
          NodoArbol<String> nodoBinP = new NodoArbol<>("P");
          NodoArbol<String> nodoBinQ = new NodoArbol<>("Q");
  
          /**
           * Formación de cada nodo hijo a partir de la raiz, teniendo en cuenta
           * que cada hijo debe tener 2 nodos hijos en este tipo de arbol
           * organizando asi nuestro arbol binario 
           */
          arbolBin.agregarNodoArbol(raizBin, nodoBinB);
          arbolBin.agregarNodoArbol(nodoBinB, nodoBinE);
          arbolBin.agregarNodoArbol(nodoBinB, nodoBinC);
          arbolBin.agregarNodoArbol(nodoBinE, nodoBinF);
          arbolBin.agregarNodoArbol(nodoBinF, nodoBinJ);
          arbolBin.agregarNodoArbol(nodoBinJ, nodoBinK);
          arbolBin.agregarNodoArbol(nodoBinK, nodoBinL);
          arbolBin.agregarNodoArbol(nodoBinC, nodoBinD);
          arbolBin.agregarNodoArbol(nodoBinD, nodoBinG);
          arbolBin.agregarNodoArbol(nodoBinG, nodoBinM);
          arbolBin.agregarNodoArbol(nodoBinG, nodoBinH);
          arbolBin.agregarNodoArbol(nodoBinM, nodoBinP);
          arbolBin.agregarNodoArbol(nodoBinP, nodoBinQ);
          arbolBin.agregarNodoArbol(nodoBinH, nodoBinI);
          arbolBin.agregarNodoArbol(nodoBinI, nodoBinN);
          arbolBin.agregarNodoArbol(nodoBinN, nodoBinO);
  
          /**
           * impresion ahora de cada recorrido con el arbol binario 
           */
          System.out.println();
          arbolBin.imprimirArbol(Recorrido.PREFIJO);
          arbolBin.imprimirArbol(Recorrido.INFIJO);
          arbolBin.imprimirArbol(Recorrido.POSFIJO);
  
          /**
           * Impresion de obtecion de la altura del arbol 
           */
          System.out.println();
            System.out.println("\n--Altura del árbol: " + arbolBin.obtenerAltura());
  
          /**
           * Impresion del subarbol a partir del nodo E, en este caso
           */
            System.out.println("--Subarbol E ");
          arbol.imprimirSubArbol(nodoBinE);
          System.out.println();
  
          /**
           * Comprobación del arbol para saber si está vacio o no 
           */
          System.out.println("\n--¿El árbol está vacío?");
            System.out.println(arbolBin.estaVacio() ? "Sí\n" : "No\n");
  
          /**
           * Metodo que nos imprimirá el nodo raiz de este abol binario 
           */
            String raizArbolBin = raizBin.getDato();
          System.out.println("--Raíz del arbol: " + raizArbolBin);
  
          arbolBin.imprimirSubArbol(nodoBinJ);
    }
    
  }
}