package main.java;

/**
 * Given two binary strings, return their sum (also a binary string).

     For example,
     a = "11"
     b = "1"
     Return "100"
 */
public class FacebookLC67AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        int carry = 0;
        int i = a.length()-1, j = b.length()-1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int ia = (i >= 0) ? a.charAt(i)-'0' : 0;
            int ib = (j >= 0) ? b.charAt(j)-'0' : 0;
            int sum = ia + ib + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }

        if (carry == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
