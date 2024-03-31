import java.util.Scanner;

class ExpressionsTree {
    static class Node {
        char data;
        Node left, right;

        Node(char item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    ExpressionsTree() {
        root = null;
    }

    void insert(String expression) {
        char[] charArray = expression.toCharArray();
        root = insertNode(charArray, root, 0);
    }

    Node insertNode(char[] expression, Node root, int i) {
        if (i < expression.length) {
            Node temp = new Node(expression[i]);
            root = temp;

            if (isOperator(expression[i])) {
                root.left = insertNode(expression, root.left, 2 * i + 1);
                root.right = insertNode(expression, root.right, 2 * i + 2);
            }
        }
        return root;
    }

    boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }

    Node delete(Node root, char key) {
        if (root == null)
            return root;

        if (root.left == null && root.right == null && root.data == key)
            return null;

        Node parent = null;
        Node current = root;
        while (current != null && current.data != key) {
            parent = current;
            if (current.data < key)
                current = current.right;
            else
                current = current.left;
        }

        if (current == null) // Key not found
            return root;

        if (current.left == null && current.right == null) {
            if (current != root) {
                if (parent.left == current)
                    parent.left = null;
                else
                    parent.right = null;
            } else
                root = null;
        } else if (current.left == null) {
            if (current != root) {
                if (parent.left == current)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            } else
                root = current.right;
        } else if (current.right == null) {
            if (current != root) {
                if (parent.left == current)
                    parent.left = current.left;
                else
                    parent.right = current.left;
            } else
                root = current.left;
        } else {
            Node successor = getSuccessor(current);
            if (current != root) {
                if (parent.left == current)
                    parent.left = successor;
                else
                    parent.right = successor;
            } else
                root = successor;

            successor.left = current.left;
        }
        return root;
    }

    Node getSuccessor(Node node) {
        Node current = node.right;
        while (current != null && current.left != null)
            current = current.left;
        return current;
    }

    void showPostOrder(Node root) {
        if (root == null)
            return;

        showPostOrder(root.left);
        showPostOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpressionsTree tree = new ExpressionsTree();

        int choice;
        char key;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert Expression");
            System.out.println("2. Delete a Node");
            System.out.println("3. Show Postorder Traversal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the expression: ");
                    String expression = scanner.next();
                    tree.insert(expression);
                    break;
                case 2:
                    if (tree.root != null) {
                        System.out.print("Enter the node to delete: ");
                        key = scanner.next().charAt(0);
                        tree.root = tree.delete(tree.root, key);
                        System.out.println("Expression tree after deletion:");
                        tree.showPostOrder(tree.root);
                    } else {
                        System.out.println("Expression tree is empty!");
                    }
                    break;
                case 3:
                    System.out.println("Postorder Traversal:");
                    tree.showPostOrder(tree.root);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 4);
    }
}