import java.util.Scanner;
import java.util.Arrays;

public class SearchAnalysis {

  
    public static int linearSearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    
    public static int binarySearch(int arr[], int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        
        long start1 = System.nanoTime();
        int result1 = linearSearch(arr, key);
        long end1 = System.nanoTime();

        if (result1 != -1)
            System.out.println("Linear Search: Element found at index " + result1);
        else
            System.out.println("Linear Search: Element not found");

        System.out.println("Linear Search Time (ns): " + (end1 - start1));

        
        Arrays.sort(arr); 

        long start2 = System.nanoTime();
        int result2 = binarySearch(arr, key);
        long end2 = System.nanoTime();

        if (result2 != -1)
            System.out.println("Binary Search: Element found at index " + result2);
        else
            System.out.println("Binary Search: Element not found");

        System.out.println("Binary Search Time (ns): " + (end2 - start2));

        sc.close();
    }
}