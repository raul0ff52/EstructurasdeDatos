public class MainB {
    public static void main(String[] args) {
        int t = 3;
        ArbolB arbolB = new ArbolB(t);

        // Valores a ingresar 
        int[] valoresUno = { 27, 18, 78, 56, 15 };
   
        System.out.println("INSERTANDO VALORES AL ARBOL B");
        for (int i = 0; i < valoresUno.length; i++) {
            System.out.println("Insertando valor " + valoresUno[i]);
            arbolB.insertar(valoresUno[i]);
        }

        // Mostrando arbol B 
        arbolB.showBTree();
        System.out.println("");

        // Valores a ingresar 
        System.out.println("Insertando valor 69");
        arbolB.insertar(69);
        // Mostrando arbol B 
        arbolB.showBTree();
        System.out.println("");

        // Valores a ingresar 
        System.out.println("Insertando valor 23");
        arbolB.insertar(23);
        System.out.println("Insertando valor 34");
        arbolB.insertar(34);
        System.out.println("Insertando valor 95");
        arbolB.insertar(95);
        // Mostrando arbol B 
        arbolB.showBTree();
        System.out.println("");

        // Buscar
        System.out.println("\nBuscando el nodo con el valor 23 en el arbol B:");
        arbolB.buscarNodoPorClave(23);

       
    }

}
