package main.java;

public class IsRotation {
    // Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only
    // one call to isSubstring ( i.e., “waterbottle” is a rotation of “erbottlewat”).
    private static boolean isRotation(String s1, String s2) {
        // s2 must be a substring of (s1 + s1)
        if (s1 == null || s2 == null || s1.length() <= 0 || (s1.length() != s2.length())) {
             return false;
        }

        return isSubString(s1 + s1, s2);
    }

    private static boolean isSubString(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() > s1.length()) {
            return false;
        }

        if (s1.indexOf(s2) >= 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRotation(null, null));
        System.out.println(isRotation("waterbottle", "erbottlewat"));
        System.out.println(isRotation("apple", "pleap"));
        System.out.println(isRotation("apple", "pleapa"));
        System.out.println(isRotation(null, ""));
    }
}
