import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int value) {
        this.data = value;
        this.left = this.right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Function to insert a new node
    public void insertNode(int value) {
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Function to find the number of nodes in the longest path from root
    public int findLongestPathLength() {
        return findLongestPathLength(root);
    }

    private int findLongestPathLength(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findLongestPathLength(root.left);
        int rightHeight = findLongestPathLength(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Function to find the minimum data value in the tree
    public int findMinimumValue() {
        return findMinimumValue(root);
    }

    private int findMinimumValue(TreeNode root) {
        if (root.left == null) {
            return root.data;
        }

        return findMinimumValue(root.left);
    }

    // Function to swap left and right pointers of each node
    public void swapLeftAndRightPointers() {
        root = swapLeftAndRight(root);
    }

    private TreeNode swapLeftAndRight(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = swapLeftAndRight(root.right);
        root.right = swapLeftAndRight(temp);

        return root;
    }

    // Function to search for a value in the tree
    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (root.data == value) {
            return true;
        } else if (value < root.data) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    // Functions to perform tree traversals
    public void inorderTraversal() {
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    public void preorderTraversal() {
        preorderTraversal(root);
        System.out.println();
    }

    private void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public void postorderTraversal() {
        postorderTraversal(root);
        System.out.println();
    }

    private void postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        int choice;
        do {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Insert new node");
            System.out.println("2. Find number of nodes in the longest path from root");
            System.out.println("3. Find minimum data value in the tree");
            System.out.println("4. Swap left and right pointers of each node");
            System.out.println("5. Search a value");
            System.out.println("6. Inorder traversal");
            System.out.println("7. Preorder traversal");
            System.out.println("8. Postorder traversal");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert: ");
                    int value = scanner.nextInt();
                    bst.insertNode(value);
                    System.out.println("Node inserted successfully!");
                    break;

                case 2:
                    int longestPathLength = bst.findLongestPathLength();
                    System.out.println("Number of nodes in the longest path from root: " + longestPathLength);
                    break;

                case 3:
                    int minValue = bst.findMinimumValue();
                    System.out.println("Minimum data value in the tree: " + minValue);
                    break;

                case 4:
                    bst.swapLeftAndRightPointers();
                    System.out.println("Left and right pointers swapped successfully!");
                    break;

                case 5:
                    System.out.print("Enter the value to search: ");
                    int searchValue = scanner.nextInt();
                    boolean isFound = bst.search(searchValue);
                    System.out.println("Value " + searchValue + " " + (isFound ? "found" : "not found") + " in the tree.");
                    break;

                case 6:
                    System.out.println("Inorder Traversal:");
                    bst.inorderTraversal();
                    break;

                case 7:
                    System.out.println("Preorder Traversal:");
                    bst.preorderTraversal();
                    break;

                case 8:
                    System.out.println("Postorder Traversal:");
                    bst.postorderTraversal();
                    break;

                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);

        scanner.close();
    }
}