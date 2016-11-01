package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * Unique Word Abbreviation
 An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 a) it                      --> it    (no abbreviation)

      1
 b) d|o|g                   --> d1g

          1    1  1
 1---5----0----5--8
 c) i|nternationalizatio|n  --> i18n

          1
 1---5----0
 d) l|ocalizatio|n          --> l10n
 Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 Example:
 Given dictionary = [ "deer", "door", "cake", "card" ]

 isUnique("dear") -> false
 isUnique("cart") -> true
 isUnique("cane") -> false
 isUnique("make") -> true
 */
public class GoogleLC288UniqueWordAbbreviation {
    Map<String, Set<String>> map = new HashMap<String, Set<String>>();  // abbrv - > set of words with the abbrv
    public GoogleLC288UniqueWordAbbreviation(String[] dictionary) {
        for (String s : dictionary) {
            String abbrv = s;
            if (s.length() > 2) {
                abbrv = s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
            }
            if (map.containsKey(abbrv)) {
                map.get(abbrv).add(s);
            } else {
                Set<String> set = new HashSet<String>();
                set.add(s);
                map.put(abbrv, set);
            }
        }
    }

    public boolean isUnique(String word) {
        String s = word;
        if (s.length() > 2) {
            s = word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length()-1);
        }

        return !map.containsKey(s) || (map.get(s).contains(word) && map.get(s).size() <= 1);  // word is the only string with the abbrv
    }

    static void print(boolean b) {
        System.out.println(b);
    }

    public static void main(String[] args) {
        String[] dictionary = new String[4];
        dictionary[0] = "deer";
        dictionary[1] = "door";
        dictionary[2] = "cake";
        dictionary[3] = "card";
        GoogleLC288UniqueWordAbbreviation vwa = new GoogleLC288UniqueWordAbbreviation(dictionary);
        print(vwa.isUnique("dear")); //  false
        print(vwa.isUnique("cart")); //  true
        print(vwa.isUnique("cane")); // false
        print(vwa.isUnique("make")); //true
    }
}