package main.java;

import java.util.TreeSet;

/**
 * Created by liaomiao on 10/24/2016.
 */
class DogC implements Comparable<DogC>{
    int size;
    DogC(int s) {
       size = s;
    }
    @Override
    public int compareTo(DogC o) {
        return o.size - this.size;
    }
}
public class ComparableExample {
    public static void main(String[] args) {
        TreeSet<DogC> d = new TreeSet<DogC>();
        d.add(new DogC(1));
        d.add(new DogC(3));
        d.add(new DogC(2));
        d.add(new DogC(4));
        d.add(new DogC(1));
        for(DogC dog : d) {
            System.out.println(dog.size);
        }
    }
}
