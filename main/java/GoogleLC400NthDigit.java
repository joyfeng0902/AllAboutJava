package main.java;

/**
 * Created by joyfeng on 11/26/2016.
 */
public class GoogleLC400NthDigit {
    // first locate the number and then locate the digit in the number
    // 1位数：1-9: 9 numbers, 9 digits       1*9 = 9 digits
    // 2位数：10-99: 90 numbers, 180 digits     2*90 = 180 digits
    // 3位数：100-999: 900 numbers, 2700 digits    3*900 = 2700 digits
    // 4位数：1000-9999: 9000 numbers, 36000 digits
    // !! notice 1位数 starts from 1, n位数 starts from 10, 100, ...
    public int findNthDigit(int n) {
        // convert to long
        long m = n;

        long digitType = 1, digitNum = 9, start = 1;

        while (m > digitType * digitNum) {
            m -= digitType  * digitNum;
            digitType++;
            digitNum *= 10;
            start *= 10;
        }

        // identify the number: start + offset
        start += (m-1) / digitType;  // for example, 11 its offset is 1 in the array {10, 11, ..., 99}
        // identify the digit
        return String.valueOf(start).charAt((int)((m-1) % digitType)) - '0';
    }

    public static void main(String[] args) {
        GoogleLC400NthDigit g = new GoogleLC400NthDigit();
        g.findNthDigit(11);
    }
}
