# 1. Graph Traversal Program

- [`Graph.java`:](https://github.com/ShrihariKasar/Java-Programs/blob/main/DSA/3.%20Graph/Assignment%20no%206/Graph.java)This Java program allows you to perform Breadth-First Search (BFS) and Depth-First Search (DFS) on a graph represented using an adjacency matrix.

## Table of Contents

- [Overview](#overview)
- [How to Use](#how-to-use)
- [Sample Input](#sample-input)
- [Sample Output](#sample-output)
- [License](#license)

## Overview

This program provides functionalities to perform BFS and DFS on a graph. It uses an adjacency matrix to represent the graph.

## How to Use

1. Clone this repository to your local machine.
2. Open a terminal or command prompt and navigate to the project directory.
3. Compile the Java source file using the command:

    ```bash
    javac Main.java
    ```

4. Run the program using the command:

    ```bash
    java Main
    ```

5. Follow the on-screen instructions to choose between BFS and DFS, input the number of vertices, edges, and the starting vertex.

# Sample Input

## When running the program, you will be prompted to enter the number of vertices, edges, and the edges of the graph. Here's a sample input:

- Menu:
1. Perform Breadth First Search(BFS)
2. Perform Depth First Search(DFS)
3. Exit
- Enter choice: 1
- Enter vertex count: 4
- Enter edges (source destination):
- Enter edge 1 to 1: 0
- Enter edge 1 to 2: 1
- Enter edge 1 to 3: 0
- Enter edge 1 to 4: 1
- Enter edge 2 to 1: 1
- Enter edge 2 to 2: 0
- Enter edge 2 to 3: 1
- Enter edge 2 to 4: 0
- Enter edge 3 to 1: 0
- Enter edge 3 to 2: 1
- Enter edge 3 to 3: 0
- Enter edge 3 to 4: 1
- Enter edge 4 to 1: 1
- Enter edge 4 to 2: 0
- Enter edge 4 to 3: 1
- Enter edge 4 to 4: 0
- Adjacency Matrix:
- 0 1 0 1
- 1 0 1 0
- 0 1 0 1
- 1 0 1 0
- Enter starting vertex: 1

# Sample Output

## Based on the input provided above, the program will output:

- BFS: 1 2 4 3

# 2. Prim's Algorithm for Minimum Spanning Tree (MST)

- [`PrimMST.java`:](https://github.com/ShrihariKasar/Java-Programs/blob/main/DSA/3.%20Graph/Assignment%20no%207/PrimMST.java)This Java program implements Prim's algorithm to find the Minimum Spanning Tree (MST) of a weighted undirected graph.

## Overview

Prim's algorithm is a greedy algorithm that finds a minimum spanning tree for a weighted undirected graph. The algorithm starts with an arbitrary vertex and grows the spanning tree by adding the cheapest edge that connects the tree to a vertex not yet in the tree until all vertices are included.

## How to Use

1. Clone this repository to your local machine.
2. Open a terminal or command prompt and navigate to the project directory.
3. Compile the Java source file using the command:

    ```bash
    javac PrimMST.java
    ```

4. Run the program using the command:

    ```bash
    java PrimMST
    ```

5. Follow the on-screen instructions to input the number of edges, vertices, and the details of each edge (source, destination, and weight).

# Sample Input

## When running the program, you will be prompted to input the number of edges, vertices, and the details of each edge. Here's a sample input:

- Input Graph:
- ENTER NO OF EDGES: 5
- ENTER NO OF VERTICES: 4
- ENTER 1ST VERTEX: A
- ENTER 2ND VERTEX: B
- ENTER WEIGHT: 10
- ENTER 1ST VERTEX: B
- ENTER 2ND VERTEX: C
- ENTER WEIGHT: 20
- ENTER 1ST VERTEX: C
- ENTER 2ND VERTEX: D
- ENTER WEIGHT: 30
- ENTER 1ST VERTEX: D
- ENTER 2ND VERTEX: A
- ENTER WEIGHT: 5
- ENTER 1ST VERTEX: B
- ENTER 2ND VERTEX: D
- ENTER WEIGHT: 15


# Sample Output

## Based on the input provided above, the program will output:

- Input Graph:
- A B 10
- B C 20
- C D 30
- D A 5
- B D 15

## Resulting Minimum Spanning Tree (MST):
- A D 5
- B A 10
- D C 30

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
