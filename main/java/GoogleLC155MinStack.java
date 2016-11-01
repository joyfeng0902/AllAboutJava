package main.java;

import java.util.Stack;

public class GoogleLC155MinStack {
    int[] arr;
    int top;       // pointer to the top of stack
    int currMin;   // maintain the current min
    Stack stack = new Stack();

    /** initialize your data structure here. */
    public GoogleLC155MinStack() {
        top = -1;
        currMin = 0;
    }

    public void push(int x) {
        arr[++top] = x;
        if (x < currMin) {
            currMin = x;   // update currMin
        }
        stack.push(currMin);   // stack always stores the min
    }

    public void pop() {
        int x = arr[top];
        top--;
        int y = (Integer)stack.pop();
        if (x == y) {
            currMin = (Integer)stack.peek();  // get the new min
        }
    }

    public int top() {
        if (isEmpty())
            return 0;
        return arr[top];
    }

    public int getMin() {
        return currMin;
    }

    public boolean isEmpty() {
        return (top == -1);
    }
    public static void main(String[] args) {
        GoogleLC155MinStack obj = new GoogleLC155MinStack();
        obj.push(4);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}
