package flyweight.one;

import java.util.HashMap;

/**
 * 获得 Circle 的工厂类
 */
public class ShapeFactory {

    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getShape(String color) {
        Circle circle = (Circle) circleMap.get(color);
        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }

    public static int getCirclesNum() {
        return circleMap.size();
    }
}
