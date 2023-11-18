public class NodoArbolB {

    int n; //numero de claves almacenadas en el nodo
    boolean hoja; //Si el nodo es hoja (nodo hoja=true; nodo interno=false)
    int key[];  //almacena las claves en el nodo
    NodoArbolB hijo[]; //arreglo con referencias a los hijos

    //Constructores
    public NodoArbolB(int t) {
        n = 0;
        hoja = true;
        key = new int[((2 * t) - 1)];
        hijo = new NodoArbolB[(2 * t)];
    }

    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(key[i] + " | ");
            } else {
                System.out.print(key[i]);
            }
        }
        System.out.print("]");
    }

    public int find(int k) {
        for (int i = 0; i < n; i++) {
            if (key[i] == k) {
                return i;
            }
        }
        return -1;
    }
}