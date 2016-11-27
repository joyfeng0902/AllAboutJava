package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joyfeng on 11/20/2016.
 */
public class GoogleLC17LetterCombinationsofaPhoneNumber {
    private Map<Character, char[]> map = new HashMap<Character, char[]>();
    // backtracking, DFS
    public List<String> letterCombinations(String digits) {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        helper(result, 0, new StringBuilder(), digits);
        return result;
    }

    void helper(List<String> result, int start, StringBuilder tmp, String digits) {
        if (start == digits.length()) {
            result.add(tmp.toString());
            return;
        }

        char c = digits.charAt(start);
        char[] chars = map.get(c);
        for (int i = 0; i < chars.length; i++) {
            char n = chars[i];
            tmp.append(n);
            helper(result, start + 1, tmp, digits);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }
}
