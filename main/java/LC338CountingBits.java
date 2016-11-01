package main.java;

/**
 * Created by joyfeng on 10/14/2016.
 */
public class LC338CountingBits {
    public int[] countBits(int num) {
        // 一个数的二进制形式除去最后一位外，
        // 其余位包含1的总数=其一半对应的二进制形式中1的总数
        // 最后一位是不是1，可以用i %１　判断
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <=num; i++) {
            result[i] = result[i >> 1] + (i&1);
        }
        return result;
    }
}
