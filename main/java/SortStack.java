package main.java;

public class SortStack {
    // Write a program to sort a stack in ascending order. You should not make any assumptions about how the stack
    // is implemented. The following are the only functions that should be used to write this program:
    // push | pop | peek | isEmpty.
    // top: Returns value of the top element.

    // use the idea of insertion sort
    static Stack sortStack(Stack s) {
        Stack t = new Stack(20);
        while (!s.isEmpty()) {   // do this for all lemenets in s
            int n = s.top();
            s.pop();

            while (!t.isEmpty() && t.top() > n) {
                s.push(t.pop());    // pop from t until reach an element <= n
            }
            t.push(n);
        }

        return t;   // return the new stack
    }

    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(-1);
        s.push(12);
        s.push(3);
        s.push(6);
        s.push(-4);
        s.printStack();

        s = sortStack(s);
        s.printStack();
    }
}
