package main.java;

public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }

        int i = 0, j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!isLetter(ci) && !isNum(ci)) {
                i++;
                continue;
            }
            if (!isLetter(cj) && !isNum(cj)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(ci) != Character.toLowerCase(cj)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    static boolean isLetter(char a) {
        if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {
            return true;
        }
        return false;
    }

    static boolean isNum(char a) {
        if (a >= '0' && a <= '9') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "ab";
        isPalindrome(s);
    }
}
