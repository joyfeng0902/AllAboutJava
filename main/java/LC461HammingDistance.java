package main.java;

public class LC461HammingDistance {
    public int hammingDistance(int x, int y) {
        int count = 0, xor = x^y; // xor is the difference
        for (int i = 0; i < 32; i++) {  // how amny bits in xor?
            count += (xor >> i) & 1;
        }

        return count;
    }
}
