package four;

/**
 * 对懒汉式获取单例的方式进行线程安全的优化，饿汉式为线程安全(JVM 保证了其只会被加载一遍，创建一个实例对象)
 */


public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){}
      // one: 懒汉式
    public static ThreadSafeSingleton getInstanceOne(){
        // 在此处存在多个线程访问的情况，从而产生了多个实例变量，所以要对该方法进行线程安全的优化
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return  instance;
    }

    // two: 对该方法添加 synchronized 关键字，会保证线程安全，但是这样会降低访问性能，而且每次访问都会判空，
    public static synchronized ThreadSafeSingleton getInstanceTwo(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return  instance;
    }


    // 使用 volatile 关键字，将实例变量存储在共享内存中，对于多个线程是可见的
    // 但是使用 volatile 可能会屏蔽 JVM 中的代码优化，运行效率不是很高。
    private static volatile ThreadSafeSingleton instanceForReal;

    public static ThreadSafeSingleton getInstance(){
        if(instanceForReal == null){// 1
            synchronized (ThreadSafeSingleton.class){
                // 在此处再次对 instanceForReal 进行判空的原因： 由于 getInstance 为线程不安全的，所以可能有多个线程同时进入到 1 的内部
                // 假设不再此处判空，那么多个线程会依次进入同步代码块，创建实例对象，结果产生了多个实例对象，基于此，需要在此处再次判空。
                if (instanceForReal == null){
                    instanceForReal = new ThreadSafeSingleton();
                }
            }
        }
        return  instanceForReal;
    }


}
