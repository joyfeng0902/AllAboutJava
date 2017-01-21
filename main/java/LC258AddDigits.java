package main.java;

/**
 * Created by joyfeng on 12/4/2016.
 */
public class LC258AddDigits {
    public int addDigits(int num) {
        int sum = 0;
        String nums = String.valueOf(num);
        for (int i = 0; i < nums.length(); i++) {
            char c = nums.charAt(i);
            sum += c - '0';
        }

        if (sum < 10) {
            return sum;
        } else {
            return addDigits(sum);
        }
    }
}
