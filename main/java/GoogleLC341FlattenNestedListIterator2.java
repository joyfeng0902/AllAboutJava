package main.java;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by joyfeng on 11/22/2016.
 */
public class GoogleLC341FlattenNestedListIterator2 {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
   public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    // 虽说迭代器是要用迭代的方法，但是我们可以强行使用递归来解，怎么个强行法呢，
    // 就是我们使用一个队列queue，在构造函数的时候就利用迭代的方法把这个嵌套链表全部压平展开，
    // 然后在调用hasNext()和next()就很简单了
    Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
    public GoogleLC341FlattenNestedListIterator2(List<NestedInteger> nestedList) {
        makeQueue(nestedList);
    }

    void makeQueue(List<NestedInteger> nestedList) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                queue.offer(n);
            } else {
                makeQueue(n.getList());
            }
        }
    }

    //@Override
    public Integer next() {
        return queue.poll().getInteger();
    }

    //@Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
