package d_singleton;

/**
 * 1. 枚举类默认是 final 的，构造函数为 private
 * 2. 枚举的实例系统会默认添加 static final 修饰符
 */

public enum  EnumSingleton {
    singletonInstance;

    private int time;

    public int getTime(){
        return time;
    }

    public void function(){

    }
}
