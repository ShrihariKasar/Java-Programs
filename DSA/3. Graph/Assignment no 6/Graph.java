import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
    int[][] adjMatrix;
    int vCount;
    boolean[] visited;

    Graph(int vCount) {
        this.vCount = vCount;
        adjMatrix = new int[vCount][vCount];
        visited = new boolean[vCount];
    }

    void readEdges(Scanner scanner) {
        System.out.println("Enter edges (source destination): ");
        for (int i = 0; i < vCount; i++) {
            for (int j = 0; j < vCount; j++) {
                System.out.print("Enter edge " + (i + 1) + " to " + (j + 1) + ": ");
                adjMatrix[i][j] = scanner.nextInt();
            }
        }
    }

    void displayAdjacency() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vCount; i++) {
            for (int j = 0; j < vCount; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (int i = 0; i < vCount; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    void DFS(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        System.out.print("DFS: ");
        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(current + " ");
            for (int i = 0; i < vCount; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Perform Breadth First Search(BFS)");
            System.out.println("2. Perform Depth First Search(DFS)");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performSearch(scanner, choice);
                    break;
                case 2:
                    performSearch(scanner, choice);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void performSearch(Scanner scanner, int choice) {
        System.out.print("Enter vertex count: ");
        int vCount = scanner.nextInt();
        Graph graph = new Graph(vCount);
        graph.readEdges(scanner);
        graph.displayAdjacency();

        System.out.print("Enter starting vertex: ");
        int startVertex = scanner.nextInt();

        switch (choice) {
            case 1:
                graph.BFS(startVertex - 1); // Adjust for 0-based indexing
                break;
            case 2:
                graph.DFS(startVertex - 1); // Adjust for 0-based indexing
                break;
        }
    }
}
