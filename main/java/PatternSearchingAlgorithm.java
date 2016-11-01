package main.java;

/**
 * Created by joyfeng on 10/12/2016.
 */
public class PatternSearchingAlgorithm {
    // naive search
    void naiveSearch(String txt, String pat) {
        // string to char array
        char[] txtArray = txt.toCharArray();
        char[] patArray = pat.toCharArray();

        int m = txtArray.length, n = patArray.length;
        for (int i = 0; i <= m - n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (txtArray[i+j] != patArray[j]) {
                    break; // jump out of the inner for loop
                }
            }

            if (j == n) {    // parArray[0...n-1] = txtArray[i, i+1...i+n-1]
                System.out.println("Pattern found at index " + i);
            }
        }
    }

    void kmpSearch(String txt, String pat) {
        // prefix function
        // string match

    }

    public static void main(String[] args) {
        PatternSearchingAlgorithm p = new PatternSearchingAlgorithm();
        String txt = "AABAACAADAABAAABAA";
        String pat = "AABA";
        p.naiveSearch(txt, pat);
        System.out.println("***********************");
        txt = "AABCCAADDEE";
        pat = "FAA";
        p.naiveSearch(txt, pat);
        System.out.println("***********************");
        txt = "AAAAAAAAAAAAAAAAAA";
        pat = "AAAAA";
        p.naiveSearch(txt, pat);
    }
}
