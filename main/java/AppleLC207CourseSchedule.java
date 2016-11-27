package main.java;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by joyfeng on 11/18/2016.
 */
public class AppleLC207CourseSchedule {
    // find a cycle in a directed graph
    // If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Using BFS
        // Build the directed graph
        int[] in = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] schedule : prerequisites) {
            in[schedule[0]]++;
            if (map.containsKey(schedule[1])) {
                map.get(schedule[1]).add(schedule[0]);
            } else {
                List<Integer> l = new ArrayList<Integer>();
                l.add(schedule[0]);
                map.put(schedule[1], l);
            }
        }

        java.util.Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int t = queue.poll();
            if(map.containsKey(t)) {
                for (int q: map.get(t)) {
                    if (--in[q] == 0) {
                        queue.offer(q);
                    }
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AppleLC207CourseSchedule l = new AppleLC207CourseSchedule();
        int[][] prerequisites = new int[1][];
        prerequisites[0] = new int[]{0, 1};
        l.canFinish(2, prerequisites);
    }
}
