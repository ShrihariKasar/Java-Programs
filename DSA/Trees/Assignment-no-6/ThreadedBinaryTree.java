import java.util.Scanner;

class Threaded {
    int data;
    Threaded left, right;
    boolean isThreaded;

    Threaded(int value) {
        data = value;
        left = right = null;
        isThreaded = false;
    }
}

public class ThreadedBinaryTree {
    Threaded root;

    ThreadedBinaryTree() {
        root = null;
    }

    // Function to insert nodes using array
    void insertFromArray(int[] arr) {
        root = insertFromArrayUtil(arr, root, 0, arr.length);
    }

    Threaded insertFromArrayUtil(int[] arr, Threaded root, int i, int n) {
        if (i < n) {
            Threaded temp = new Threaded(arr[i]);
            root = temp;

            // insert left child
            root.left = insertFromArrayUtil(arr, root.left, 2 * i + 1, n);

            // insert right child
            root.right = insertFromArrayUtil(arr, root.right, 2 * i + 2, n);
        }
        return root;
    }

    // Function to delete a node
    Threaded deleteNode(Threaded root, int key) {
        if (root == null)
            return root;

        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) {
                Threaded temp = root.right;
                return temp;
            } else if (root.right == null) {
                Threaded temp = root.left;
                return temp;
            }

            Threaded temp = minValueNode(root.right);
            root.data = temp.data;
            root.right = deleteNode(root.right, temp.data);
        }
        return root;
    }

    Threaded minValueNode(Threaded node) {
        Threaded current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Function to display inorder traversal
    void inorder(Threaded node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // Function to display preorder traversal
    void preorder(Threaded node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Function to find the leftmost node in a subtree
    Threaded leftMost(Threaded node) {
        if (node == null)
            return null;
        while (node.left != null)
            node = node.left;
        return node;
    }

    public static void main(String[] args) {
        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert nodes using array");
            System.out.println("2. Delete a node");
            System.out.println("3. Show inorder traversal");
            System.out.println("4. Show preorder traversal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the size of the array:");
                    int size = scanner.nextInt();
                    int[] arr = new int[size];
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < size; i++) {
                        arr[i] = scanner.nextInt();
                    }
                    tree.insertFromArray(arr);
                    break;
                case 2:
                    System.out.println("Enter the key to delete:");
                    int key = scanner.nextInt();
                    tree.root = tree.deleteNode(tree.root, key);
                    break;
                case 3:
                    System.out.println("Inorder traversal:");
                    tree.inorder(tree.root);
                    break;
                case 4:
                    System.out.println("Preorder traversal:");
                    tree.preorder(tree.root);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        scanner.close();
    }
}
