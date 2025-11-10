import java.util.Arrays;
import java.util.Scanner;

public class CustomerSearch {
    // Linear Search
    static boolean linearSearch(int[] arr, int key) {
        for (int id : arr) {
            if (id == key)
                return true;
        }
        return false;
    }

    // Binary Search (array must be sorted)
    static boolean binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return true;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] customerIDs = {102, 205, 150, 98, 300, 250, 120};

        System.out.print("Enter Customer ID to search: ");
        int key = sc.nextInt();

        // 🔹 Linear Search
        if (linearSearch(customerIDs, key))
            System.out.println("Linear Search: Customer ID " + key + " found.");
        else
            System.out.println("Linear Search: Customer ID " + key + " not found.");

        // 🔹 Binary Search (sort first)
        Arrays.sort(customerIDs);
        if (binarySearch(customerIDs, key))
            System.out.println("Binary Search: Customer ID " + key + " found.");
        else
            System.out.println("Binary Search: Customer ID " + key + " not found.");

        sc.close();
    }
}
