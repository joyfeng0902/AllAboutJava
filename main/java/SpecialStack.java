package main.java;

// Design a Data Structure SpecialStack that supports all the stack operations
// like push(), pop(), isEmpty(), isFull() and an additional operation getMin()
// which should return minimum element from the SpecialStack. All these operations
// of SpecialStack must be O(1). To implement SpecialStack, you should only use
// standard Stack data structure and no other data structure like arrays, list, .. etc.
public class SpecialStack {
    int max = 100;
    int[] arr;
    int top;
    int currentMin;
    Stack stack = new Stack(6);

    SpecialStack(int n) {
        arr = new int[n];
        top = -1;
        currentMin = 0;
    }

    void push(int x) {
        if(isFull()) {
            System.out.println("Stack full");
        } else {
            top++;
            arr[top] = x;
            if (stack.isEmpty()) {
                stack.push(x);
                currentMin = x;
            } else {
                int y = stack.pop();
                stack.push(y); // pop and then push
                if(x <= y) {
                    stack.push(x);
                    currentMin = x;
                } else {
                    stack.push(y);
                    currentMin = y;
                }
            }
        }
    }

    int pop() {
        int x = 0;
        if(isEmpty()) {
            System.out.println("Stack empty");
        } else {
            x = arr[top];
            top--;
        }
        int y = stack.pop();;
        if (y == currentMin) {
            currentMin = stack.pop();
        }
        return x;
    }

    boolean isFull() {
        if(top >= max - 1) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if(top == -1) {
            return true;
        }
        return false;
    }

    int getMin() {
        return currentMin;
    }

    public static void main(String[] args) {
        SpecialStack ss = new SpecialStack(4);
        ss.push(3);
        ss.push(4);
        ss.push(5);
        System.out.println(ss.getMin());
        ss.push(1);
        System.out.println(ss.getMin());
        ss.pop();
        System.out.println(ss.getMin());

    }
}
