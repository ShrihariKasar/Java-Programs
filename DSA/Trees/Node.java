import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    // Function to insert a node into the BST
    private Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insert(root.left, data);
        else if (data > root.data)
            root.right = insert(root.right, data);

        return root;
    }

    // Function to construct the binary search tree by level
    public void constructTree() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the level of the tree: ");
        int levels = scanner.nextInt();

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < levels; i++) {
            System.out.println("Enter values for level " + (i + 1) + ": ");
            for (int j = 0; j < Math.pow(2, i); j++) {
                System.out.print("Node " + (j + 1) + ": ");
                int value = scanner.nextInt();
                root = insert(root, value);
            }
        }
    }

    // Function to insert new nodes using an array
    public void insertNodesFromArray(int[] nodes) {
        for (int node : nodes) {
            root = insert(root, node);
        }
    }

    // Function to find the number of nodes on the longest path from root
    public int findLongestPathNodes() {
        return findLongestPathNodes(root);
    }

    private int findLongestPathNodes(Node node) {
        if (node == null)
            return 0;

        int leftDepth = findLongestPathNodes(node.left);
        int rightDepth = findLongestPathNodes(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    // Function to find the minimum data value in the tree
    public int findMinValue() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    // Function to swap left and right pointers of each node
    public void swapLeftAndRight() {
        root = swapLeftAndRight(root);
    }

    private Node swapLeftAndRight(Node node) {
        if (node == null)
            return null;

        // Swap left and right pointers
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recursively swap left and right pointers of the subtrees
        swapLeftAndRight(node.left);
        swapLeftAndRight(node.right);

        return node;
    }

    // Function to search for a value in the tree
    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(Node root, int value) {
        if (root == null)
            return false;

        if (root.data == value)
            return true;

        if (value < root.data)
            return search(root.left, value);
        else
            return search(root.right, value);
    }

    // Function to perform inorder traversal
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Function to perform preorder traversal
    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Function to perform postorder traversal
    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}

class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Create a tree by level");
            System.out.println("2. Insert new nodes using array");
            System.out.println("3. Find number of nodes on the longest path from root");
            System.out.println("4. Find minimum data value in the tree");
            System.out.println("5. Swap left and right pointers of each node");
            System.out.println("6. Search for a value");
            System.out.println("7. Inorder traversal");
            System.out.println("8. Preorder traversal");
            System.out.println("9. Postorder traversal");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tree.constructTree();
                    break;
                case 2:
                    System.out.print("Enter the size of the array: ");
                    int size = scanner.nextInt();
                    int[] nodes = new int[size];
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < size; i++) {
                        nodes[i] = scanner.nextInt();
                    }
                    tree.insertNodesFromArray(nodes);
                    break;
                case 3:
                    int longestPathNodes = tree.findLongestPathNodes();
                    System.out.println("Number of nodes on the longest path from root: " + longestPathNodes);
                    break;
                case 4:
                    int minValue = tree.findMinValue();
                    System.out.println("Minimum data value in the tree: " + minValue);
                    break;
                case 5:
                    tree.swapLeftAndRight();
                    System.out.println("Left and right pointers swapped for each node.");
                    break;
                case 6:
                    System.out.print("Enter the value to search: ");
                    int searchValue = scanner.nextInt();
                    if (tree.search(searchValue)) {
                        System.out.println("Value found in the tree.");
                    } else {
                        System.out.println("Value not found in the tree.");
                    }
                    break;
                case 7:
                    System.out.print("Inorder traversal: ");
                    tree.inorder();
                    break;
                case 8:
                    System.out.print("Preorder traversal: ");
                    tree.preorder();
                    break;
                case 9:
                    System.out.print("Postorder traversal: ");
                    tree.postorder();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
    }
}