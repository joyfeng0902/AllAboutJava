package main.java;

/**
 * Created by joyfeng on 11/16/2016.
 */
public class HighestProductOfThree {
    public int highestProductOf3(int[] arrayOfInts) {
        // greedy approach: just one pass through the input, y simply updating the best answer so far.
        // at each iteration we are keeping track of and updating:
        // highestProductOfThree
        // highestProductOf2
        // highest -> so that we can get the highest/lowest product of 2
        // lowestProductOf2
        // lowest
        // O(n) time and O(1) space
        if (arrayOfInts == null || arrayOfInts.length < 3) {
            return 0;
        }

        int highest = Math.max(arrayOfInts[0], arrayOfInts[1]);
        int highestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
        int lowest = Math.min(arrayOfInts[0], arrayOfInts[1]);
        int lowestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
        int highestProductOfThree = 0;
        // start from the 3rd int
        for (int i = 2; i < arrayOfInts.length; i++) {
            int numi = arrayOfInts[i];
            highestProductOfThree = Math.max(Math.max(highestProductOf2 * numi, lowestProductOf2 * numi), highestProductOfThree);
            highest = Math.max(highest, numi);
            lowest = Math.min(lowest, numi);
            highestProductOf2 = Math.max(Math.max(highestProductOf2, highest * numi), lowest * numi);
            lowestProductOf2 = Math.min(Math.min(lowestProductOf2, highest * numi), lowest * numi);
        }

        return highestProductOfThree;
    }

    public static void main(String[] args) {
        HighestProductOfThree h = new HighestProductOfThree();
        System.out.println(h.highestProductOf3(new int[]{1, 10, -5, 1, -100}));
    }
}
