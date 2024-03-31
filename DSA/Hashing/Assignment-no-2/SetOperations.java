import java.util.*;

public class SetOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add element to set A");
            System.out.println("2. Add element to set B");
            System.out.println("3. Delete element from set A");
            System.out.println("4. Delete element from set B");
            System.out.println("5. Display elements from set A");
            System.out.println("6. Display elements from set B");
            System.out.println("7. Search element in set A");
            System.out.println("8. Search element in set B");
            System.out.println("9. Size of set A");
            System.out.println("10. Size of set B");
            System.out.println("11. Union of sets");
            System.out.println("12. Intersection of sets");
            System.out.println("13. Difference of sets");
            System.out.println("14. Check if set A is a subset of set B");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addToSet(setA, "A");
                    break;
                case 2:
                    addToSet(setB, "B");
                    break;
                case 3:
                    deleteFromSet(setA, "A");
                    break;
                case 4:
                    deleteFromSet(setB, "B");
                    break;
                case 5:
                    displaySet(setA, "A");
                    break;
                case 6:
                    displaySet(setB, "B");
                    break;
                case 7:
                    searchElement(setA, "A");
                    break;
                case 8:
                    searchElement(setB, "B");
                    break;
                case 9:
                    System.out.println("Size of set A: " + setA.size());
                    break;
                case 10:
                    System.out.println("Size of set B: " + setB.size());
                    break;
                case 11:
                    performUnion(setA, setB);
                    break;
                case 12:
                    performIntersection(setA, setB);
                    break;
                case 13:
                    performDifference(setA, setB);
                    break;
                case 14:
                    checkSubset(setA, setB);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addToSet(Set<Integer> set, String setName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of set " + setName + ": ");
        int size = scanner.nextInt();

        System.out.print("Enter the elements for set " + setName + " separated by space: ");
        for (int i = 0; i < size; i++) {
            set.add(scanner.nextInt());
        }
        System.out.println("Elements added to set " + setName);
    }

    private static void deleteFromSet(Set<Integer> set, String setName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the element to delete from set " + setName + ": ");
        int element = scanner.nextInt();

        if (set.remove(element)) {
            System.out.println(element + " removed from set " + setName);
        } else {
            System.out.println(element + " not found in set " + setName);
        }
    }

    private static void displaySet(Set<Integer> set, String setName) {
        System.out.println("Elements in set " + setName + ": " + set);
    }

    private static void searchElement(Set<Integer> set, String setName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the element to search in set " + setName + ": ");
        int element = scanner.nextInt();

        if (set.contains(element)) {
            System.out.println(element + " found in set " + setName);
        } else {
            System.out.println(element + " not found in set " + setName);
        }
    }

    private static void performUnion(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> unionSet = new HashSet<>(setA);
        unionSet.addAll(setB);
        System.out.println("Union of sets A and B: " + unionSet);
    }

    private static void performIntersection(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> intersectionSet = new HashSet<>(setA);
        intersectionSet.retainAll(setB);
        System.out.println("Intersection of sets A and B: " + intersectionSet);
    }

    private static void performDifference(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> differenceSet = new HashSet<>(setA);
        differenceSet.removeAll(setB);
        System.out.println("Difference of set A - set B: " + differenceSet);
    }

    private static void checkSubset(Set<Integer> setA, Set<Integer> setB) {
        if (setB.containsAll(setA)) {
            System.out.println("Set A is a subset of set B");
        } else {
            System.out.println("Set A is not a subset of set B");
        }
    }
}