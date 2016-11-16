package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joyfeng on 10/29/2016.
 */
public class GoogleLC22GenerateParentheses {
    // using dfs
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        helper(result, "", n, n);

        return result;
    }

    // 其中left表示可以追加多少左括号，right表示可以追加多少右括号，s表示当前括号组成的字符串。
    // 每往left里追加(后，left-1; 每往s里追加)后，right-1
    void helper(List<String> result, String s, int left, int right) {
        /*
        left and right represents the remaining number of ( and ) that need to be added.
        When left > right, there are more ")" placed than "(". Such cases are wrong and the method stops.
        */
        if (left > right || left < 0 || right < 0){
            return;
        }

        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        helper(result, s + "(", left - 1, right);
        helper(result, s + ")", left, right - 1);
    }

    void printResult(List<String> result) {
        for (String s: result) {
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        GoogleLC22GenerateParentheses g = new GoogleLC22GenerateParentheses();
        g.printResult(g.generateParenthesis(3));
    }
}
