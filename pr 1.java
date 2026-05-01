import java.util.Scanner;

public class SelectionSortAnalysis {

    
    public static void selectionSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {

        int size = 10000; // Large dataset (you can change to 5000, 20000, etc.)
        int arr[] = new int[size];

        Random rand = new Random();

        
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }

        System.out.println("Dataset size: " + size);

        
        long startTime = System.nanoTime();

        selectionSort(arr);

        
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("Execution Time (in nanoseconds): " + executionTime);
        System.out.println("Execution Time (in milliseconds): " + (executionTime / 1000000.0));
    }
}