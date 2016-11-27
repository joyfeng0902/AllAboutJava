package main.java;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by joyfeng on 11/21/2016.
 */
public class GoogleLC139WordBreak {
    // DP
    // if the size of the dic is very large, will time out
    // Time: O(string length * dict size).
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] match = new boolean[s.length()+1];  // that t[i]==true => 0-(i-1) can be segmented using dictionary
        match[0] = true; // if s is empty

        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 0; j < i; j++) {
                if (match[j] && wordDict.contains(s.substring(j, i))) {
                    match[i] = true;
                    break;
                }
            }
        }

        return match[s.length()];
    }
}
