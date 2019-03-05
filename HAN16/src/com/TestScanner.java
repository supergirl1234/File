package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/3/5 0005
 */

//构造方法:public Scanner(InputStream source)
public class TestScanner {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入内容：");
        if(scanner.hasNext()){
            System.out.println(scanner.next());

        }

    }

    public static void code2() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入年龄：");
        if(scanner.hasNextInt()){
            System.out.println(scanner.nextInt());

        }else{
            System.out.println("输入的不是数字");
        }
        scanner.close();
    }

    public static void code3() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入年龄：");
        while(true) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
                break;

            } else {
                System.out.println("输入的不是数字,请重新输入");
                scanner.next();//丢弃掉不符合要求的数据
            }
        }
        scanner.close();
    }


    public static void code4() {
        //构造方法:public Scanner(InputStream source)

        try(   Scanner scanner=new Scanner(new FileInputStream(Paths.get("D:","javatxt","1.txt").toFile()));) {
               scanner.useDelimiter("\n");//分隔符
            while(scanner.hasNext()){

                System.out.println(scanner.next());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //正则表达式
    public static void code5() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入生日：");
        while(true){
            if(scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")){
                System.out.println(scanner.next());
                break;
            }else{
                System.out.println("输入的日期格式不正确，请重新输入");
               scanner.next();//丢弃掉不符合要求的数据

            }

        }
    }
}
