package test;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        showTest();
//        int  a = test();
//        System.out.println(a);
    }

    private static void showTest() {
        ReadFile readFile = new ReadFile();
        try {
            readFile.read("");
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    private static int test(){
        int[] counts = new int[]{5,3};
        int count = counts[0];

        try {
            int error = counts[2];
            count++;
            return count;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("catch 语句执行" + count);
            return count;

        }finally {
            count++;
            System.out.println("finally 语句执行" + count);
            return count;
        }
    }
}
