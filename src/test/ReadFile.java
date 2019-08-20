package test;

import java.io.*;
import java.sql.SQLException;

public class ReadFile {
    public void read(String filename) throws Throwable {
        try {
            InputStream inputStream = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            Throwable throwable = new CustomFileExpection("在 catch 中再次抛出了异常");
            throwable.initCause(e);
            throw throwable;
        }
    }

    public void test() {

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream("srcPath");
            outputStream = new FileOutputStream("destPath");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
