package main.java;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

// Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
// Therefore, in real life, we would likely start a new stack when the previous stack
// exceeds some threshold. Implement a data structure SetOfStacks that mimics this.
// SetOfStacks should be composed of several stacks, and should create a new stack once
// the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave
// identically to a single stack (that is, pop() should return the same values as it would
// if there were just a single stack).
//
// FOLLOW UP
//
// Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
public class StackOfStacks {
    // maintain a list of Stack; each has a fixed capacity
    List<Stack> stacks = new ArrayList<Stack>();      // list of stacks
    int capacity;                                 // the fixed capacity each stack can have

    Stack getTheLastStack() {
        if (stacks != null && stacks.size() > 0) {
            return stacks.get(stacks.size() - 1);
        }
        return null;
    }

    // push to the last Stack; if full or null, create a new Stack, push, and add the stack to the StackList
    void push(int x) {
        Stack theLastStack = getTheLastStack();
        if (theLastStack == null || theLastStack.isFull()) {      // remember to check if it is full
            Stack newStack = new Stack(capacity);
            newStack.push(x);
            // remember to add the new stack to stacks
            stacks.add(newStack);
        } else {
            theLastStack.push(x);
        }
    }

    // pop the element from the last Stack
    // if after pop, the stack is empty, then remove it from the stack list
    int pop() {
        Stack theLastStack = getTheLastStack();
        if (theLastStack == null) {          // that means stacks is empty or null
            throw new EmptyStackException();  // not throws
        }
        int x = theLastStack.pop();
        // need to check if stack is empty now, if so remove it from stacks
        if (theLastStack.isEmpty()) {
            stacks.remove(theLastStack);
        }
        return x;
    }

    // size == 0 or the last stack is empty
    boolean isEmpty() {
        Stack theLastStack = getTheLastStack();
        if(theLastStack == null || theLastStack.isEmpty()) {
            return true;
        }
        return false;
    }

    // Implement a function popAt(int index)
    // which performs a pop operation on a specific sub-stack.
    int popAt(int index) {
        if (stacks.isEmpty()) {
            throw new IllegalStateException("Stacks is empty. ");
        }

        if (index < 0 || index > stacks.size() - 1) {
            throw new IllegalArgumentException("Index is invalid. ");
        }

        Stack stackAtIndex = stacks.get(index);
        int rtn = stackAtIndex.pop();

        // Rebalance stacks
        // if after pop the stack is empty, remove it
        if (stackAtIndex.isEmpty()) {
            // it happens when only 1 element in each stack
            stacks.remove(stackAtIndex);
        } else {
            // move the bottom of the next stack to the top of the previous one,
            // one by one until you reach the end of the stack list
            for (int i = index; i < stacks.size() - 1; i++) {
                Stack currStack = stacks.get(i);
                Stack nextStack = stacks.get(i + 1);

                currStack.push(nextStack.popBottom());
            }
            // if after pop, the last stack is empty, remove it
            if (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
                stacks.remove(stacks.size() - 1);
            }
        }

        return rtn;
    }

    void printStack() {
        for (Stack s : stacks) {
            s.printStack();
            System.out.println("[TOP]");
        }
    }

    public static void main(String[] args) {
        StackOfStacks ss = new StackOfStacks();
        ss.capacity = 2;
        int i = 1;
        while(i < 11) {
            ss.push(i++);
        }
        ss.printStack();
        ss.pop();
        ss.printStack();
        ss.push(11);
        ss.printStack();

        System.out.println(ss.popAt(3));
        ss.printStack();
    }
}
