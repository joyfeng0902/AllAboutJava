package main.java;

/**
 * Created by joyfeng on 11/25/2016.
 */
public class FacebookLC43MultiplyStrings {
    //  The key to solve this problem is multiplying each digit of the numbers at the corresponding positions and
    //  get the sum values at each position. That is how we do multiplication manually.
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[num1.length() + num2.length()];

        //multiply each digit and sum at the corresponding positions
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                d[i+j] += (n1.charAt(i)-'0')*(n2.charAt(j)-'0');
            }
        }

        StringBuilder sb = new StringBuilder();
        // calculate each digit
        for (int i = 0; i < d.length; i++) {
            int mod = d[i] % 10;
            int carry = d[i] / 10;
            if (i+1 < d.length) {
                d[i+1] += carry;
            }
            sb.append(mod);
        }

        int index = sb.length()-1;
        while (sb.charAt(index) == '0' && sb.length() > 1) {
            sb.deleteCharAt(index);
            index--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        FacebookLC43MultiplyStrings f = new FacebookLC43MultiplyStrings();
        f.multiply("123", "456");
    }
}
