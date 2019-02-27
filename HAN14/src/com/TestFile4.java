package com;

import java.io.*;
import java.nio.file.Paths;

/**
 * Author:Fanleilei
 * Created:2019/2/27 0027
 */
public class TestFile4 {
//1.输入流：
    //  1.1 准备文件
    //  1.2 实例化FileInputStream对象
    //  1.3 read()读取数据
    //  1.4 业务处理处理
    //  1.5 关闭输入流-finally

    //2.输出流：
    //  2.1 准备文件，文件不存在自动创建，但是目录一定要存在
    //  2.2 实例化FileOutputStream对象
    //  2.3 业务处理数据
    //  2.4 write() 输出数据
    //  2.4 关闭输出流-finally

    //3.业务处理
    //  3.1 读取数据，while(){} ，读到末尾返回-1

    public static void code1() {
// input.txt -> application -> output.txt
        File inputfile= Paths.get("D:","test","input.txt").toFile();
        File outputfile= Paths.get("D:","test","output.txt").toFile();

        if(!outputfile.getParentFile().exists()){
            outputfile.getParentFile().mkdirs();

        }

        FileInputStream ins=null;
        FileOutputStream out=null;

        try {
            ins=new FileInputStream(inputfile);
            out=new FileOutputStream(outputfile);

            int value=-1;
            //输入
            //读取单个字节，每次读取一个字节的内容，直到没有数据了返回-1
            while((value=ins.read())!=-1){
                //将得到的数据进行处理
                value=value+32;
                //输出
                out.write(value);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            //关闭数据流
            if(ins!=null){
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }

    public static void code2() {

        File file=Paths.get("D:","test","output1.txt").toFile();
        OutputStream out=null;
        try {
            out=new FileOutputStream(file);
            out.write(65);

            byte[] data=new byte[]{65,66,67,68,20};
            out.write(data);
            out.write(data,2,2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }
//输出流采用自动关闭
    public static void main(String[] args) {
        File file=Paths.get("D:","test","output1.txt").toFile();

        try(OutputStream out=new FileOutputStream(file)) {

            out.write(65);

            byte[] data=new byte[]{65,66,67,68,20};
            out.write(data);
            out.write(data,2,2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
