package main.java;

// implement 2 stacks in a single array
public class TwoStacks {
    int size;
    int[] arr;
    int top1, top2;  // top elements of stack

    // constructor
    TwoStacks(int n) {
        arr = new int[n];
        size = n;
        top1 = -1;
        top2 = size;
    }

    // method to push elements to stack1
    void push1(int x) {
        // at least 1 empty space
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
        } else {
            System.out.println("Overflow");
            System.exit(1);
        }
    }

    // method to push elements to stack2
    void push2(int x) {
        if(top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
        } else {
            System.out.println("Overflow");
            System.exit(1);
        }
    }

    // method to pop element from stack1
    int pop1() {
        if(top1 > 0) {
            int x = arr[top1];
            top1--;
            return x;
        } else {
            System.out.println("System underflow");
            System.exit(1);
        }
        return 0;
    }

    // method to pop elment from stack2
    int pop2() {
        if(top2 < size) {
            int x = arr[top2];
            top2++;
            return x;
        } else {
            System.out.println("System underflow");
            System.exit(1);
        }
        return 0;
    }

    public static void main(String[] args) {
        TwoStacks ts = new TwoStacks(5);
        ts.push1(2);
        ts.push2(4);
        ts.push2(9);
        ts.push1(8);
        ts.push1(7);
        //ts.push2(3);

        System.out.println(ts.pop2());
        ts.push2(3);
        System.out.println(ts.pop1());
        System.out.println(ts.pop2());
    }
}
