package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Depth-first search (DFS) is an algorithm (or technique) for traversing a graph.

public class DepthFirstSearchExample {
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

    // recursive dfs
    //    In DFS,  You start with an un-visited node and start picking an adjacent node,
    //    until you have no choice, then you backtrack until you have another choice to pick a node,
    //    if not, you select another un-visited node.
    public void dfs(int[][] adj_matrix, GraphNode node) {
        System.out.println(node.val + " ");
        List<GraphNode> neighbors = findNeighbors(adj_matrix, node);

        for (GraphNode n : neighbors) {
            if (n != null && !n.visited) {
                dfs(adj_matrix, n);
                n.visited = true;
            }
        }
    }

    // Iterative DFS using stack
    public void dfsUsingStack(int[][] adjacency_matrix, GraphNode node) {
        Stack<GraphNode> stack = new Stack<GraphNode>();
        stack.push(node);
        node.visited = true;

        while(!stack.isEmpty()) {
            GraphNode n = stack.pop();
            System.out.print(n.val + "\t");

            List<GraphNode> neighbors = findNeighbors(adjacency_matrix, n);
            for (GraphNode neighbor : neighbors) {
                if (neighbor != null && !neighbor.visited) {
                    stack.push(neighbor);
                    neighbor.visited = true;
                }
            }
        }
    }

    void clearVisitedFlags() {
        for (GraphNode node : nodes) {
            node.visited = false;
        }
    }

    public static void main(String[] args) {
        DepthFirstSearchExample g = new DepthFirstSearchExample();
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

        g.dfs(adjs_matrix, node1);
        g.clearVisitedFlags();
        g.dfsUsingStack(adjs_matrix, node1);
    }
}
