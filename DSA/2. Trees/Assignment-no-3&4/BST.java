import java.util.Scanner;

class BST {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    public BST() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    void insertFromArray(int[] arr) {
        for (int key : arr) {
            insert(key);
        }
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    int smallest() {
        return smallestRec(root);
    }

    int smallestRec(Node root) {
        if (root.left == null)
            return root.data;
        return smallestRec(root.left);
    }

    int largest() {
        return largestRec(root);
    }

    int largestRec(Node root) {
        if (root.right == null)
            return root.data;
        return largestRec(root.right);
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (key < root.data)
            return searchRec(root.left, key);
        else
            return searchRec(root.right, key);
    }

    BST mirror() {
        BST mirrorTree = new BST();
        mirrorTree.root = mirrorRec(root);
        return mirrorTree;
    }

    Node mirrorRec(Node root) {
        if (root == null)
            return null;

        Node mirrorNode = new Node(root.data);
        mirrorNode.left = mirrorRec(root.right);
        mirrorNode.right = mirrorRec(root.left);

        return mirrorNode;
    }

    int height() {
        return heightRec(root);
    }

    int heightRec(Node root) {
        if (root == null)
            return 0;
        else {
            int leftHeight = heightRec(root.left);
            int rightHeight = heightRec(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST bst = new BST();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Insert from Array");
            System.out.println("3. Inorder Display");
            System.out.println("4. Find Smallest Number");
            System.out.println("5. Find Largest Number");
            System.out.println("6. Search Number");
            System.out.println("7. Mirror Image of BST");
            System.out.println("8. Height of BST");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertValue = scanner.nextInt();
                    bst.insert(insertValue);
                    break;
                case 2:
                    System.out.print("Enter size of array: ");
                    int size = scanner.nextInt();
                    int[] arr = new int[size];
                    System.out.println("Enter elements of array:");
                    for (int i = 0; i < size; i++) {
                        arr[i] = scanner.nextInt();
                    }
                    bst.insertFromArray(arr);
                    break;
                case 3:
                    System.out.print("Inorder Display: ");
                    bst.inorder();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Smallest Number: " + bst.smallest());
                    break;
                case 5:
                    System.out.println("Largest Number: " + bst.largest());
                    break;
                case 6:
                    System.out.print("Enter number to search: ");
                    int searchValue = scanner.nextInt();
                    if (bst.search(searchValue))
                        System.out.println("Number found in BST.");
                    else
                        System.out.println("Number not found in BST.");
                    break;
                case 7:
                    System.out.println("Mirror Image of BST:");
                    BST mirrorBST = bst.mirror();
                    mirrorBST.inorder();
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Height of BST: " + bst.height());
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
        }

        scanner.close();
    }
}
