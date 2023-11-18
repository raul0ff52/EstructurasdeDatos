public class ArbolB {
    NodoArbolB raiz;
    int t;

    //Constructor
    public ArbolB(int t) {
        this.t = t;
        raiz = new NodoArbolB(t);
    }

    //Busca el valor ingresado y muestra el contenido del nodo que contiene el valor
    public void buscarNodoPorClave(int num) {
        NodoArbolB temp = search(raiz, num);

        if (temp == null) {
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        } else {
            print(temp);
        }
    }

    //Search
    private NodoArbolB search(NodoArbolB actual, int key) {
        int i = 0;//se empieza a buscar en la primera posicion

        while (i < actual.n && key > actual.key[i]) {
            i++;
        }
        //Si la clave es igual, entonces retornamos el nodo
        if (i < actual.n && key == actual.key[i]) {
            return actual;
        }

        //Se revisa primero si tiene hijos
        if (actual.hoja) {
            return null;
        } else {
            //Si tiene hijos, hace una llamada recursiva
            return search(actual.hijo[i], key);
        }
    }

    public void insertar(int key) {
        NodoArbolB r = raiz;

        //Si el nodo esta lleno lo debe separar antes de insertar
        if (r.n == ((2 * t) - 1)) {
            NodoArbolB s = new NodoArbolB(t);
            raiz = s;
            s.hoja = false;
            s.n = 0;
            s.hijo[0] = r;
            split(s, 0, r);
            nonFullInsert(s, key);
        } else {
            nonFullInsert(r, key);
        }
    }
    
    
    private void split(NodoArbolB x, int i, NodoArbolB y) {
        //Nodo temporal que sera el hijo i + 1 de x
        NodoArbolB z = new NodoArbolB(t);
        z.hoja = y.hoja;
        z.n = (t - 1);

        
        for (int j = 0; j < (t - 1); j++) {
            z.key[j] = y.key[(j + t)];
        }

        //Si no es hoja hay que reasignar los nodos hijos
        if (!y.hoja) {
            for (int k = 0; k < t; k++) {
                z.hijo[k] = y.hijo[(k + t)];
            }
        }

                                                      
        y.n = (t - 1);                                                        
                                                                               
       
        for (int j = x.n; j > i; j--) {
            x.hijo[(j + 1)] = x.hijo[j];
        }
        //Reasigna el hijo (i+1) de x                                          
        x.hijo[(i + 1)] = z;                                                 
                                                                               
        for (int j = x.n; j > i; j--) {
            x.key[(j + 1)] = x.key[j];
        }

        //Agrega la clave situada en la mediana                                 
        x.key[i] = y.key[(t - 1)];                                             
        x.n++;                                                                  
    }

    private void nonFullInsert(NodoArbolB x, int key) {
        //Si es una hoja
        if (x.hoja) {
            int i = x.n; //cantidad de valores del nodo
            //busca la posicion i donde asignar el valor
            while (i >= 1 && key < x.key[i - 1]) {
                x.key[i] = x.key[i - 1];//Desplaza los valores mayores a key
                i--;
            }

            x.key[i] = key;//asigna el valor al nodo
            x.n++; //aumenta la cantidad de elementos del nodo
        } else {
            int j = 0;
            //Busca la posicion del hijo
            while (j < x.n && key > x.key[j]) {
                j++;
            }

            //Si el nodo hijo esta lleno lo separa
            if (x.hijo[j].n == (2 * t - 1)) {
                split(x, j, x.hijo[j]);

                if (key > x.key[j]) {
                    j++;
                }
            }

            nonFullInsert(x.hijo[j], key);
        }
    }

    public void showBTree() {
        print(raiz);
    }

    //Print en preorder
    private void print(NodoArbolB n) {
        n.imprimir();

        //Si no es hoja
        if (!n.hoja) {
            //recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.n; j++) {
                if (n.hijo[j] != null) {
                    System.out.println();
                    print(n.hijo[j]);
                }
            }
        }
    }

    //ELiminar (q ya se acabe esto dios)
    public void eliminar(int key) {
        delete(raiz, key);
    }
    
    private void delete(NodoArbolB actual, int key) {
        if (actual == null) {
            return;
        }
    
        int idx = findKeyIndex(actual, key);
    
        // Si la clave está presente en el nodo actual
        if (idx < actual.n && actual.key[idx] == key) {
            if (actual.hoja) {
                removeFromLeaf(actual, idx);
            } else {
                removeFromNonLeaf(actual, idx);
            }
        } else {
            boolean esHijoUltimo = (idx == actual.n);
    
            if (actual.hijo[idx].n < t) {
                fill(actual, idx);
            }
    
            if (esHijoUltimo && idx > actual.n) {
                delete(actual.hijo[idx - 1], key);
            } else {
                delete(actual.hijo[idx], key);
            }
        }
    }
    
    private int findKeyIndex(NodoArbolB actual, int key) {
        int idx = 0;
        while (idx < actual.n && actual.key[idx] < key) {
            ++idx;
        }
        return idx;
    }
    
    private void removeFromLeaf(NodoArbolB actual, int idx) {
        for (int i = idx + 1; i < actual.n; ++i) {
            actual.key[i - 1] = actual.key[i];
        }
        actual.n--;
    }
    
    private void removeFromNonLeaf(NodoArbolB actual, int idx) {
        int k = actual.key[idx];
    
        if (actual.hijo[idx].n >= t) {
            int pred = getPredecessor(actual, idx);
            actual.key[idx] = pred;
            delete(actual.hijo[idx], pred);
        } else if (actual.hijo[idx + 1].n >= t) {
            int succ = getSuccessor(actual, idx);
            actual.key[idx] = succ;
            delete(actual.hijo[idx + 1], succ);
        } else {
            merge(actual, idx);
            delete(actual.hijo[idx], k);
        }
    }
    
    private int getPredecessor(NodoArbolB actual, int idx) {
        NodoArbolB temp = actual.hijo[idx];
        while (!temp.hoja) {
            temp = temp.hijo[temp.n];
        }
        return temp.key[temp.n - 1];
    }
    
    private int getSuccessor(NodoArbolB actual, int idx) {
        NodoArbolB temp = actual.hijo[idx + 1];
        while (!temp.hoja) {
            temp = temp.hijo[0];
        }
        return temp.key[0];
    }
    
    private void fill(NodoArbolB actual, int idx) {
        if (idx != 0 && actual.hijo[idx - 1].n >= t) {
            borrowFromPrev(actual, idx);
        } else if (idx != actual.n && actual.hijo[idx + 1].n >= t) {
            borrowFromNext(actual, idx);
        } else {
            if (idx != actual.n) {
                merge(actual, idx);
            } else {
                merge(actual, idx - 1);
            }
        }
    }
    
    private void borrowFromPrev(NodoArbolB actual, int idx) {
        NodoArbolB child = actual.hijo[idx];
        NodoArbolB sibling = actual.hijo[idx - 1];
    
        for (int i = child.n - 1; i >= 0; --i) {
            child.key[i + 1] = child.key[i];
        }
    
        if (!child.hoja) {
            for (int i = child.n; i >= 0; --i) {
                child.hijo[i + 1] = child.hijo[i];
            }
        }
    
        child.key[0] = actual.key[idx - 1];
    
        if (!child.hoja) {
            child.hijo[0] = sibling.hijo[sibling.n];
        }
    
        actual.key[idx - 1] = sibling.key[sibling.n - 1];
    
        child.n++;
        sibling.n--;
    }
    
    private void borrowFromNext(NodoArbolB actual, int idx) {
        NodoArbolB child = actual.hijo[idx];
        NodoArbolB sibling = actual.hijo[idx + 1];
    
        child.key[child.n] = actual.key[idx];
    
        if (!child.hoja) {
            child.hijo[child.n + 1] = sibling.hijo[0];
        }
    
        actual.key[idx] = sibling.key[0];
    
        for (int i = 1; i < sibling.n; ++i) {
            sibling.key[i - 1] = sibling.key[i];
        }
    
        if (!sibling.hoja) {
            for (int i = 1; i <= sibling.n; ++i) {
                sibling.hijo[i - 1] = sibling.hijo[i];
            }
        }
    
        child.n++;
        sibling.n--;
    }
    
    private void merge(NodoArbolB actual, int idx) {
        NodoArbolB child = actual.hijo[idx];
        NodoArbolB sibling = actual.hijo[idx + 1];
    
        child.key[t - 1] = actual.key[idx];
    
        for (int i = 0; i < sibling.n; ++i) {
            child.key[i + t] = sibling.key[i];
        }
    
        if (!child.hoja) {
            for (int i = 0; i <= sibling.n; ++i) {
                child.hijo[i + t] = sibling.hijo[i];
            }
        }
    
        for (int i = idx + 1; i < actual.n; ++i) {
            actual.key[i - 1] = actual.key[i];
        }
    
        for (int i = idx + 2; i <= actual.n; ++i) {
            actual.hijo[i - 1] = actual.hijo[i];
        }
    
        child.n += sibling.n + 1;
        actual.n--;
    
        sibling = null;
    }
    
}