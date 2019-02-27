package com;

import java.io.*;
import java.nio.file.Paths;

/**
 * Author:Fanleilei
 * Created:2019/2/27 0027
 */
public class TestCharStream {

    public static void code1() {

       File file=Paths.get("D:","test","input.txt").toFile();

       try(Writer writer=new FileWriter(file)){
           writer.write("hello,老虎");
           writer.write(new char[]{'s','q','l'});

       } catch (IOException e) {
           e.printStackTrace();
       }

    }

    public static void code2() {
        File file=Paths.get("D:","test","input.txt").toFile();
        try(Reader reader=new FileReader(file)){
            char[] data=new char[1024];
            int len=-1;
            while((len=reader.read(data))!=-1){
                System.out.println(new String(data,0,len));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void code3() {

        File file=Paths.get("D:","test","input.txt").toFile();

        try(Writer writer=new FileWriter(file)){
            writer.write("hello,老虎");
            writer.write(new char[]{'s','q','l'});

            writer.flush();//将缓冲区的内容输出到目的地
            writer.write(new char[]{'A', 'B', 'C', '\n'});
            writer.write(new char[]{'a', 'b', 'c'}, 2, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        File file=Paths.get("D:","test","input.txt").toFile();

        //通过字节流构造字符流对象，注意编码格式
        //字节流
        try(OutputStream out=new FileOutputStream(file);
           OutputStreamWriter writer=new OutputStreamWriter(out)){

            writer.write("我是大学生");
            writer.write("西安");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.getProperties().list(System.out);
    }

}

