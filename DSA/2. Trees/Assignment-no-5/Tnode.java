import java.util.Scanner;

class Tnode {
    int data;
    Tnode left;
    Tnode right;
    int lbit, rbit;

    public Tnode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.lbit = 0;
        this.rbit = 0;
    }
}

class TBT {
    Tnode root, head;

    public TBT() {
        root = null;
        head = null;
    }

    void createTBT(int size, int rootData) {
        root = new Tnode(rootData);
        head = new Tnode(-9999);
        head.left = root;
        head.right = head;
        head.lbit = 1;
        head.rbit = 0;
        root.left = head;
        root.right = head;

        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < size; i++) {
            System.out.println("Enter new node : ");
            int data = scanner.nextInt();
            Tnode temp = new Tnode(data);
            Tnode current = root;
            while (true) {
                if (data < current.data) {
                    if (current.lbit == 0) {
                        temp.left = current.left;
                        temp.right = current;
                        current.left = temp;
                        current.lbit = 1;
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.rbit == 0) {
                        temp.left = current;
                        temp.right = current.right;
                        current.right = temp;
                        current.rbit = 1;
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    void preorder(Tnode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            if (node.lbit == 1) {
                preorder(node.left);
            } else {
                System.out.print("NULL ");
            }
            if (node.rbit == 1) {
                preorder(node.right);
            } else {
                System.out.print("NULL ");
            }
        }
    }

    void inorder(Tnode node) {
        if (node != null) {
            if (node.lbit == 1) {
                inorder(node.left);
            } else {
                System.out.print("NULL ");
            }
            System.out.print(node.data + " ");
            if (node.rbit == 1) {
                inorder(node.right);
            } else {
                System.out.print("NULL ");
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of nodes (including root) : ");
        int size = scanner.nextInt();

        System.out.print("Enter root node : ");
        int rootData = scanner.nextInt();

        TBT T = new TBT();
        T.createTBT(size, rootData);

        int ch;
        do {
            System.out.println("\n1. Inorder Display of Threaded Binary Tree ");
            System.out.println("2. Preorder Display of Threaded Binary Tree ");
            System.out.println("3. Exit ");
            System.out.print("Enter your choice : ");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Inorder Traversal: ");
                    T.inorder(T.root); // Pass root for traversal
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.print("Preorder Traversal: ");
                    T.preorder(T.root); // Pass root for traversal
                    System.out.println("\n");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Enter correct choice");
                    break;
            }
        } while (ch != 3);
    }
}