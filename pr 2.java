import java.util.Scanner;

public class BubbleSortAnalysis {

    
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                   
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int size = 10000; // Try 1000, 5000, 15000 etc.
        int arr[] = new int[size];

        Random rand = new Random();

        
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }

        System.out.println("Dataset size: " + size);

        
        long startTime = System.nanoTime();

        bubbleSort(arr);

        
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("Execution Time (nanoseconds): " + executionTime);
        System.out.println("Execution Time (milliseconds): " + (executionTime / 1000000.0));
    }
}