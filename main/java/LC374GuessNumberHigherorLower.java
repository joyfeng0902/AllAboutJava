package main.java;

/**
 * Created by joyfeng on 10/12/2016.
 */
public class LC374GuessNumberHigherorLower {
    /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

    int guess(int num) {
        //dummy
        return 0;
    }
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low+1 < n) {
            int mid = low + (high-low)/2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                high = mid;
            } else {
                low = mid;
            }
        }

        if (guess(high) == 0) {
            return high;
        }

        return low;
    }
}
