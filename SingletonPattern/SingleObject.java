package SingletonPattern;

// This pattern involves a single class which is responsible to create an object
// while making sure that only single object gets created. This class provides a way
// to access its only object which can be accessed directly without need to instantiate the object of the class.
public class SingleObject {
    // SingleObject class have its constructor as private and have a static instance of itself.
    // SingleObject class provides a static method to get its static instance to outside world.

    private static SingleObject instance = new SingleObject();

    // make the constructor private so that it cannot be instantiated.
    private SingleObject(){}

    //Get the only object available
    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("hello world");
    }
}
