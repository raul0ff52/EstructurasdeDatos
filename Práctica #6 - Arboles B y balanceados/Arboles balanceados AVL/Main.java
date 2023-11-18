public class Main {

  public static void main(String[] args) {
    ArbolAVL arbol = new ArbolAVL();

    arbol.insertar(10);
    arbol.insertar(5);
    arbol.insertar(15);
    arbol.insertar(3);
    arbol.insertar(7);
    arbol.insertar(20);
    arbol.insertar(12);
    arbol.insertar(5);

    arbol.mostrarArbolAVL();

    // Eliminar elemento
    arbol.eliminar(3);

    arbol.mostrarArbolAVL();

    // Rotación a la derecha
    arbol.raiz = arbol.rightRotate(arbol.raiz);

   
    System.out.println("Arbol rotado a la derecha: ");
    arbol.mostrarArbolAVL();

    // Rotación a la izquierda
    System.out.println("Arbol rotado a la izquierda: ");
    arbol.raiz = arbol.leftRotate(arbol.raiz);

    
    arbol.mostrarArbolAVL();
  }

}