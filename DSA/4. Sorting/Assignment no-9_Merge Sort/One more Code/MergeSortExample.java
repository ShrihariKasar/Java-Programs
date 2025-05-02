import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSortExample {

    public static void main(String[] args) {
        // Scanner for reading input from the user
        Scanner scanner = new Scanner(System.in);

        // Read and sort the left half of the list
        System.out.println("Enter integers for the Left half (space-separated, then press Enter):");
        List<Integer> leftHalf = readIntegers(scanner);
        mergeSort(leftHalf, 0, leftHalf.size() - 1);

        // Read and sort the right half of the list
        System.out.println("Enter integers for the Right half (space-separated, then press Enter):");
        List<Integer> rightHalf = readIntegers(scanner);
        mergeSort(rightHalf, 0, rightHalf.size() - 1);

        // Merge the sorted left and right halves
        List<Integer> mergedList = mergeLists(leftHalf, rightHalf);

        // Output the merged and sorted list
        System.out.println("Sorted list Using Merge Sort:");
        for (Integer value : mergedList) {
            System.out.print(value + " ");
        }
        System.out.println(); // Newline at the end
    }

    // Function to read integers from the scanner and return a list
    private static List<Integer> readIntegers(Scanner scanner) {
        List<Integer> integers = new ArrayList<>();
        String inputLine = scanner.nextLine();
        String[] inputStrings = inputLine.split("\\s+");

        for (String s : inputStrings) {
            try {
                integers.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integers only.");
                return readIntegers(scanner);
            }
        }

        return integers;
    }

    // Merge sort function
    private static void mergeSort(List<Integer> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort the left and right halves
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);

            // Merge the two sorted halves
            merge(list, left, mid, right);
        }
    }

    // Function to merge two sorted halves
    private static void merge(List<Integer> list, int left, int mid, int right) {
        // Create temporary arrays for the two halves
        List<Integer> leftArray = new ArrayList<>(list.subList(left, mid + 1));
        List<Integer> rightArray = new ArrayList<>(list.subList(mid + 1, right + 1));

        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = left;

        // Merge the left and right halves in sorted order
        while (leftIndex < leftArray.size() && rightIndex < rightArray.size()) {
            if (leftArray.get(leftIndex) <= rightArray.get(rightIndex)) {
                list.set(mergeIndex, leftArray.get(leftIndex));
                leftIndex++;
            } else {
                list.set(mergeIndex, rightArray.get(rightIndex));
                rightIndex++;
            }
            mergeIndex++;
        }

        // Copy any remaining elements from the left half
        while (leftIndex < leftArray.size()) {
            list.set(mergeIndex, leftArray.get(leftIndex));
            leftIndex++;
            mergeIndex++;
        }

        // Copy any remaining elements from the right half
        while (rightIndex < rightArray.size()) {
            list.set(mergeIndex, rightArray.get(rightIndex));
            rightIndex++;
            mergeIndex++;
        }
    }

    // Function to merge two sorted lists into one sorted list
    private static List<Integer> mergeLists(List<Integer> left, List<Integer> right) {
        List<Integer> mergedList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        // Merge the two lists
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                mergedList.add(left.get(leftIndex));
                leftIndex++;
            } else {
                mergedList.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        // Add remaining elements from the left list
        while (leftIndex < left.size()) {
            mergedList.add(left.get(leftIndex));
            leftIndex++;
        }

        // Add remaining elements from the right list
        while (rightIndex < right.size()) {
            mergedList.add(right.get(rightIndex));
            rightIndex++;
        }

        return mergedList;
    }
}
