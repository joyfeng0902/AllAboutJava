package main.java;

/**
 * Created by joyfeng on 11/21/2016.
 */
public class FacebookLC28ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return 0;
        }
        if (needle.length() == 0) {
            return 0;
        }

        int hl = haystack.length(), nl = needle.length();
        for (int i = 0; i < hl; i++) {
            if (i + nl > hl) {
                return -1;
            }
            int m = i;
            for (int j = 0; j < nl; j++) {
                if (haystack.charAt(m) == needle.charAt(j)) {
                    if (j == nl-1) {
                        return i;
                    }
                    m++;
                } else {
                    break;
                }
            }
        }
        return -1;
    }
}
