package flyweight.two;

import java.util.HashMap;

/**
 * 享元工厂
 */
public class ShareFactory {

    private HashMap<String, Shape> shapeHashMap = new HashMap<>();

    public Shape getShape(String color) {
        Shape shape = shapeHashMap.get(color);
        if (shape != null) {
            System.out.println("具体享元" + shape + "已经存在，被成功获取！");
        } else {
            shape = new ShareInfo(color);
            shapeHashMap.put(color, shape);
        }
        return shape;
    }


    public int getNum(){
        return shapeHashMap.size();
    }
}
