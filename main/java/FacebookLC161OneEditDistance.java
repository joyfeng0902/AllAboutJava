package main.java;

/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class FacebookLC161OneEditDistance {
    // delete, add, replace 三种都是One edit distance. delete和add 两个string长度差1, replace相同长度.
    // better than the method below it
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || s.equals(t)) {
            return false;
        }
        int sl = s.length(), tl = t.length();
        if (sl > tl) {
            return isOneEditDistance(t, s);
        }
        if (Math.abs(sl-tl) > 1) {
            return false;
        }

        if (sl == tl) {  // modify
            int diffCount = 0, i = 0;
            while (i < sl) {
                if (s.charAt(i) != t.charAt(i)) {
                    diffCount++;
                }
                if (diffCount > 1) {
                    return false;
                }
                i++;
            }
            return true;
        } else {         // delete or insert
            int diffCount = 0, i = 0, j = 0;
            while (i < sl && j < tl) {
                if (s.charAt(i) != t.charAt(j)) {
                    diffCount++;
                    j++;   // because tl > sl
                    if (diffCount > 1) {
                        return false;
                    }
                } else {
                    i++;
                    j++;
                }
            }
            return true;
        }
    }

    boolean isOneEditDistance2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (Math.abs(m-n) > 1) {
            return false;
        }
        int count = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            // If current characters don't match
            if (word1.charAt(i) != word2.charAt(j)) {
                if (count == 1) {
                    return false;
                }

                count++;

                // If length of one string is
                // more, then only possible edit
                // is to remove a character
                if (m > n) {
                    i++;
                } else if (m < n) {
                    j++;
                } else { //If lengths of both strings is same
                    i++;
                    j++;
                }
            } else {  // if current match
                i++;
                j++;
            }
        }

        // If last character is extra in any string because if Math.abs(m-n) > 1 we already return false
        if (i < m || j < n) {
            count++;
        }

        return count == 1;
    }

    public static void main(String[] args) {
        FacebookLC161OneEditDistance f = new FacebookLC161OneEditDistance();
        String s1 = "gfg";
        String s2 = "gf";
        System.out.println(f.isOneEditDistance(s1, s2));  // true

        s1 = "ab";
        s2 = "gf";
        System.out.println(f.isOneEditDistance(s1, s2));  // false

        s1 = "geeks";
        s2 = "geek";
        System.out.println(f.isOneEditDistance(s1, s2));  // true

        s1 = "geeks";
        s2 = "geeks";
        System.out.println(f.isOneEditDistance(s1, s2));  // false

        s1 = "geaks";
        s2 = "geeks";
        System.out.println(f.isOneEditDistance(s1, s2));  // true

        s1 = "ab";
        s2 = "gab";
        System.out.println(f.isOneEditDistance(s1, s2));  // true

        s1 = "acb";
        s2 = "gab";
        System.out.println(f.isOneEditDistance(s1, s2));  // false

        s1 = "ab";
        s2 = "acb";
        System.out.println(f.isOneEditDistance(s1, s2));  // true

        s1 = "ab";
        s2 = "abcd";
        System.out.println(f.isOneEditDistance(s1, s2));  // false
    }
}
