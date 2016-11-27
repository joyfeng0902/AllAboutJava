package main.java;

import java.util.*;

/**
 * Created by joyfeng on 11/24/2016.
 */
public class GoogleLC380InsertDeleteGetRandomO1 {
    // 此题的正确解法是利用到了一个一维数组和一个哈希表，
    // 其中数组用来保存数字，哈希表用来建立每个数字和其在数组中的位置之间的映射
    private List<Integer> dataList;
    private Map<Integer, Integer> map;
    private Random rand;
    /** Initialize your data structure here. */
    public GoogleLC380InsertDeleteGetRandomO1() {
        dataList = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();   // int to index in List
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            dataList.add(val);
            map.put(val, dataList.size()-1);
        }
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            // exchange with the last element in the list
            int index = map.remove(val);  // !! remove from the map
            int last = dataList.remove(dataList.size() - 1);   // remove the last element from the list
            if (last != val) {
                dataList.set(index, last);   // !! also have to insert into list and map
                map.put(last, index);
            }
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(dataList.size());
        return dataList.get(index);
    }
}
