package main.java;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by joyfeng on 11/22/2016.
 */
public class GoogleLC341FlattenNestedListIterator implements Iterator<Integer> {
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

    // 由于栈的后进先出的特性，我们在对向量遍历的时候，从后往前把对象压入栈中，
    // 那么第一个对象最后压入栈就会第一个取出来处理，我们的hasNext()函数需要遍历栈，
    // 并进行处理，如果栈顶元素是整数，直接返回true，如果不是，那么移除栈顶元素，
    // 并开始遍历这个取出的list，还是从后往前压入栈，循环停止条件是栈为空，返回false
    Stack<NestedInteger> stack = new Stack<NestedInteger>();
    public GoogleLC341FlattenNestedListIterator(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return;
        }
        for (int i = nestedList.size()-1; i >=0 ; i++) {
            stack.push(nestedList.get(i));
        }
    }

    //@Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    //@Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger top = stack.peek();
            if (top.isInteger()) {
                return true;
            } else {
                stack.pop();
                for (int i = top.getList().size()-1; i >= 0; i--) {
                    stack.push(top.getList().get(i));
                }
            }
        }

        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
