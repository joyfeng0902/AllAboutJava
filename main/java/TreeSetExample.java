package main.java;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by joyfeng on 10/25/2016.
 */
public class TreeSetExample {
    // TreeSet is sorted
    // how to iterate a TreeSet
    // how to check empty
    // how to retrieve first/last element
    // how to remove an element
    public static void main(String[] args) {
        System.out.println("TreeSet Example");
        TreeSet<Integer> tree = new TreeSet<Integer>();
        tree.add(12);
        tree.add(63);
        tree.add(34);
        tree.add(45);

        Iterator<Integer> iterator = tree.iterator();
        System.out.print("Tree Set data: ");
        // Displaying the TreeSet data
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Check empty or not
        if (tree.isEmpty()) {
            System.out.println("TreeSet is empty. ");
        } else {
            System.out.println("TreeSet size is " + tree.size());
        }

        // Retrieve first data from tree set
        System.out.println("First data: " + tree.first());

        // Retrieve last data from tree set
        System.out.println("First data: " + tree.last());

        if (tree.remove(45)) {   // remove element by value
            System.out.println("Data is removed from treeset. ");
        } else {
            System.out.println("Data doesn't exist. ");
        }
        System.out.println("Now the tree sset contains: ");
        iterator = tree.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Remove all
        tree.clear();
        if (tree.isEmpty()) {
            System.out.println("Tree set is empty. ");
        } else {
            System.out.println("Tree set size: " + tree.size());
        }
    }
}
