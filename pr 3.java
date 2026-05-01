import java.util.Scanner;

public class InsertionSortAnalysis {

    
    public static void insertionSort(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int size = 10000; 
        int arr[] = new int[size];

        Random rand = new Random();

        
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }

        System.out.println("Dataset size: " + size);

        
        long startTime = System.nanoTime();

        insertionSort(arr);

       
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("Execution Time (nanoseconds): " + executionTime);
        System.out.println("Execution Time (milliseconds): " + (executionTime / 1000000.0));
    }
}