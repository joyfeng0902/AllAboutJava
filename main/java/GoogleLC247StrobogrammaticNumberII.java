package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).+

 Find all strobogrammatic numbers that are of length = n.
 For example, Given n = 2, return ["11","69","88","96"].
 */
public class GoogleLC247StrobogrammaticNumberII {
    int curr = 0;
    // recursion
    public List<String> findStrobogrammatic(int n) {
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
        List<String> prev = findStrobogrammatic(n-2);
        curr++;

        for (String s : prev) {
            if (curr < (n-2))
                res.add("0" + s + "0");  // cannot be 010, 000, 00800 and etc
            res.add("1" + s + "1");
            res.add("8" + s + "8");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
        }

        return res;
    }

    static void printList(List<String> list) {
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        GoogleLC247StrobogrammaticNumberII g = new GoogleLC247StrobogrammaticNumberII();
        printList(g.findStrobogrammatic(1));
        printList(g.findStrobogrammatic(2));
        printList(g.findStrobogrammatic(3));
    }
}
