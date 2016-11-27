package main.java;

/**
 * http://www.jianshu.com/p/9f48f058df1a
 * 举个例子: 11+5, 其二进制形式为11: 1011, 5: 0101

 那么两个位置都为1的地方就需要进位, 所以进位值就为0001. 原位置两个数相加的结果为那个位置值的异或即1110, 即两个位置值如果不一样就为1, 一样的话要么两个位置原来值都为0结果也为0, 要么进位, 那么结果依然是0.

 接下来就要把进位位和下一位相加, 所以进位值左移一位,即0001变为0010, 重复上面操作可得新的进位值为0010, 原位置异或(即相加)结果为1100.

 继续重复上面操作直到进位为0, 可得到最终结果10000, 即16

 文／Fluxay（简书作者）
 原文链接：http://www.jianshu.com/p/9f48f058df1a
 著作权归作者所有，转载请联系作者获得授权，并标注“简书作者”。
 */
public class LC371SumofTwoIntegers {
    public int getSum(int a, int b) {
        int c = a ^ b; // 按位加
        int carry = (a & b) << 1; // 计算进位
        if (carry != 0) {
            return getSum(c, carry);
        }
        return c;
    }
}
