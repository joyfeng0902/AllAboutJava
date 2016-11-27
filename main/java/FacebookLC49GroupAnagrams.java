package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */
public class FacebookLC49GroupAnagrams {
    // If two strings are anagram to each other, their sorted sequence is the same.
    // !! new String(char[])
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] cArr = new char[26];
            for (char c : str.toCharArray()) {   // !! not for (char c : str)  or (Character c : str)
                cArr[c-'a']++;
            }
            String newStr = new String(cArr);

            if (map.containsKey(newStr)) {
                map.get(newStr).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(newStr, list);
            }
        }

        res.addAll(map.values()); // !! addAll
        return res;
    }
}
