import java.util.HashMap;
import java.util.Map;

public class GoogleLC340LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0|| s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() < k) {
            return s.length();
        }
        int max = 0, start = 0; // start is used to record the start of the string tracked so far
        // Using a hashmap to track unique element in the map
        // when a (k+1)th char is added to the map, the left pointer has to move right
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            // check if a (k+1)th char is reached
            if (map.size() > k) {
                max = Math.max(max, i-start);

                // now move to the right, and kick the first char in the prev string out
                while (map.size() > k) {
                    char prevFirstChar = s.charAt(start);
                    int count = map.get(prevFirstChar);
                    if (count > 1) {
                        map.put(prevFirstChar, count-1);
                    } else {       // count == 1
                        map.remove(prevFirstChar);
                    }
                    start++;
                }
            }
        }

        max = Math.max(max, s.length()-start);

        return max;
    }

    public static void main (String [] args) {
        GoogleLC340LongestSubstringwithAtMostKDistinctCharacters s = new GoogleLC340LongestSubstringwithAtMostKDistinctCharacters();
        System.out.println(s.lengthOfLongestSubstringKDistinct("abcadcacacaca", 3));
    }
}
