package main.java;

/**
 * Created by joyfeng on 1/3/2017.
 */
public class LC392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        int iS = 0, iT = 0;
        while (iT < t.length()) {
            // only when s[iS] == t[iT], move iS
            if (s.charAt(iS) == t.charAt(iT)) {
                iS++;
                if (iS == s.length()) {
                    return true;
                }
            }
            // move iT
            iT++;
        }

        return false;
    }
}
