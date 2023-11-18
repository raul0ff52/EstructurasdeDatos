public class ArbolAVL {
    NodoAVL raiz;

    public void clearAll() {
        raiz = null;
    }

    public void insertar(int key) {
        raiz = insertarAVL(raiz, key);
    }

    private NodoAVL insertarAVL(NodoAVL nodoActual, int key) {
        if (nodoActual == null) {
            return (new NodoAVL(key));
        }

        if (key < nodoActual.key) {
            nodoActual.left = insertarAVL(nodoActual.left, key);
        } else if (key > nodoActual.key) {
            nodoActual.right = insertarAVL(nodoActual.right, key);
        } else {// Si la clave esta duplicada retorna el mismo nodo encontrado
            return nodoActual;
        }

        nodoActual.altura = 1 +
                max(getAltura(nodoActual.left), getAltura(nodoActual.right));

        int fe = getFactorEquilibrio(nodoActual);

        if (fe > 1 && key < nodoActual.left.key) {
            return rightRotate(nodoActual);
        }

        if (fe < -1 && key > nodoActual.right.key) {
            return leftRotate(nodoActual);
        }

        if (fe > 1 && key > nodoActual.left.key) {
            nodoActual.left = leftRotate(nodoActual.left);
            return rightRotate(nodoActual);
        }

        if (fe < -1 && key < nodoActual.right.key) {
            nodoActual.right = rightRotate(nodoActual.right);
            return leftRotate(nodoActual);
        }

        return nodoActual;
    }

    // Eliminacion
    public void eliminar(int key) {
        raiz = eliminarAVL(raiz, key);
    }

    private NodoAVL eliminarAVL(NodoAVL nodoActual, int key) {
        if (nodoActual == null)
            return nodoActual;

        if (key < nodoActual.key) {
            nodoActual.left = eliminarAVL(nodoActual.left, key);
        } else if (key > nodoActual.key) {
            nodoActual.right = eliminarAVL(nodoActual.right, key);
        } else {
            // El nodo es igual a la clave, se elimina
            // Nodo con un unico hijo o es hoja
            if ((nodoActual.left == null) || (nodoActual.right == null)) {
                NodoAVL temp = null;
                if (temp == nodoActual.left) {
                    temp = nodoActual.right;
                } else {
                    temp = nodoActual.left;
                }

                // Caso que no tiene hijos
                if (temp == null) {
                    nodoActual = null;// Se elimina dejandolo en null
                } else {
                    // Caso con un hijo
                    nodoActual = temp;// Elimina el valor actual reemplazandolo por su hijo
                }
            } else {
                // Nodo con dos hijos, se busca el predecesor
                NodoAVL temp = getNodoConValorMaximo(nodoActual.left);

                // Se copia el dato del predecesor
                nodoActual.key = temp.key;

                // Se elimina el predecesor
                nodoActual.left = eliminarAVL(nodoActual.left, temp.key);
            }
        }

        // Si solo tiene un nodo
        if (nodoActual == null)
            return nodoActual;

        // Actualiza altura
        nodoActual.altura = max(getAltura(nodoActual.left), getAltura(nodoActual.right)) + 1;

        // Calcula factor de equilibrio (FE)
        int fe = getFactorEquilibrio(nodoActual);

        if (fe > 1 && getFactorEquilibrio(nodoActual.left) >= 0) {
            return rightRotate(nodoActual);
        }

        if (fe < -1 && getFactorEquilibrio(nodoActual.right) <= 0) {
            return leftRotate(nodoActual);
        }

        if (fe > 1 && getFactorEquilibrio(nodoActual.left) < 0) {
            nodoActual.left = leftRotate(nodoActual.left);
            return rightRotate(nodoActual);
        }

        if (fe < -1 && getFactorEquilibrio(nodoActual.right) > 0) {
            nodoActual.right = rightRotate(nodoActual.right);
            return leftRotate(nodoActual);
        }

        return nodoActual;
    }

    // rotar hacia la derecha
    public NodoAVL rightRotate(NodoAVL nodoActual) {
        NodoAVL nuevaRaiz = nodoActual.left;
        NodoAVL temp = nuevaRaiz.right;

        // Se realiza la rotacion
        nuevaRaiz.right = nodoActual;
        nodoActual.left = temp;

        // Actualiza alturas
        nodoActual.altura = max(getAltura(nodoActual.left), getAltura(nodoActual.right)) + 1;
        nuevaRaiz.altura = max(getAltura(nuevaRaiz.left), getAltura(nuevaRaiz.right)) + 1;

        return nuevaRaiz;
    }

    // Rotar hacia la izquierda
    public NodoAVL leftRotate(NodoAVL nodoActual) {
        NodoAVL nuevaRaiz = nodoActual.right;
        NodoAVL temp = nuevaRaiz.left;

        // Se realiza la rotacion
        nuevaRaiz.left = nodoActual;
        nodoActual.right = temp;

        // Actualiza alturas
        nodoActual.altura = max(getAltura(nodoActual.left), getAltura(nodoActual.right)) + 1;
        nuevaRaiz.altura = max(getAltura(nuevaRaiz.left), getAltura(nuevaRaiz.right)) + 1;

        return nuevaRaiz;
    }

    // para mostrar el arbol
    public void mostrarArbolAVL() {
        System.out.println("Arbol AVL");
        showTree(raiz, 0);
    }

    private void showTree(NodoAVL nodo, int profundidad) {
        if (nodo.right != null) {
            showTree(nodo.right, profundidad + 1);
        }
        for (int i = 0; i < profundidad; i++) {
            System.out.print("    ");
        }
        System.out.println("(" + nodo.key + ")");

        if (nodo.left != null) {
            showTree(nodo.left, profundidad + 1);
        }
    }

    // Obtiene el peso de un arbol dado
    private int getAltura(NodoAVL nodoActual) {
        if (nodoActual == null) {
            return 0;
        }
        return nodoActual.altura;
    }

    // Devuelve el mayor entre dos numeros
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Obtiene el factor de equilibrio de un nodo
    private int getFactorEquilibrio(NodoAVL nodoActual) {
        if (nodoActual == null) {
            return 0;
        }
        return getAltura(nodoActual.left) - getAltura(nodoActual.right);
    }

    private NodoAVL getNodoConValorMaximo(NodoAVL node) {
        NodoAVL current = node;

        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

}