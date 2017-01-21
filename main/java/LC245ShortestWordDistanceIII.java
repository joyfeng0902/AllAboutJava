package main.java;

/**
 * Created by joyfeng on 12/30/2016.
 */
public class LC245ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1;
        int dist = Integer.MAX_VALUE;
        boolean same = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (same) {
                    p2 = p1;  // Deal with another pointer too
                }
                p1 = i;
            } else if (words[i].equals(word2)) {
                p2 = i;
            }

            if (p1 != -1 && p2 != -1) {
                dist = Math.min(dist, Math.abs(p1-p2));
            }
        }

        return dist;
    }
}
