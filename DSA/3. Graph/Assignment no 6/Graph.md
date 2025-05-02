# Graph Traversal Program

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


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
