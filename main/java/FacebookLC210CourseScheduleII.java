package main.java;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by joyfeng on 11/18/2016.
 */
public class FacebookLC210CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] in = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int[] schedule = prerequisites[i];
            in[schedule[0]]++;
            if (map.containsKey(schedule[1])) {
                map.get(schedule[1]).add(schedule[0]);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(schedule[0]);
                map.put(schedule[1], list);
            }
        }

        java.util.Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int start = 0;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            res[start++] = n;
            if (map.containsKey(n)) {
                List<Integer> list = map.get(n);
                for (int s : list) {
                    in[s]--;
                    if (in[s] == 0) {
                        queue.offer(s);
                    }
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0) {
                return new int[]{};  // !! new int[]{} is an empty, not new int[numCourses], whoes elements are initialized 0.
            }
        }

        return res;
    }
}
