package com;

import java.io.*;

/**
 * Author:Fanleilei
 * Created:2019/3/4 0004
 */
public class TestSystemIO {

    public static void main(String[] args) {
        try {
            Integer value = Integer.parseInt("abc");
            System.out.println(value);
        }catch(Exception e){

            System.out.println(e.getMessage());
            System.err.println(e.getMessage());
        }

//由于System.out是PrintStream的实例化对象，而PrintStream又是OutputStream的子类，所以可以直接使用
//System.out直接为OutputStream实例化，这个时候的OutputStream输出的位置将变为屏幕


        //使用System.out为OutputStream实例化
        OutputStream out=System.out;
        try {
            out.write(new byte[]{'q','a'});
            System.out.println();
            out.write("hello".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        //System.in对应InputStream，这种输入流指的是由用户通过键盘进行输入(用户输入)。

        /*InputStream in=System.in;
        System.out.println("请输入内容：");

        //开辟的字节数组长度固定，如果现在输入的长度超过了字节数组长
        //度，那么只能够接收部分数据。
        byte[] buff=new byte[5];
        try {
            int len=in.read(buff);
            //System.out.println(buff);//error
            System.out.println(new String(buff, 0, len));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //上面那种方法有缺点，导致输入的数据不能被完全读取
        //所以可以用到内存流，先将数据保存到内存流中，再一次取出来

        InputStream in2=System.in;
        System.out.println("请输入内容：");
       try(ByteArrayOutputStream out2=new ByteArrayOutputStream();) {
           byte[] bu = new byte[5];
           int len = -1;
           while ((len = in2.read(bu)) != -1){

               out2.write(bu, 0, len);
               if(len<bu.length){ //一定要有，是用来判断用户是否输入结束

                   break;
               }

           }
           System.out.println(new String(out2.toByteArray()));

       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
