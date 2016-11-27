package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 *
 A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class GoogleLC246StrobogrammaticNumber {
    // pair: (6, 9), (9, 6), (8, 8), (1, 1), (0, 0)
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('9', '6');
        map.put('6', '9');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');

        int length = num.length();
        int low = 0, high = length-1;

        while(low <= high) {  // "=" to check if num is 1 digit like 2
            if (!map.containsKey(num.charAt(low)) || !map.get(num.charAt(low)).equals(num.charAt(high))) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }

    public static void main (String[] args) {
        GoogleLC246StrobogrammaticNumber g = new GoogleLC246StrobogrammaticNumber();
        System.out.println(g.isStrobogrammatic("123452"));   // false
        System.out.println(g.isStrobogrammatic("8"));   // true
        System.out.println(g.isStrobogrammatic("69"));   // true
        System.out.println(g.isStrobogrammatic("818"));   // true
        System.out.println(g.isStrobogrammatic(""));   // false
    }
}
