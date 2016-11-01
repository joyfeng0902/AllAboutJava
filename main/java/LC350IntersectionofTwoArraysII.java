package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joyfeng on 10/3/2016.
 */
public class LC350IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res=new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // make sure nums1's size is always larger than nnums2's
        if (nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        // using 2 pointers
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[res.size()];
        int t = 0;
        for (int n : res) {
            result[t++] = n;
        }

        return result;
    }

    public static void main(String[] args) {
        LC350IntersectionofTwoArraysII l = new LC350IntersectionofTwoArraysII();
        l.intersect(new int[]{1}, new int[]{1});
    }
}
