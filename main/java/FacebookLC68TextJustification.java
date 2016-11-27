package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joyfeng on 11/14/2016.
 */
public class FacebookLC68TextJustification {
    // 1. for each line, k words, the length of k word + (k-1) space < maxWidth
    // 2. space = (maxWidth-the total length of words) / (k-1)
    // 3. For the last line of text, it should be left justified and no extra space is inserted between words.
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int n = words.length;
        int start = 0, end = 1;
        while (start < n) {
            int cumSpaces = 1;
            int wordLength = words[start].length();
            // calculate for each line
            while(end < n && cumSpaces + wordLength + words[end].length() <= maxWidth) {  // tentatively add the next word
                wordLength += words[end].length();
                cumSpaces++;
                end++;
            }

            // now we get the start and end for each line
            // if it is the last line
            if (end == n) {
                StringBuilder sb = new StringBuilder(maxWidth);
                sb.append(words[start]);
                for (int k = start+1; k < end; k++) {
                    sb.append(" " + words[k]);
                }
                int i = 0, currLen = sb.toString().length();
                while (i < maxWidth - currLen) {
                    sb.append(" ");
                    i++;
                }
                result.add(sb.toString());
                break;
            }

            if (end - start == 1) { // only 1 word
                StringBuilder sb = new StringBuilder(words[start]);
                int i = 0, currLen = sb.toString().length();
                while (i < maxWidth - currLen) {
                    sb.append(" ");
                    i++;
                }
                result.add(sb.toString());
            } else {  // more than 1 words
                int space = (maxWidth - wordLength) / (end - start - 1);
                int remains = maxWidth - wordLength - (end-start-1) * space;
                StringBuilder sb = new StringBuilder(words[start]);
                for (int k = start+1; k < end; k++) {
                    for (int l = 0; l < space; l++) {
                        sb.append(" ");
                    }
                    if (remains > 0) {
                        sb.append(" ");
                        remains--;
                    }
                    sb.append(words[k]);
                }
                result.add(sb.toString());
            }

            start = end;
            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        FacebookLC68TextJustification a = new FacebookLC68TextJustification();
        String[] words = new String[]{"a","b","c","d","e"};
        a.fullJustify(words, 3);
    }
}
