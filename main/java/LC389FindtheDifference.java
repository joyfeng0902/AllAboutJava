package main.java;

/**
 * Created by joyfeng on 11/27/2016.
 */
public class LC389FindtheDifference {
    // 分别统计s与t的字母个数，然后比对即可
    // or 任何数异或自己都为0
    public char findTheDifference(String s, String t) {
        char result = 0;
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        for (char c : t.toCharArray()) {
            result ^= c;
        }

        return result;
    }
}
