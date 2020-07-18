package d_singleton;

/**
 * 饿汉式、懒汉式、双重检查加锁式都存在相应的缺点，而通过内部类的方式避免了它们的缺点。
 *
 * 内部类创建单例更加优秀的原理：
 *
 * 1. 静态内部类和类成员变量，不会持有外部类的引用；
 * 2. 静态内部类内部可以定义静态方法；
 * 3. 静态内部类相当于类的成员，只会在第一次使用时，才会被加载(重要)；
 * 4. 静态内部类保证了线程安全
 */

public class InnerClassSingleton {

    private static class SingletonHolder {
        static {
            System.out.println("测出静态内部类的加载时机:静态代码块");
        }

        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {

    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.instance;
    }


    public static void main(String[] args) {
        System.out.println("开始创建单例");
        // 通过注释改行代码，可以验证静态内部类只会在第一次使用时才会加载
        InnerClassSingleton.getInstance();
    }
}
