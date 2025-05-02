import java.util.*;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // DFS traversal of the vertices reachable from v
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    // BFS traversal of the vertices reachable from s
    void BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If an adjacent vertex has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of landmarks: ");
        int V = scanner.nextInt();
        Graph graph = new Graph(V);

        System.out.println("Enter the number of edges: ");
        int E = scanner.nextInt();

        System.out.println("Enter edges (vertex1 vertex2): ");
        for (int i = 0; i < E; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            graph.addEdge(v1, v2);
        }

        System.out.println("Enter the starting vertex for DFS and BFS: ");
        int start = scanner.nextInt();

        System.out.println("DFS traversal starting from " + start + ": ");
        graph.DFS(start);
        System.out.println();

        System.out.println("BFS traversal starting from " + start + ": ");
        graph.BFS(start);

        scanner.close();
    }
}