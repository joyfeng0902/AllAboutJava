package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

 For example,Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

 Note:Because the range might be a large number, the low and high numbers are represented as string..
 */
public class LC248StrobogrammaticNumberIII {
    int curr = 0;
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        List<String> whole = new ArrayList<String>();
        for (int i = low.length(); i <= high.length(); i++) {
            whole.addAll(helper(i));
        }
        for (String str : whole) {
            // compare String numbers
            // compareTo
            if ((str.length() == low.length() && str.compareTo(low) < 0) ||
                    (str.length() == high.length() && str.compareTo(high) > 0)) {
                continue;
            }
            count++;
        }
        return count;
    }

    List<String> helper(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            res.add("");
            return res;
        }
        if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        List<String> prev = helper(n - 2);
        curr++;

        for (String s: prev) {
            if (curr < n - 2)
                res.add("0" + s + "0");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
            res.add("1" + s + "1");
            res.add("8" + s + "8");
        }

        return res;
    }

    public static void main(String[] args) {
        LC248StrobogrammaticNumberIII g = new LC248StrobogrammaticNumberIII();
        System.out.println(g.strobogrammaticInRange("50", "100"));
    }
}
