package main.java;

public class LC242AreAnagram {
    // Check whether two strings are anagram of each other
    // An anagram of a string is another string that contains same characters,
    // only the order of characters can be different. For example, “abcd” and “dabc” are anagram of each other.
    private static boolean areAnagram(String s1, String s2) {
        char[] checker = new char[256];
        for (int i = 0; i < s1.length(); i++) {
            checker[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            checker[s2.charAt(i)]--;
        }

        for (int i = 0; i < checker.length; i++) {
            if (checker[i] > 0)  {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(areAnagram("abcde", "edbca"));
        System.out.println(areAnagram("abcfde", "edbca"));
        System.out.println(areAnagram("", " "));
        System.out.println(areAnagram("", ""));
    }
}
