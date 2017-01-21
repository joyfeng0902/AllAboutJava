package main.java;

/**
 * Created by joyfeng on 12/21/2016.
 */
public class LC342PowerofFour {
    // change number to quaternary and then check if it starts with "10".
    public boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("10*");    // regular expression
    }

    public static void main(String[] args) {
        LC342PowerofFour l = new LC342PowerofFour();
        l.isPowerOfFour(16);  // Integer.toString(num, 4) = "100"
        l.isPowerOfFour(5);   //   "11"
        l.isPowerOfFour(30);   //  "132"
        l.isPowerOfFour(4);   //   "10"
    }
}
