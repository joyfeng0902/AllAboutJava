package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * n = 0,  0
 * n = 1,  0
 *         1
 * n = 2   00
 *         01
 *         10
 *         11
 */
public class FacebookLC89GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
            result.add(0);
            return result;
        }
        result = grayCode(n-1);
        for (int i = result.size() - 1; i >= 0; i--) {
            result.add((1<<(n-1)) | result.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        FacebookLC89GrayCode s = new FacebookLC89GrayCode();
        s.grayCode(3);
    }
}
