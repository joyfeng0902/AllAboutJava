package AbstractFactoryPattern;

// concrete classes implementing the same interface.
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.print("Inside Circle::draw() method.");
    }
}