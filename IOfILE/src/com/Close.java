package com;

import java.io.Closeable;
import java.io.IOException;

public class Close implements Closeable {
    public void print() {

        System.out.println("打印");
    }
    @Override
    public void close() throws IOException {
        System.out.println("打印完毕");
    }
    public static void main(String[] args) {
        Close close = new Close();
        close.print();
        try {
            close.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("++++++++++++++++++++++++");
        try (Close p = new Close()) {
            p.print();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


