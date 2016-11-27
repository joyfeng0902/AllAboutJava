package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GoogleLC269AlienDictionary {
    //    The key to this problem is:
    //    A topological ordering is possible if and only if the graph has no directed cycles
    // 1. buildGraph: build the graph as a list of adjacency lists
    // 2. toposort and acyclic: traver the graph in DFS manner to check for cycle and generate the topological sort
    // Directed Graph
    // if it has cycle, return ""
    public String alienOrder(String[] words) {
        if (words == null || words.length  == 0) {
            return "";
        }
        // build the graph
        StringBuilder sb = new StringBuilder();
        // 因为字典里有重复的边，所有要先判断，已经添加过的边不要重复添加 - use a Set so that each element is unique
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> inDegree = new HashMap<Character, Integer>();  // in degree

        // Initially all in-degree is 0
        for (String word : words) {
            for (Character c : word.toCharArray()) {        // !! not word, but word.toCharArray()
                inDegree.put(c, 0);
            }
        }

        for (int i = 0; i < words.length-1; i++) {
            // 每两个相邻的词进行比较
            String word1 = words[i];
            String word2 = words[i+1];
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                char from = word1.charAt(j);
                char to =  word2.charAt(j);
                if (from != to) {
                    if (map.containsKey(from)) {
                        map.get(from).add(to);
                    } else {
                        Set<Character> set = new HashSet<Character>();
                        set.add(to);
                        map.put(from, set);
                    }

                    inDegree.put(to, inDegree.get(to) + 1);
                    // 我们比较两个词的每一位，直到第一个不一样的字母
                    break; // !! have to break
                }
            }
        }

        // topological sort via BFS
        // using queue
        Queue<Character> queue = new LinkedList<Character>();
        for (Character c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            sb.append(c);
            if (map.containsKey(c)) {
                for (Character sub : map.get(c)) {
                    inDegree.put(sub, inDegree.get(sub)-1);
                    if (inDegree.get(sub) == 0) {
                        queue.offer(sub);
                    }
                }
            }
        }

        return (sb.length() != inDegree.size()) ? "" : sb.toString();
    }

    public static void main(String[] args) {
        GoogleLC269AlienDictionary l = new GoogleLC269AlienDictionary();
        System.out.println(l.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(l.alienOrder(new String[]{"wrtkj","wrt"}));
    }
}
