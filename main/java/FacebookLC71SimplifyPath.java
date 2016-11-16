package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by joyfeng on 11/9/2016.
 */
public class FacebookLC71SimplifyPath {
    public String simplifyPath(String path) {
        // Using a stack
        // if current is .., check if there is element in stack if so, pop the element
        // if current is . or ' ', do not do anything
        // push into stack
        Stack<String> stack = new Stack<String>();
        Set<String> skip = new HashSet<String>(Arrays.asList("..",".",""));
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
                // } else if (!dir.equals("..") && !dir.equals(".") && !dir.equals("")) {  // consider case: /..
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }
        if (stack.isEmpty()) {  // donot forget
            return "/";
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }

        return res;
    }
}
