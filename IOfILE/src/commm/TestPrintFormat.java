package commm;

import java.io.*;

public class TestPrintFormat {

    public static String name="kindy";

    public static int age=12;
    public static String address="山西省";
    public static void main(String[] args) {

        try(OutputStream out=new FileOutputStream(new File("D:/test/ouput1.txt"));
            PrintStream printStream=new PrintStream(out)){

            printStream.printf("name:%s "+"age:%d  "+"address:%s ",name,age,address);
            printStream.printf("name:%s "+"age:%d  "+"address:%s ",name,age,address);

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*String的format 格式化*/
        String string=String.format("name:%s age:%d",name,age);
        System.out.println(string);


        System.out.printf("name:%s age:%d",name,age);
        System.out.println();
        System.out.printf("name:%s age:%d",name,age);
        System.out.println();

        System.out.printf("姓名：%4s\n年龄：%-4d\n身高：%8.2f\n", "张三", 28, 168.7D);
        System.out.printf("姓名：%s\n年龄：%d\n身高：%f\n", "张三", 28, 168.7D);




        //1. out输出的是希望用户能看到的内容
        //2. err输出的是不希望用户看到的内容
        System.out.println("我能被看见");
        System.err.println("我不能被看见");




    }
}
