package main.java;

/**
 * Created by joyfeng on 10/25/2016.
 */
interface Attack {
    public void move();
    public void attack();
}
// different kinds of attack can be defined by implementing Attack interface.
class AttackImpl implements Attack {
    private String move;
    private String attack;

    public AttackImpl(String move, String attack) {
        this.move = move;
        this.attack = attack;
    }

    @Override
    public void move() {
        System.out.println(move);
    }

    @Override
    public void attack() {
        move();
        System.out.println(attack);
    }
}

class Insect {
    private int size;
    private String color;

    public Insect(int size, String color) {
        size = size;
        color = color;
    }
}

// bee is an insect, and it can attack
class Bee extends Insect implements Attack{
    private Attack attack;

    Bee(int size, String color, Attack attack) {
        super(size, color);
        this.attack = attack;
    }

    public void move() {
        attack.move();
    }

    public void attack() {
        attack.attack();
    }
}
public class CompositionVSInheritance {
    public static void main(String[] args) {
        Bee a = new Bee(1, "black", new AttackImpl("fly", "move"));
        a.attack();
        Bee b = new Bee(3, "yellow", new AttackImpl("fly", "sting"));
        b.attack();
    }
}
