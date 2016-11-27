package main.java;

/**
 * Created by joyfeng on 10/11/2016.
 */
public class FacebookLC168ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int digit = n % 26;
            n /= 26;
            if (digit == 0) {
                sb.append('Z');
                n--; // remember that n--
            } else {
                sb.append((char)('A' + digit - 1)); // sb.append('A' + digit);
            }
        }

        return sb.reverse().toString();
    }
}
