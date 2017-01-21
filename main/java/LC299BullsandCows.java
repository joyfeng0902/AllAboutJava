package main.java;

public class LC299BullsandCows {
    public String getHint(String secret, String guess) {
        int b = 0, c = 0;
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);

            if (c1 == c2) {
                b++;
            } else {
                arr1[c1-'0']++;
                arr2[c2-'0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            c += Math.min(arr1[i], arr2[i]);
        }

        return b+"A"+c+"B";
    }
}
