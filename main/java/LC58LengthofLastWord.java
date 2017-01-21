package main.java;

public class LC58LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int i = s.length()-1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                if (len > 0) {
                    return len;
                }
            } else {
                len++;
            }

            i--;
        }

        return len;   // corner case: "a"
    }
}
