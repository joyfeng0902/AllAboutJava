package main.java;

public class LC186ReverseWordsinaStringII {
    public void reverseWords(char[] s) {
        int length = s.length;
        reverseWord(s, 0, length-1); // reverse the whole string first
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s[i] != ' ') {  // if  ' ' ignore and continue
                i++;
            }
            if (i == length-1) {
                reverseWord(s, start, i);   // reverse each string with special case: the last string because for the last string we do not have a ' ' after it
            } else {
                reverseWord(s, start, i-1);
            }
            i++;
        }
    }

    public void reverseWord(char[] s, int i, int j) {
        if (s == null || s.length <= 1) {
            return;
        }

        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
