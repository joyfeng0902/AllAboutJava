import java.util.HashMap;
import java.util.Map;

public class GoogleLC159LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0, start = 0; // start is used to record the start of the string tracked so far
        // Using a hashmap to track unique element in the map
        // when a third char is added to the map, the left pointer has to move right
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            // check if a third char is reached
            if (map.size() > 2) {
                max = Math.max(max, i-start);

                // now move to the right, and kick the first char in the prev string out
                while (map.size() > 2) {
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
        GoogleLC159LongestSubstringwithAtMostTwoDistinctCharacters s = new GoogleLC159LongestSubstringwithAtMostTwoDistinctCharacters();
        System.out.println(s.lengthOfLongestSubstringTwoDistinct("abcba"));
    }
}
