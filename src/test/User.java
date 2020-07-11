package test;

public class User {
    private static ThreadLocal<User> threadLocal = new ThreadLocal<>();

    private User() {
    }

    private static User getInstance() {
        User instance = threadLocal.get();
        if (instance == null) {
            instance = new User();
            threadLocal.set(instance);
        }
        return instance;
    }

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
