package main.java;

import java.util.HashSet;
import java.util.Set;

public class AirbnbLC217ContainsDuplicate {
    // method 1:first sort and then compare adj nums
    // method 2: using Set
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int x: nums) {
            if (!set.add(x)) return true;
        }
        return false;
    }

}
