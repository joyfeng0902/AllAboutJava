package main.java;

import java.util.EmptyStackException;

public class Stack {
    private int maxSize;
    private int[] elements;
    private int top;

    public Stack(int n){         // public constructor
        // create an array of Object and cast it to the generic array type
        elements = new int[n];
        maxSize = n;
        top = -1;
    }

    public void push(int e) {
        elements[++top] = e;
    }

    public int pop() {
        if (top == -1)
            throw new EmptyStackException();
        return elements[top--];
    }

    public int top() {
       if (top == -1)
           throw new EmptyStackException();
        return elements[top];
    }

    public int popBottom() {
        if (top == -1)
            throw new EmptyStackException();
        int result = elements[0];
        for (int i = 0; i < elements.length - 1; i++) {
            elements[i] = elements[i+1];
        }
        elements[elements.length-1] = 0;
        return result;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void printStack(){
        for (int i = 0; i <= top; i++) {
            System.out.println(elements[i] + " ");
        }
        System.out.println("[OUT]");
    }
}
