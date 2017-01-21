package main.java;

/**
 * Created by joyfeng on 11/29/2016.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        char[] arr = s.toCharArray();
        int length = arr.length, i = 0;
        while (i < length) {
            char c = arr[i];
            res += (c-'A'+1) * Math.pow(26, length-1-i);
            i++;  // !! do not forget
        }
        return res;
    }
}
