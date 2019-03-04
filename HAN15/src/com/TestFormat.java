package com;

import java.io.*;

/**
 * Author:Fanleilei
 * Created:2019/3/4 0004
 */

//格式化
public class TestFormat {

    public static void main(String[] args) {
        String name="张三";
        int age=21;
        String address="陕西省西安市";

        //PrintStream.printf
        try {

            PrintStream print=new PrintStream(new FileOutputStream(new File("D:"+File.separator+"javatxt"+File.separator+"print.txt")));
            print.printf("姓名：%s"+"年龄：%d"+"地址：%s",name,age,address);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //String.format
        String str=String.format("姓名：%s 年龄：%d",name,age);
        System.out.println(str);

        System.out.printf("姓名：%s "+"年龄：%d","汪汪",13);
        System.out.println();
        System.out.printf("姓名：%4s\n年龄：%-4d\n身高：%8.2f\n", "张三", 28, 168.7D);
        System.out.printf("姓名：%s\n年龄：%d\n身高：%f\n", "张三", 28, 168.7D);


        //System  : java.lang.System
        //  out     : Object   java.io.PrintStream
        // println : PrintStream类的成员方法，out对象的方法

        //由于System.out是PrintStream的实例化对象，而PrintStream又是OutputStream的子类，所以可以直接使用
        //System.out直接为OutputStream实例化，这个时候的OutputStream输出的位置将变为屏幕。
        try {
            PrintStream qw=new PrintStream(new FileOutputStream(new File("D:"+File.separator+"javatxt"+File.separator+"1.txt")));
            qw.println(12);
            qw.printf("姓名：%s "+"年龄：%d","汪汪",13);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //1. out输出的是希望用户能看到的内容
        //2. err输出的是不希望用户看到的内容
        System.out.println("我");
        System.err.println("我");


    }
}
