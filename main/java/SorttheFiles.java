package main;

import java.util.ArrayList;
import java.util.List;

/*
Imagine that you have a set of N image files, which are numbered from 1 to N like that: IMG1.jpg, IMG2.jpg, IMG3.jpg, and so on.

If sorted by name the order could start to look incorrect if there are at least 10 files:

IMG1.jpg
IMG10.jpg
IMG11.jpg
IMG12.jpg
…
Your task is given N to return the sorted lexicographically list of file names. N is in the range [1, 1,000,000].
In 40% of the test cases N will be no higher than 1,000. If N if higher than 1,000 return just the first 1,000 file names.
*/
public class SorttheFiles {
    List<String> sortFiles(int N) {
        List<String> files = new ArrayList<String>();
        for (int i = 1; i < 10; i++) {
            helper(N, i, files);
        }

        return files;
    }

    private void helper(int N, int fileNum, List<String> files) {
        if (files.size() == 1000 || fileNum > N) {
            return;
        } else {
            files.add("IMG" + fileNum + ".jpg");
        }
        for (int digit = 0; digit <= 9; digit++) {
            helper(N, fileNum * 10 + digit, files);
        }
    }

    void printAll(List<String> files) {
        for (String s : files) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        SorttheFiles s = new SorttheFiles();
        s.printAll(s.sortFiles(16));
    }
}
