package AbstractFactoryPattern;

// Create concrete classes implementing the same interface.
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
