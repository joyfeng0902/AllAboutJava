package AbstractFactoryPattern;

// concrete classes implementing the same interface.
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.print("Inside Rectangle::draw() method.");
    }
}