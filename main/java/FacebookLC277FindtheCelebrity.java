package main.java;

/**
 * Created by joyfeng on 11/20/2016.
 */
public class FacebookLC277FindtheCelebrity {
    public int findCelebrity(int n) {
        // using  a bitmap[]. bitmap[i] is how many people knows i
        int[] bitmap = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (knows(i, j)) {
                    bitmap[i] = -1;
                    bitmap[j]++;
                } else {
                    bitmap[j] = -1;
                }
            }
        }

        for (int i = 0; i < n ; i++) {
            if (bitmap[i] == n-1) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        if (knows(i, j)) {
                            return -1;
                        }
                    }
                }

                return i;
            }
        }
        return -1;
    }

    public boolean knows(int a,int b){
        //这里是给出的API
        return true;
    }
}
