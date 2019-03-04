package com;

import java.io.*;
import java.nio.file.Paths;

/**
 * Author:Fanleilei
 * Created:2019/3/4 0004
 */

//简单的两个文件合并成一个文件
public class TestFile2 {

    //内存流合并两个文件
    //data1.txt  data2.txt->data.txt

    public static void main(String[] args) {

        File file1=Paths.get("D:","javatxt","data1.txt").toFile();
        File file2=Paths.get("D:","javatxt","data2.txt").toFile();
        File file3=Paths.get("D:","javatxt","data.txt").toFile();//这个文件可以不用自己创建，系统会自动创建


        try(InputStream in1=new FileInputStream(file1);
            InputStream in2=new FileInputStream(file2);
            ByteArrayOutputStream meomery=new ByteArrayOutputStream();
            OutputStream out=new FileOutputStream(file3)){


            //读文件，并写入内存流
            byte[] buff=new byte[1024];
            int len=-1;
            while((len=in1.read(buff))!=-1){
            meomery.write(buff,0,len);
            }
            while((len=in2.read(buff))!=-1){
                meomery.write(buff,0,len);
            }

            //写入文件
            out.write(meomery.toByteArray());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        }
}
