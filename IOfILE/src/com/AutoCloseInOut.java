package com;

import java.io.*;

//数据输入、输出流是可以采用自动关闭的,它是继承了AutoCloseable
public class AutoCloseInOut {

    public static void main(String[] args) {
        File infile = new File("D:/test/input.txt");
        File outfile = new File("D:/test/output.txt");
        /*将输入流、输出流的创建过程写在try（）内,中间用；隔开*/
        try (InputStream in = new FileInputStream(infile);
             OutputStream out = new FileOutputStream(outfile)) {

            int value=-1;
            while((value=in.read())!=-1) {
                out.write(value);

            }
            out.write(new byte[]{'a', 'b', 'c'});
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
