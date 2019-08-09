package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputAndOut2 {
    public static  void FileToFile2(String path1,String path2){

        File file1=new File(path1);
        File file2=new File(path2);
        FileInputStream in=null;
        FileOutputStream out=null;
        try {
            in=new FileInputStream(file1);
            out=new FileOutputStream(file2);
            int value=-1;
            /*读取数据，也可以不一个一个字节的读取，可以使用缓存方式读取和写入*/
            byte[] buff=new byte[3];
            while((value=in.read(buff))!=-1){/*每次读取3个字节存放在buff中*/

                out.write(buff);/*将buff中的数据写入file2中*/

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
           /*要记得关闭数据流*/
            if(in!=null){

                try {
                    in.close();
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
    public static void main(String[] args) {
        String one="D:/test/input.txt";
        String two="D:/test/output.txt";
        FileToFile2(one,two);
    }
}
