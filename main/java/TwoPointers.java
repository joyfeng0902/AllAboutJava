package main.java;

/**
 * Created by joyfeng on 10/2/2016.
 */
public class TwoPointers {
    public int[] LC167TwoSumII(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i+1, j+1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }
}
