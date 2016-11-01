package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class LC266PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        List<Character> charList = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);  // must be Character not char because list.remove(Object), must be an Object not primitive
            if (charList.contains(c)) {
                charList.remove(c);
            } else {
                charList.add(c);
            }
        }

        return charList.size() <= 1;
    }
}
