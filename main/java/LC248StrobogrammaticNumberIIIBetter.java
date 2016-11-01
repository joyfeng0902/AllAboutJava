package main.java;

/**
 * Created by joyfeng on 10/20/2016.
 */
public class LC248StrobogrammaticNumberIIIBetter {
    int res = 0;
    public int strobogrammaticInRange(String low, String high) {
        helper(low, high, "");
        helper(low, high, "0");
        helper(low, high, "1");
        helper(low, high, "8");

        return res;
    }

    void helper(String low, String high, String path) {
        if (path.length() >= low.length() && path.length() <= high.length()) {
            if ((path.length() == low.length() && path.compareTo(low) < 0) || (path.length() == high.length() && path.compareTo(high) > 0)) {
                return;
            }
            if (!(path.length() > 1 && path.startsWith("0"))) {
               res++;
            }
        }
        if (path.length() + 2 > high.length()) return;

        helper(low, high, "6" + path + "9");
        helper(low, high, "9" + path + "6");
        helper(low, high, "8" + path + "8");
        helper(low, high, "1" + path + "1");
        helper(low, high, "0" + path + "0");
    }

    public static void main(String[] args) {
        LC248StrobogrammaticNumberIIIBetter g = new LC248StrobogrammaticNumberIIIBetter();
        System.out.println(g.strobogrammaticInRange("50", "100"));
    }
}
