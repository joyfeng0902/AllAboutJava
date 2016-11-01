package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by joyfeng on 10/19/2016.
 */
public class GoogleLC20ValidParentheses {
    public boolean isValid(String s) {
        final Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.keySet().contains(c)) {
                stack.push(c);
            } else if (map.values().contains(c)) {
                // pop from stack and check if match
                if (stack.isEmpty() || (!stack.isEmpty() && c != map.get(stack.pop()))) {
                    return false; // stack is already empty or no match
                }
            }
        }

        return stack.isEmpty();
    }
}
