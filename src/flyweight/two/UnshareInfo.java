package flyweight.two;

/**
 * 非共享部分
 */
public class UnshareInfo {

    private int x;
    private int y;
    private int radius;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


    @Override
    public String toString() {
        return "UnshareInfo{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}
