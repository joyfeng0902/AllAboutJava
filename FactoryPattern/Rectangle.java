package FactoryPattern;

// concrete classes implementing the same interface.
public class Rectangle implements FactoryPattern.Shape {

    @Override
    public void draw() {
        System.out.print("Inside Rectangle::draw() method.");
    }
}