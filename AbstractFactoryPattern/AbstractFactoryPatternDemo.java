package AbstractFactoryPattern;

// Use the FactoryProducer to get AbstractFactory in order
// to get factories of concrete classes by passing an information such as type.
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // get Shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        //get an object of Shape Circle
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        //get an object of Shape Rectangle
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        //get an object of Shape Square
        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();

        // get Color factory
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        //get an object of Color Red
        Color color1 = colorFactory.getColor("RED");
        color1.fill();

        //get an object of Color Green
        Color color2 = colorFactory.getColor("GREEN");
        color2.fill();

        //get an object of Color Blue
        Color color3 = colorFactory.getColor("BLUE");
        color3.fill();
    }
}
