package main;

import java.util.HashMap;
import java.util.Map;

public class GoogleLC388LongestAbsoluteFilePath {
    // lastIndexOf, if does not exist return -1
    // if map.put(1,"a"), map.put(1,"b"), then map.get(1) == "b"
    public int lengthLongestPath(String input) {
        // ? how to know if it is file or dir?  check if path contains "."
        //        "dir\n\tsubdir1\n\tsubdir22\n\t\tfile.ext" is parsed as:
        //        dir
        //        \tsubdir1
        //        \tsubdir22
        //        \t\tfile.ext
        //        We use the number of "\t" to mark its level:
        //        level 0: dir
        //        level 1: \tsubdir1
        //        level 1: \tsubdir2
        //        level 2: \t\tfile.ext
        //
        //        Use a Map to store the total length of each level and its parent levels
        //        for example:
        //        0, length of "dir"+1 ("/")
        //        1, map.get(0)+ length of "subdir1" +1
        //        1, map.get(0)+ length of "subdir22" +1  replace the previous one with the same key
        //        now it is a file, get the total length of its parent level+file length
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        String[] splits = input.split("\n");
        for (String s : splits) {
            int level = s.lastIndexOf("\t") + 1;      // the index of "\" in "\t" from the end
            int len = s.substring(level).length();        // if "\t" does not exist, return -1.
            if (s.contains(".")) {
                // get the length and compare to get the longest one so far
                res = Math.max(res, map.get(level) + len);
            } else {
                map.put(level+1, map.get(level) + len + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GoogleLC388LongestAbsoluteFilePath g = new GoogleLC388LongestAbsoluteFilePath();
        System.out.println(g.lengthLongestPath("dir\n\tsubdir1\n\tsubdir22\n\t\tfile.ext"));
    }
}
