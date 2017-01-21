package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC170TwoSumIIIDatastructuredesign {
    // maintaining a list with distinct elements
    private List<Integer> list = new ArrayList<Integer>();
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number)+1);
        } else {
            map.put(number, 1);
            list.add(number);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int num1 : list) {
            int num2 = value - num1;
            if ((num1 == num2 && map.get(num2) > 1) || (num1 != num2 && map.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }
}
