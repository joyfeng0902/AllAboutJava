package main.java;

/**
 * Created by joyfeng on 12/27/2016.
 */
public class LC201BitwiseANDofNumbersRange {
    // 建立一个32位都是1的mask，然后每次向左移一位，比较m和n是否相同，不同再继续左移一位，直至相同，然后把m和mask相与就是最终结果
    public int rangeBitwiseAnd(int m, int n) {
        int bit = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            bit++;
        }
        return m<<bit;
    }
}
