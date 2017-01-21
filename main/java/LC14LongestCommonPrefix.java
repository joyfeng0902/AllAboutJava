package main.java;

/**
 * Created by joyfeng on 1/2/2017.
 */
public class LC14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            while (s.indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length()-1);
            }
        }

        return pre;
    }
}
