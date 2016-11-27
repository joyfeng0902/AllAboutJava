package main.java;// 1. Implement an algorithm to determine if a string has
// all unique characters. What if you can not use additional data structures?

// 2. Design an algorithm and write code to remove the duplicate characters in a string without
// using any additional buffer. NOTE: One or two additional variables are fine.
// An extra copy of the array is not.

public class UniqueString {
    private static boolean isUniqueAscII(String s) {
        // shortcut
        if (s.length() > 256) {
            return false;
        }
        boolean[] charMap = new boolean[256];   // initially false
        // read through the string
        for(int i = 0; i < s.length(); i++) {
            int c = (int)s.charAt(i);   // int
            if(charMap[c]) return false;
            charMap[c] = true;
        }
        return true;
    }

    // if only a-z or A-Z
    private static boolean isUniqueChar(String s) {
        int checker = 0;
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';   // int
            if ((checker & (1 << c)) == 1) return false;     // get position c << 1, and set the bit to be 1 in that position
            checker |= (1 << c);           // set the bit
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "12gshjdg8&5(";
        System.out.println(isUniqueAscII(s));
        s = "abc";
        System.out.println(isUniqueChar(s));
    }
}
