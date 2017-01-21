package main.java;

/**
 * Created by joyfeng on 11/28/2016.
 */
public class FacebookLC157ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        if (buf == null || n <= 0) {
            return 0;
        }
        int index = 0;
        char[] temp = new char[4];

        while (index < n) {
            int c = read4(temp);
            for (int i = 0; i < c && index < n;) {
                buf[index++] = temp[i++];
            }
            if (c < 4) {
                break;
            }
        }

        return index;  // return index not n, becasue n can be any number, but we need to return how many chars read.
    }

    int read4(char[] buf) {
        return  0;
    }
}
