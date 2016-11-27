package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joyfeng on 11/6/2016.
 */
public class LC93RestoreIPAddresses {
    // 传统IP 地址的规律是分4个Part，每个Part是从0-255的数字
    // 0-255的数字，转换成字符，即每个Part 可能由一个字符组成，二个字符组成，或者是三个字符组成。那这又成为组合问题了，dfs便呼之欲出
    // 所以我们写一个For循环每一层从1个字符开始取一直到3个字符，再加一个isValid的函数来验证取的字符是否是合法数字，如果是合法的数字，我们再进行下一层递归，否则跳过。
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        dfs(s, result, "", 0);
        return result;
    }

    // s: the String to be processed
    // result
    // current: partial result (result so far)
    /// count: number of partitions
    void dfs(String s, List<String> result, String current, int count) {
        if (count == 3 && isValid(s)) {
            result.add(current + s);   // reached 4 counts, now return
            return;
        }

        for (int i = 1; i < 4 && i < s.length(); i++) {
            String subStr = s.substring(0, i);
            if (isValid(subStr)) {
                dfs(s.substring(i), result, current + subStr + ".", count+1);  // !! count+1 not count++, or count is always 0
            }
        }
    }

    // cannot have leading 0
    // cannot exceed 255
    boolean isValid(String ip) {
        if (ip.startsWith("0")) {
            return ip.equals("0");
        }
        int num = Integer.parseInt(ip);
        return num > 0 && num <= 255;
    }

    public static void main(String[] args) {
        LC93RestoreIPAddresses l = new LC93RestoreIPAddresses();
        l.restoreIpAddresses("0000");
    }
}
