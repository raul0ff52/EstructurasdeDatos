import java.util.Arrays;

public class BubbleSort {
    
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swap;

        do{
            swap = false;
            for (int i = 1; i < n; i++){
                if (arr[i - 1] > arr[i]){
                    int temp = arr[i - 1];
                    arr[i -1] = arr[i];
                    arr[i] = temp;
                    swap = true;
                    System.out.println("-" + Arrays.toString(arr)); // Imprime el arreglo en cada cambio
                
                }
            }
        }while (swap);

        return arr;
    }
}
