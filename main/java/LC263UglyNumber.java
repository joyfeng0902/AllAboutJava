package main.java;

/**
 * Created by joyfeng on 12/21/2016.
 */
public class LC263UglyNumber {
    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }

        if (num == 0) {
            return false;
        }

        for (int i = 2; i < 6; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }

        return num == 1;
    }
}
