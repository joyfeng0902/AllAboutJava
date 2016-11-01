package main.java;

// Write a method to replace all spaces in a string with ‘%20’
public class ReplaceSpaceInString {
    // get the number of spaces in a string
    private static char[] replaceSpaceInStr(char[] str) {
        int numOfSpace = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                numOfSpace++;
            }
        }

        // increase the size of the array
        int newLength = str.length + 2* numOfSpace;
        char[] newStr = new char[newLength];
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') {
                newStr[p++] = str[i];
            } else {
                newStr[p++] = '%';
                newStr[p++] = '2';
                newStr[p++] = '0';
            }
        }

        return newStr;
    }

    public static void main(String[] args) {
        char[] arrs = new char[]{'a','b','c','d',' ','e','f','g',' ','h',' ','j'};
        System.out.println(replaceSpaceInStr(arrs));

        arrs = new char[]{' ',' ','e'};
        System.out.println(replaceSpaceInStr(arrs));
    }
}
