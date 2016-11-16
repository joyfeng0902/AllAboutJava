package main.java;

/**
 * An edit between two strings is one of the following changes.

 Add a character
 Delete a character
 Change a character
 Given two string s1 and s2, find if s1 can be converted to s2 with exactly one edit.
 */
public class FacebookisEditDistanceOne {
    boolean isEditDistanceOne(String word1, String word2) {
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
        FacebookisEditDistanceOne f = new FacebookisEditDistanceOne();
        String s1 = "gfg";
        String s2 = "gf";
        System.out.println(f.isEditDistanceOne(s1, s2));  // true

        s1 = "ab";
        s2 = "gf";
        System.out.println(f.isEditDistanceOne(s1, s2));  // false

        s1 = "geeks";
        s2 = "geek";
        System.out.println(f.isEditDistanceOne(s1, s2));  // true

        s1 = "geeks";
        s2 = "geeks";
        System.out.println(f.isEditDistanceOne(s1, s2));  // false

        s1 = "geaks";
        s2 = "geeks";
        System.out.println(f.isEditDistanceOne(s1, s2));  // true

        s1 = "ab";
        s2 = "gab";
        System.out.println(f.isEditDistanceOne(s1, s2));  // true

        s1 = "acb";
        s2 = "gab";
        System.out.println(f.isEditDistanceOne(s1, s2));  // false

        s1 = "ab";
        s2 = "acb";
        System.out.println(f.isEditDistanceOne(s1, s2));  // true

        s1 = "ab";
        s2 = "abcd";
        System.out.println(f.isEditDistanceOne(s1, s2));  // false
    }
}