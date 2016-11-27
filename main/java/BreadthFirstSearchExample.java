package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by joyfeng on 11/17/2016.
 */
public class BreadthFirstSearchExample {
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

    // unlike trees, graphs may contain cycles, so we may come to the same node again.
    // To avoid processing a node more than once, we use a boolean visited array
    // prints BFS traversal from a given source s
    public void bfs(int[][] adj_matrix, GraphNode node) {
        // Create a queue for BFS
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        // Mark the current node as visited and enqueue it
        node.visited = true;
        queue.offer(node);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            node = queue.poll();
            System.out.println(node.val + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            List<GraphNode> neighbors = findNeighbors(adj_matrix, node);
            for (GraphNode n : neighbors) {
                if (!n.visited) {
                    n.visited = true;
                    queue.offer(n);
                }
            }

        }
    }

    public static void main(String[] args) {
        BreadthFirstSearchExample g = new BreadthFirstSearchExample();
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);
        GraphNode node7 = new GraphNode(7);

        g.nodes.add(node1);
        g.nodes.add(node2);
        g.nodes.add(node3);
        g.nodes.add(node4);
        g.nodes.add(node5);
        g.nodes.add(node6);
        g.nodes.add(node7);

        int[][] adjs_matrix = {
                {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0}
        };

        g.bfs(adjs_matrix, node1);
    }
}
