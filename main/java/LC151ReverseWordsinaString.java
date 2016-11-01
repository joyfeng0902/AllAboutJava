package main.java;

/**
 * Created by joyfeng on 10/14/2016.
 */
public class LC151ReverseWordsinaString {
    public String reverseWords(String s) {
        // read from the end, if meet a space, reverse and append
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            StringBuilder word = new StringBuilder();
            while(i >= 0 && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                i--;
            }
            sb.append(word.reverse());
            sb.append(' ');
        }

        return sb.toString().trim();
    }
}
