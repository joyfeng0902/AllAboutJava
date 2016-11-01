package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Arrays.sort():
 * generic - super
 * strategy pattern (run different Comparators at run time)
 * merge sort - nlg(n) time complexity
 * java.util.Collections#sort has similar ideas
 */

class Animal {
    int size;
    int weight;
}
class Dog extends Animal {
    Dog(int s) {
        size = s;
    }

    Dog(int s, int w) {
        size = s;
        weight = w;
    }
}
class Cat extends Animal {
    Cat(int w) {
        weight = w;
    }
}
class SizeComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        return a1.size - a2.size;
    }

    // in this way, all sub classes of ANimal can use this comparator
}
class WeightComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        return a1.weight - a2.weight;
    }
}
class CompartorExampleDog {
    public static void main(String[] args) {
        TreeSet<Dog> d = new TreeSet<Dog>(new SizeComparator() {
            @Override
            public int compare(Animal d1, Animal d2) {
                return d1.size - d2.size;
            }
        });
        d.add(new Dog(1));
        d.add(new Dog(3));
        d.add(new Dog(2));
        d.add(new Dog(4));
        d.add(new Dog(1));
        for(Dog dog : d) {
            System.out.println(dog.size);
        }

        Dog d1 = new Dog(2);
        Dog d2 = new Dog(1);
        Dog d3 = new Dog(3);

        Dog[] dogArray = {d1, d2, d3};
        printDogs(dogArray);
        Arrays.sort(dogArray, new SizeComparator());
        printDogs(dogArray);

        Dog dw1 = new Dog(2, 50);
        Dog dw2 = new Dog(1, 30);
        Dog dw3 = new Dog(3, 40);

        Dog[] dogArray2 = {dw1, dw2, dw3};
        printDogsWithWeight(dogArray2);

        Arrays.sort(dogArray2, new SizeComparator());
        printDogsWithWeight(dogArray2);
        Arrays.sort(dogArray2, new WeightComparator());
        printDogsWithWeight(dogArray2);

        Cat c1 = new Cat(20);
        Cat c2 = new Cat(10);
        Cat c3 = new Cat(30);

        Cat[] catArray = {c1, c2, c3};
        printCats(catArray);
        Arrays.sort(catArray, new WeightComparator());
        printCats(catArray);
    }

    public static void printDogs(Dog[] dogs) {
        for (Dog d: dogs) {
            System.out.print(d.size + " ");
        }
        System.out.println();
    }

    public static void printCats(Cat[] cats) {
        for (Cat c: cats) {
            System.out.print(c.weight + " ");
        }
        System.out.println();
    }

    public static void printDogsWithWeight(Dog[] dogs) {
        for (Dog d: dogs) {
            System.out.print("size=" + d.size + " weight=" + d.weight + " ");
        }
        System.out.println();
    }
}