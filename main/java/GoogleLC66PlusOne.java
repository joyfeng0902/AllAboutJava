package main.java;

/**
 * Created by joyfeng on 10/22/2016.
 */
public class GoogleLC66PlusOne {
    public int[] plusOne(int[] digits) {
        // start from the end
        int length = digits.length;
        int[] result = new int[length+1];
        for (int i = length - 1; i >= 0; i--) {
            int d = digits[i];
            if (d < 9) {
                digits[i] += 1;
                return digits;
            } else {  /// 999
                // each digit is 9, because otherwise it would return a number already
                digits[i] = 0;
                result[i+1] = 0;
            }
        }
        result[0] = 1;
        return  result;
    }
}
