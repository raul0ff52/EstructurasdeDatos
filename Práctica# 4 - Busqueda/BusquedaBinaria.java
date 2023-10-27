import java.util.Random;
import java.util.Arrays;

public class BusquedaBinaria {

    public static int busquedaBinaria(int[] arreglo, int elemento) {
        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arreglo[medio] == elemento) {
                return medio;
            }

            if (arreglo[medio] < elemento) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random random = new Random();

        // Llenar el arreglo
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(5000) + 1;
        }

        // Crear un objeto QuickSortBB y
        //QuickSortBB qsbb = new QuickSortBB();
        QuickSortBB.quickSort(arr);

        int numeroBuscado = 276;

        int indice = busquedaBinaria(arr, numeroBuscado);

        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));

        if (indice != -1) {
            System.out.println("El número " + numeroBuscado + " se encuentra en el índice " + indice);
        } else {
            System.out.println("El número " + numeroBuscado + " no se encuentra en el arreglo");
        }
    }
}
