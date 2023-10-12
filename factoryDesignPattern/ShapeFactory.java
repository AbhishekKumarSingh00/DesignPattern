package factoryDesignPattern;

public class ShapeFactory {

    Shape getShape(String input) {
        //see code happens to code after removing warning
        switch (input) {
            case "CIRCLE":
                return new Circle();

            case "Rectangle":
                return new Rectangle();

            default:
                return null;
        }
    }

}
