package FactoryPattern;

// Use the Factory to get object of concrete class by passing an information such as type.
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        FactoryPattern.Shape shape1 = shapeFactory.getShape("CIRCLE");
        //call draw method of Circle
        shape1.draw();

        FactoryPattern.Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();

        FactoryPattern.Shape shape3 = shapeFactory.getShape("RECTANGLE");
        shape3.draw();
    }

}