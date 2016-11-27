package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSorting {
    List<GraphNode> nodes = new ArrayList<GraphNode>();

    // find neighbors of node using adjacency matrix
    // if adjacency_matrix[i][j]==1, nodes at index i and j are connected
    public List<GraphNode> findNeighbors(int adj_matrix[][], GraphNode x) {
        List<GraphNode> neighbors = new ArrayList<GraphNode>();
        int nodeIndex = -1;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).equals(x)) {   // first we have to find GraphNode x
                nodeIndex = i;
                break;
            }
        }

        if (nodeIndex != -1) {   // we already find node with val x
            for (int j = 0; j < adj_matrix[nodeIndex].length; j++) {
                if (adj_matrix[nodeIndex][j] == 1) {
                    neighbors.add(nodes.get(j));
                }
            }
        }

        return neighbors;
    }

    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    void topologicalSort(int adj_matrix[][]) {
        Stack<GraphNode> stack = new Stack<GraphNode>();
        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (GraphNode n : nodes) {
            if (n != null && !n.visited) {
                topologicalSortUtil(adj_matrix, n, stack);
            }
        }

        // Print contents of stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + " ");
        }
    }

    // A recursive function used by topologicalSort
    /**
     * In topological sorting, we use a temporary stack. We don’t print the vertex immediately, we first recursively call
     * topological sorting for all its adjacent vertices, then push it to a stack. Finally, print contents of stack.
     * Note that a vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on) are already in stack.
     */
    void topologicalSortUtil(int adj_matrix[][], GraphNode n, Stack stack) {
        n.visited = true;
        List<GraphNode> neighbors = findNeighbors(adj_matrix, n);

        for (GraphNode neighbor : neighbors) {
            if (!neighbor.visited) {
                topologicalSortUtil(adj_matrix, neighbor, stack);
            }
        }

        stack.push(n);
    }

    public static void main(String[] args) {
        TopologicalSorting g = new TopologicalSorting();
        GraphNode node0 = new GraphNode(0);
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);

        g.nodes.add(node0);
        g.nodes.add(node1);
        g.nodes.add(node2);
        g.nodes.add(node3);
        g.nodes.add(node4);
        g.nodes.add(node5);

        // (5, 2); (5, 0); (4, 0); (4, 1); (2, 3); (3, 1);
        int[][] adjs_matrix = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0}
        };

        g.topologicalSort(adjs_matrix);
    }
}
