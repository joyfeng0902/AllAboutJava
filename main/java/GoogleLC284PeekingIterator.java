package main.java;

import java.util.Iterator;

/**
 * Created by joyfeng on 10/18/2016.
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class GoogleLC284PeekingIterator implements Iterator<Integer> {
    boolean peeked; // the prev action is peek
    int prevVal;
    Iterator<Integer> peekIterator;
    public GoogleLC284PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        peeked = false;
        prevVal = 0;
        peekIterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!peeked) {
            peeked = true;
            prevVal = peekIterator.next();
        }
        return prevVal;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    //@Override
    public Integer next() {
        if (peeked) {
            peeked = false;
            return prevVal;
        } else {
            return peekIterator.next();
        }
    }

    //@Override
    public boolean hasNext() {
        return peekIterator.hasNext() || peeked;
    }

    //@Override
    public void remove() {

    }
}
