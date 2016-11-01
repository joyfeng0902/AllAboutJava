package main.java;

import java.util.Random;

/**
 * Created by joyfeng on 10/23/2016.
 */
public class ReservoirSampling {
    Random r;
    // randomly choosing k samples from a list of n items, where n is either a very large or unknown number
    void selectKItems(int[] stream, int k) {
        // reservoir[] is the output array. Initialize it with
        // first k elements from stream[]
        int[] reservoir = new int[k];
        r = new Random();
        int i = 0;
        for (; i < k; i++) {
            reservoir[i] = stream[i];
        }

        // Iterate from the (k+1)th element to nth element
        for (; i < stream.length; i++) {
            // Pick a random index from 0 to i.
            int ram = r.nextInt(i);
            // If the randomly  picked index is smaller than k, then replace
            // the element present at the index with new element from stream
            if (ram < k) {
                reservoir[ram] = stream[i];
            }
        }

        for (int p : reservoir) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        int[] stream = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int k = 5;
        ReservoirSampling rs = new ReservoirSampling();
        rs.selectKItems(stream, k);
    }
}
