package four;


/**
 * 饿汉式是线程安全的，但是因为在类加载时就会创建实例变量，所以存在其他类没有引用该实例的情况，那么就白白占用了内存。
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
