package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joyfeng on 10/27/2016.
 */
public class GoogleLC271EncodeandDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("/");
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    // indexOf(String str, int fromIndex): Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
        int start = 0;
        while(start < s.length()) {
            int index = s.indexOf("/", start);
            Integer length = Integer.parseInt(s.substring(start, index));
            result.add(s.substring(index+1, index+1+length));
            start = index+length+1;  // update start for the next string
        }

        return result;
    }

    public static void main(String[] args) {
        GoogleLC271EncodeandDecodeStrings codec = new GoogleLC271EncodeandDecodeStrings();
        List<String> strs = new ArrayList<String>();
        strs.add("");
        System.out.println(codec.decode(codec.encode(strs)));
    }
}
