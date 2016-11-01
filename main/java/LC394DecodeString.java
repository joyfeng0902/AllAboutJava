package main.java;

/**
 * Created by joyfeng on 10/22/2016.
 */
public class LC394DecodeString {
    // DFS problem
    // a string may have many nested layers
    // for each layer, if we encounter [ we enter the next recursion
    // if we encounter ], we return the current result
    // until we finish all layers
    // we maintain a global position k, so that we know where the calculation is after each recursion.
    int k = 0;
    public String decodeString(String s) {
        int cnt = 0;
        String rtn = "", tmp = "";
        while (k < s.length()) {
            char curr =  s.charAt(k);
            if (curr >= '0' && curr <= '9') {  // digit
                cnt = cnt * 10 + curr - '0';
                k++;
            } else if (curr == '[') {
                k++;
                tmp = decodeString(s);
                for (int i = 0; i < cnt; i++) {
                    rtn += tmp;
                }
                cnt = 0;  // do not forgot
            } else if (curr == ']') {
                k++;
                return rtn;
            } else {
                rtn += curr;
                k++;
            }
        }

        return rtn;
    }

    public static void main (String[] args) {
        LC394DecodeString l = new LC394DecodeString();
        System.out.println(l.decodeString("3[a]2[bc]"));
    }
}
