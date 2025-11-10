import java.util.Scanner;

public class EmployeeSalaries {

    // Selection Sort
    static void selectionSort(float[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            // Swap
            float temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Bubble Sort
    static void bubbleSort(float[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    float temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Display top 5 highest salaries
    static void displayTopFive(float[] arr) {
        System.out.println("\nTop 5 Highest Salaries:");
        int count = Math.min(5, arr.length);
        for (int i = arr.length - 1; i >= arr.length - count; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        float[] salaries = new float[n];

        System.out.println("Enter employee salaries:");
        for (int i = 0; i < n; i++) {
            salaries[i] = sc.nextFloat();
        }

        // Copy array for both sorting methods
        float[] selectionSorted = salaries.clone();
        float[] bubbleSorted = salaries.clone();

        // Selection Sort
        selectionSort(selectionSorted);
        System.out.println("\nSalaries after Selection Sort:");
        for (float s : selectionSorted)
            System.out.print(s + " ");
        displayTopFive(selectionSorted);

        // Bubble Sort
        bubbleSort(bubbleSorted);
        System.out.println("\nSalaries after Bubble Sort:");
        for (float s : bubbleSorted)
            System.out.print(s + " ");
        displayTopFive(bubbleSorted);

        sc.close();
    }
}
