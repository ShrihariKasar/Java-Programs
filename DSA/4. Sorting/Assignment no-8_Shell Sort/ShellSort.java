import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {

    // Shell sort function
    public static void shellSort(int[] array) {
        int n = array.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size
            for (int i = gap; i < n; i += 1) {
                // Add array[i] to the elements that have been gap sorted
                // Save array[i] in temp and make a hole at position i
                int temp = array[i];

                // Shift earlier gap-sorted elements up until the correct
                // location for array[i] is found
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                // Put temp (the original array[i]) in its correct location
                array[j] = temp;
            }
        }
    }

    // Main method to take input from user and test the implementation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        // Prompt the user to enter the elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Close the scanner
        scanner.close();

        System.out.println("Array before sorting: " + Arrays.toString(array));

        // Call the shell sort function
        shellSort(array);

        System.out.println("Array after Applying Shell Sort: " + Arrays.toString(array));
    }
}
