package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Given n nodes labeled from 0 to n - 1 and a list of undirected edges
// (each edge is a pair of nodes), check if these edges form a valid tree.
// 如果是树的话，所有的节点必须是连接的，也就是说必须是连通图，而且不能有环，
// 所以我们的焦点就变成了验证是否是连通图和是否含有环
public class GoogleLC261GraphValidTree {
    // This problem can be converted to finding a cycle in a graph.
    // It can be solved by using DFS (Recursion) or BFS (Queue).
    public boolean validTree(int n, int[][] edges) {
        // init the graph
        // map, node to list of nodes linked to it
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        // BFS using queue
        // here we do not use visited to check if visited or not
        // instead, we use a Set, each time meet a node, check if it is in Set
        // if not, add to Set
        // it yes, return false
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        queue.offer(0);
        set.add(0);
        while(!queue.isEmpty()) {
            Integer top = queue.poll();
            for (int v : map.get(top)) {
                if (set.contains(v)) {
                    return false;
                }
                set.add(v);
                queue.offer(v);
                map.get(v).remove(top);    // !!!遍历邻接链表的时候，遍历完成后需要将节点删掉
            }
        }

        return set.size() == n;
    }

    // DFS
    public boolean validTreeUsingDFS(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0 ;i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        if (!helper(0, -1, map, visited)) {      // has cycle
            return false;
        }

        //  连通图?
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    boolean helper(int current, int parent, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[current]) {
            return false;
        }

        visited[current] = true;

        List<Integer> list = map.get(current);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != parent && !helper(list.get(i), current, map, visited)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GoogleLC261GraphValidTree g = new GoogleLC261GraphValidTree();
        int[][] edges = new int[5][];
        edges[0] = new int[]{0, 1};
        edges[1] = new int[]{1, 2};
        edges[2] = new int[]{2, 3};
        edges[3] = new int[]{1, 3};
        edges[4] = new int[]{1, 4};

        System.out.println(g.validTree(5, edges));
        System.out.println(g.validTreeUsingDFS(5, edges));

        edges = new int[4][];
        edges[0] = new int[]{0, 1};
        edges[1] = new int[]{0, 2};
        edges[2] = new int[]{0, 3};
        edges[3] = new int[]{1, 4};

        System.out.println(g.validTree(5, edges));
        System.out.println(g.validTreeUsingDFS(5, edges));
    }
}
