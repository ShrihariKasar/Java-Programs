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

    void insertPrefixExpression(String prefixExpression) {
        char[] tokens = prefixExpression.toCharArray();
        root = constructExpressionTree(tokens, new int[]{0});
    }

    Node constructExpressionTree(char[] tokens, int[] index) {
        if (index[0] >= tokens.length)
            return null;

        char token = tokens[index[0]];
        index[0]++;

        Node node = new Node(token);

        if (isOperator(token)) {
            node.left = constructExpressionTree(tokens, index);
            node.right = constructExpressionTree(tokens, index);
        }

        return node;
    }

    boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    void deleteTree(Node root) {
        if (root == null)
            return;

        deleteTree(root.left);
        deleteTree(root.right);

        root = null;
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
            System.out.println("1. Insert prefix Expression");
            System.out.println("2. Delete the Tree");
            System.out.println("3. Show Postorder Traversal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the prefix expression: ");
                    String prefixExpression = scanner.next();
                    tree.insertPrefixExpression(prefixExpression);
                    break;
                case 2:
                    tree.deleteTree(tree.root);
                    tree.root = null; // Set root to null after deleting the tree
                    System.out.println("Expression tree deleted.");
                    break;
                case 3:
                    if (tree.root == null) {
                        System.out.println("Expression tree is empty!");
                    } else {
                        System.out.println("Postorder Traversal:");
                        tree.showPostOrder(tree.root);
                    }
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
