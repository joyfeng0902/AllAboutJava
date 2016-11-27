package main;

public class LC9PalindromeNumber {
    // example:
    // 12321
    // 12321 / 10000 = 1 (left), 12321 % 10 = 1 (right), 12321 % 10000 = 2321, 2321 / 10 = 232
    // 232 / 100 = 2 (left), 232 % 10 = 2 (right), 232 % 100 = 32, 32 / 10 = 3
    // 3 / 1 = 3, 3 % 10 = 3, 3 % 1 = 0, 0 / 10 = 0, stop
    public static boolean is_numeric_palindrome(long number) {
        if (number < 0) {    // negative number
            return false;
        }
        // get powers of the number
        // for example, the power of 42 is 1 (10^1 = 10), the power of 1 is 0 (10^0 = 1)
        //int power = 0;
//        long tmp = number;
//        while (tmp >= 10) {
//            tmp /= 10;
//            power++;
//        }
        int div = 1;
        while (number / div >= 10) {
            div *= 10;
        }

        while(number > 0) {
            //int div = (int)Math.pow(10, power);
            int leftDigit = (int)number / div;  // make sure you have (int), Math.pow returns double
            if (number % 10 != leftDigit) {
                return false;
            }
            number = number % div / 10;    // get the second left digit, then third...
            //power -= 2;
            div /= 100;
        }

        return true;
    }

    public static void main( String[] args) {
        System.out.println(LC9PalindromeNumber.is_numeric_palindrome(1000021));           // false
        System.out.println(LC9PalindromeNumber.is_numeric_palindrome(1));             // true
        System.out.println(LC9PalindromeNumber.is_numeric_palindrome(42));         // false
        System.out.println(LC9PalindromeNumber.is_numeric_palindrome(100001));     // true
        System.out.println(LC9PalindromeNumber.is_numeric_palindrome(999));     // true
    }
}
