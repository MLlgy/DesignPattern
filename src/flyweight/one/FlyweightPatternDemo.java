package flyweight.one;

/**
 * 享元模式
 */
public class FlyweightPatternDemo {

    private static String[] colors = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            Circle circle = (Circle) ShapeFactory.getShape(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(50);
            circle.draw();
        }
        System.out.println("创建 Circle 个数：" + ShapeFactory.getCirclesNum());
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}
