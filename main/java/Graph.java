package main.java;

import java.util.LinkedList;

/**
 * Created by joyfeng on 11/19/2016.
 */
public class Graph {
    private int numOfNode;
    private LinkedList<Integer> adj[];

    Graph(int n) {
        numOfNode = n;
        adj = new LinkedList[n];  // not new LinkedList<Integer>[n]
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList();
        }
    }

    // add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // dfs
    void dfs(int v, boolean[] visited) {
        visited[v] = true;
        LinkedList<Integer> edges = adj[v];

        for (int i = 0; i < edges.size(); i++) {
            int n = edges.get(i);
            if (!visited[n]) {
                dfs(n, visited);
            }
        }
    }
}
