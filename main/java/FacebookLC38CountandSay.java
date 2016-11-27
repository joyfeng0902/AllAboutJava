package main.java;

/**
 * Created by joyfeng on 11/24/2016.
 */
public class FacebookLC38CountandSay {
    public String countAndSay(int n) {
        String res = "1";
        if (n == 1) {
            return res;
        }
        for (int i = 2; i <= n ; i++) {
            res = convert(res);
        }
        return res;
    }

    String convert(String str){
        StringBuilder sb = new StringBuilder();
        int i = 0, length = str.length();
        int count = 1;
        while (i < length - 1) {
            while (i < length - 1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(str.charAt(i));
            i++;
            count = 1;
        }
        if (i == length - 1) {
            sb.append(count);
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        FacebookLC38CountandSay l = new FacebookLC38CountandSay();
        System.out.println(l.countAndSay(2));
    }
}
