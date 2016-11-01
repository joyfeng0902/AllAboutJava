package main.java;

// graph may contain cycles
// To avoid processing a node more than once, we use a boolean visited
public class GraphNode {
    int val;
    boolean visited;

    GraphNode(int val) {
        this.val = val;
        this.visited = false;
    }
}
