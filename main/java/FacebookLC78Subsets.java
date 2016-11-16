package main;

import java.util.ArrayList;
import java.util.List;

public class FacebookLC78Subsets {
    //    本解法采用回溯算法实现，回溯算法的基本形式是“递归+循环”，正因为循环中嵌套着递归，递归中包含循环
    //    原数组中的每个元素有两种状态：存在和不存在。
    //    ① 外层循环逐一往中间集合 temp 中加入元素 nums[i]，使这个元素处于存在状态
    //    ② 开始递归，递归中携带加入新元素的 temp，并且下一次循环的起始是 i 元素的下一个，因而递归中更新 i 值为 i + 1
    //    ③ 将这个从中间集合 temp 中移除，使该元素处于不存在状态
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        helper(nums, result, new ArrayList<Integer>(), 0);

        return result;
    }

    void helper(int[] nums, List<List<Integer>> result, List<Integer> tmp, int start) {
        result.add(new ArrayList<Integer>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);  //① 加入 nums[i]
            helper(nums, result, tmp, i+1);    //② 递归
            tmp.remove(tmp.size()-1);   //③ 移除 nums[i]
        }
    }

    public List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());       // empty set
        for (int num : nums) {           // get each num iteratively
            // iterate result
            int size = result.size();   // result.size() can change as elements are added
            for (int i = 0; i < size; i++) {
                List<Integer> tmp = new ArrayList<Integer>(result.get(i));   // a new copy
                // List<Integer> tmp = result.get(i);     // this would cause problems as new elements are added
                tmp.add(num);
                result.add(tmp);
            }

        }
        return result;
    }
}
