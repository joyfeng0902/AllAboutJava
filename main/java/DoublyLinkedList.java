package main.java;

// https://www.java2novice.com/data-structures-in-java/linked-list/doubly-linked-list/
public class DoublyLinkedList {
    private DoubleNode head;
    private DoubleNode tail;
    int size;

    public boolean isEmpty() {
        return size == 0; // this.head == null;
    }
    public DoublyLinkedList() {
        size = 0;
    }
    public int size() { return size; }
    private class DoubleNode {
        int data;
        DoubleNode next;
        DoubleNode prev;

        public DoubleNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
        public DoubleNode(int data, DoubleNode prev, DoubleNode next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * adds element at the starting of the linked list
     */
    void addFirst(int newData) {
        DoubleNode newNode = new DoubleNode(newData);
        if (this.head != null) {  // not empty
            head.prev = newNode;
        }
        this.head = newNode;
        if (this.tail == null) {
            tail = newNode;
        }
        size++;
        System.out.println("adding: " + newData);
    }

    public void displayList() {
        DoubleNode node = this.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
