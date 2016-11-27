package main.java;

public class FacebookLC125ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isLetterOrNumber(s.charAt(i))) {
                i++;
            }

            while (i < j && !isLetterOrNumber(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {    // Character.toLowerCase()
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    boolean isLetterOrNumber(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    public static void main (String[] args) {
        FacebookLC125ValidPalindrome f = new FacebookLC125ValidPalindrome();
        System.out.println(f.isPalindrome("a."));   // true
        System.out.println(f.isPalindrome("aA"));   // true
        System.out.println(f.isPalindrome("a.b,."));   // false
    }
}
