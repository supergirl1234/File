package com;

import java.io.*;

/**
 * Author:Fanleilei
 * Created:2019/3/4 0004
 */

//打印流
public class TestPrintStream {

   private OutputStream out;

    public TestPrintStream(OutputStream out) {
        this.out = out;
    }
    public void print(String str){
        try{

            out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  void println(String str){
        print(str);

    }
    public  void println(int value){
        print(String.valueOf(value));

    }
    public  void println(double value){
        print(String.valueOf(value));

    }
    public void println(boolean value) {
        print(String.valueOf(value));
    }
    public static void main(String[] args) {

        try {
            TestPrintStream printStream=new TestPrintStream(new FileOutputStream(new File("D:"+File.separator+"javatxt"+File.separator+"print.txt")));


            printStream.println("Hello world");
            printStream.println(10);
            printStream.println(20.234);
            printStream.println(false);
            printStream.println("我");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void code1() {

        //如果操作的不是二进制数据，
        //只是想通过程序向终端目标输出信息的话，OutputStream不是很方便，其缺点有两个：
        //1. 所有的数据必须转换为字节数组。
        //2. 如果要输出的是int、double等类型就不方便了
        try {
            OutputStream out=new FileOutputStream(new File("D:"+File.separator+"javatxt"+File.separator+"1.txt"));
           out.write(12);//错误
           out.write(new byte[]{'a','b','3'});//必须转换为字节

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
