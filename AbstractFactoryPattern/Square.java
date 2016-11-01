package AbstractFactoryPattern;

// concrete classes implementing the same interface.
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.print("Inside Square::draw() method.");
    }
}