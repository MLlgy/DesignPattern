package test;

import java.util.Random;

public class ThreadLocalTest {

    private static ThreadLocal<Data> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            int num = new Random().nextInt();
            System.out.println("Thread name is " + Thread.currentThread().getName() + " 生成的 num 是: " + num);
            new Thread(() -> {
                Data data = new Data();
                data.setAge(num);
                data.setName("name:" + num);

                Data data1 = new Data();
                data1.setAge(num);
                data1.setName("Data1 name:" + num);
                threadLocal.set(data1);

                showMess();
            }).start();
        }

    }

    private static void showMess() {
        Data data = threadLocal.get();
        System.out.println("thread name is :" + Thread.currentThread().getName()
                + ". the message is : name is " + data.getName() + ", age is  " + data.getAge());
    }


    static class Data {

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


    class User {

        private User() {
        }


    }
}
