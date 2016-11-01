package main.java;

public class Queue {
    // Implement Queue using Stacks
    Stack s1 = new Stack(10), s2 = new Stack(10);

    void enQueue(int x) {
        // only push to Stack1
        s1.push(x);
    }

    int deQueue() {
        // if Stack2 is empty, refill it by popping each element from Stack1 and pushing it onto Stack2
        // pop from STack2
        if (s2.isEmpty()) {
            while(! s1.isEmpty()) {   // do until s1 is empty
                s2.push(s1.pop());
            }
        }

        if (s2.isEmpty()) {
            throw new IllegalStateException("empty stacks");
        }
        int x = s2.pop();
        System.out.println(x);
        return x ;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.deQueue();
        q.enQueue(4);
        q.enQueue(5);
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
    }
}
