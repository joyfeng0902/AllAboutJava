package main.java;

import java.util.LinkedHashSet;

public class RemoveDuplicate {
    // use Set which no duplicates are allowed.
    private static void removeDuplicate(String s) {
        LinkedHashSet<Character> lhs = new LinkedHashSet();       // beautiful! using LinkedHashSet: preserve the order while removing duplicates
        for (int i = 0; i < s.length(); i++) {
            lhs.add(s.charAt(i));
        }

        for (Character lh : lhs) {
            System.out.print(lh);
        }
        System.out.print("\n");
    }

    // not using extra space
    private static void removeDuplicate(char[] s) {
        boolean[] checker = new boolean[256];   // use boolean not Boolean (initialized to be null)
        int p = 0;
        for (int i = 0; i < s.length; i++) {
            if (!checker[s[i]]) {  // not duplicate
                s[p++] = s[i];
                checker[s[i]] = true;
            }
        }
        for (int i = p; i < s.length; i++) {   // don't forget this!
            s[i] = '\0';
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        removeDuplicate("12gshjd8&5(");

        char[] arrs = new char[]{'1', '2', '3', '2', '1'};
        removeDuplicate(arrs);
    }
}
