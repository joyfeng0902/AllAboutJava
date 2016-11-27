package main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by joyfeng on 11/20/2016.
 */
public class FacebookLC301RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null) {
            return res;
        }
        // BFS
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.offer(s);
        // 需要设置一个boolean foundResult，假如在这一层找到结果的话，我们就不再继续进行下面的for循环了。
        boolean foundResult = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                res.add(s);
                foundResult = true;
            }
            if(foundResult) {
                continue;
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == ')') {
                    String newStr = s.substring(0, i) + s.substring(i+1);
                    if (!visited.contains(newStr)) {
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }
        return res;
    }

    boolean isValid(String str) {
        int leftCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                leftCount--;
            }
            if (leftCount < 0) {
                return false;
            }
        }

        return leftCount == 0;
    }

    public static void main(String[] args) {
        FacebookLC301RemoveInvalidParentheses f = new FacebookLC301RemoveInvalidParentheses();
        f.removeInvalidParentheses("");
        f.removeInvalidParentheses("))");
        f.removeInvalidParentheses("()())()");
    }
}
