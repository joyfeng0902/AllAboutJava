package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleLC336PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        // if the word is a palindrome, get index of ""
        // if the reversed word exists, it is a palindrome
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (isPalindrome(s) && map.containsKey("") && !s.equals("")) {   // make sure s is not ""
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(i);
                pair.add(map.get(""));
                result.add(pair);

                pair = new ArrayList<Integer>();
                pair.add(map.get(""));
                pair.add(i);
                result.add(pair);
            }
            String reversed = new StringBuilder(s).reverse().toString();
            if (map.containsKey(reversed)) {
                if (map.get(reversed) != i) {
                    ArrayList<Integer> pair = new ArrayList<Integer>();
                    pair.add(i);
                    pair.add(map.get(reversed));
                    result.add(pair);
                }
            }

            // iterate the String
            // if left part is palindrome, find the reversed of the right part
            // if right is palindrome, find the reversed left
            for (int k = 1; k < s.length(); k++) {  // k starts from 1 not 0, otherwise left is ""
                String left = s.substring(0, k);
                String right = s.substring(k);

                if (isPalindrome(left)) {
                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(reversedRight)) {
                        if(map.get(reversedRight) != i){  // if they are equal, it is palindrome already
                            ArrayList<Integer> l = new ArrayList<Integer>();
                            l.add(map.get(reversedRight));
                            l.add(i);
                            result.add(l);
                        }
                    }
                }

                if (isPalindrome(right)) {
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(reversedLeft)) {
                        if(map.get(reversedLeft) != i){  // if they are equal, it is palindrome already
                            ArrayList<Integer> l = new ArrayList<Integer>();
                            l.add(i);
                            l.add(map.get(reversedLeft));
                            result.add(l);
                        }
                    }
                }
            }
        }

        return result;
    }

    // brute force solution, exceed time
    public List<List<Integer>> palindromePairsBF(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && isPalindrome(new StringBuilder().append(words[i]).append(words[j]).toString())) {
                    List<Integer> pair = new ArrayList<Integer>();
                    pair.add(i);
                    pair.add(j);
                    result.add(pair);
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String x) {
        int i = 0, j = x.length()-1;

        while (i < j) {
            if (x.charAt(i) != x.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        GoogleLC336PalindromePairs g = new GoogleLC336PalindromePairs();
        String[] words = new String[5];
        words[0] = "abcd";
        words[1] = "dcba";
        words[2] = "lls";
        words[3] = "s";
        words[4] = "sssll";
        g.palindromePairsBF(words);
        g.palindromePairs(words);
    }
}

