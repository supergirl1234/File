package com;

import java.io.File;
import java.io.IOException;

/**
 * Author:Fanleilei
 * Created:2019/2/27 0027
 */
public class TestFile1 {

    public static void main(String[] args) {

       File file=new File("D:\\hello.txt");
         if(file.exists()){

             System.out.println("文件已经存在");
         }else{

             System.out.println("文件不存在");
             try {
                 file.createNewFile();
                 System.out.println("并创建了该文件");
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }

        System.out.println("------------------");

        File file1 = new File("D:"+File.separator+"hello11.txt");
        if(file1.exists()){
            System.out.println("文件已经存在");
             file1.delete();//删除只是删除文件，不删除它上级的目录等
            System.out.println("已经删除该文件");

        }else{

            System.out.println("文件不存在");
            try {
                file1.createNewFile();
                System.out.println("创建了该文件");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
