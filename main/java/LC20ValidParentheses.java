package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by joyfeng on 10/19/2016.
 */
public class LC20ValidParentheses {
    public boolean isValid(String s) {
        final Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (map.keySet().contains(c)) {
                stack.push(c);
            } else {
                // pop from stack and check if match
                if (stack.isEmpty() || map.get(stack.pop()) != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
