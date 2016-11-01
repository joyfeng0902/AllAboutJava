package main.java;

/**
 * Created by liaomiao on 10/24/2016.
 */
class Room<T> {
    // if use Object instead of T, if a user accidentally add "60", compiler does not know it is a problem.
    // When the program is run, will get ClassCastException
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
public class GenericsExample {
    public static void main(String[] args) {
        Room<Integer> room1 = new Room<Integer>();
        room1.add(60);

        System.out.println(room1.get()); // do not need to cast the result any more from room1.get() since compile knows get() will return an Integer

        Room<String> room2 = new Room<String>();
        room2.add("hello");
        //room2.add(60);  // compile-time error

        System.out.println(room2.get());
    }
}

