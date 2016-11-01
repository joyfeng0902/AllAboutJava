package main.java;

import java.util.Queue;
import java.util.LinkedList;

class MyStack {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = q1.size();
        for (int i = 0; i < size - 1; i++) {
            q2.add(q1.poll());
        }

        q1.poll();
        Queue tmp = q2;
        q2 = q1;
        q1 = tmp;
    }

    // Get the top element.
    public int top() {
        int size = q1.size();
        for (int i = 0; i < size - 1; i++) {
            q2.add(q1.poll());
        }

        int y = q1.peek();
        q2.add(q1.poll());
        Queue tmp = q2;
        q2 = q1;
        q1 = tmp;
        return y;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.pop();
        System.out.println(stack.top());
    }
}