package test;

import java.io.FileNotFoundException;

public class CustomFileExpection extends FileNotFoundException {
    public CustomFileExpection() {
    }

    public CustomFileExpection(String s) {
        super(s);
    }
}
