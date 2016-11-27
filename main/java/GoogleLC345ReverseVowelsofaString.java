package main.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by joyfeng on 11/26/2016.
 */
public class GoogleLC345ReverseVowelsofaString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] arr = s.toCharArray();
        int low = 0, high = arr.length - 1;
        while (low < high) {
            while (low < high && !vowels.contains(arr[low])) {
                low++;
            }
            while (low < high && !vowels.contains(arr[high])) {
                high--;
            }
            char tmp = arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;

            low++;
            high--;
        }

        return new String(arr);
    }
}
