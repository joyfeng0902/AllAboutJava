package main.java;

/**
 * Created by joyfeng on 11/3/2016.
 */
public class LC344ReverseString {
    public String reverseString(String s) {
        int left = 0, right = s.length() - 1;
        // String to char Array
        char[] charArr = s.toCharArray();
        while(left < right) {
            charArr[left] = s.charAt(right);
            charArr[right] = s.charAt(left);
            left++;
            right--;
        }

        // char array to String
        return new String(charArr);
    }
}
