package main.java;

/**
 * Created by joyfeng on 10/12/2016.
 */
class GuessGame {
    int guess(int num) {
        //dummy
        return 0;
    }
}
public class LC374GuessNumberHigherorLower {
    /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int low = 1, high = n;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int guessed = guess(mid);
                if (guessed == 0) {
                    return mid;
                } else if (guessed == 1) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return -1;
        }
    }
}
