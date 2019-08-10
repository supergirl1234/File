package commm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class TestScanner {

    public static void  scanner1(){
        System.out.println("请输入内容数据");
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){

            System.out.println(scanner.next());
        }
    }

    public static void scanner2(){
        System.out.println("请输入int型数据");
        Scanner scanner=new Scanner(System.in);
        if(scanner.hasNextInt()){
            System.out.println(scanner.nextInt());
        }
        scanner.close();
    }

    public static void scanner3(){
        System.out.println("请输入int型数据");

        while(true) {
            Scanner scanner=new Scanner(System.in);
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
                break;
            }else{
                System.out.println("请重新输入int型数据");
            }
        }
    }

    /*scanner还可以匹配正则表达式*/
    public static void scanner4(){
        System.out.println("请输入生日：");

        while(true) {
            Scanner scanner=new Scanner(System.in);
            if (scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println(scanner.next());
                break;
            }else{

                System.out.println("请重新输入正确的生日日期");
            }

        }

    }

    public static void scanner5(){
        //Scanner的构造方法:public Scanner(InputStream source)
             try{
                 InputStream in=new FileInputStream("D:/test/input.txt");
                 Scanner scanner=new Scanner(in);
                 scanner.useDelimiter(":");//使用分隔符
                 while(scanner.hasNext()){
                     System.out.println(scanner.next());

                 }
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             }
    }
    public static void main(String[] args) {

       // scanner3();
        //scanner4();
        scanner5();

    }

}
