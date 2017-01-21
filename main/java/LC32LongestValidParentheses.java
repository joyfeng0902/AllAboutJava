package main.java;

import java.util.Stack;

/**
 * Created by joyfeng on 1/3/2017.
 */
public class LC32LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int left = -1;
        int maxLen = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    left = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i-left);
                    } else {
                        maxLen = Math.max(maxLen, i-stack.peek());
                    }
                }
            }
            i++;
        }
        return maxLen;
    }
}
