package com;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Author:Fanleilei
 * Created:2019/2/27 0027
 */
public class TestFile2 {

    public static void code1() {

        File file=new File("D:"+File.separator+"a"+File.separator+"b"+File.separator+"c"+File.separator+"d.txt");

        if(!file.exists()){
            System.out.println("该文件不存在");
            File parentFile=file.getParentFile();
            System.out.println(parentFile);
            System.out.println(file.getParent());
           //parentFile.mkdir();//只会创建当前目录
          parentFile.mkdirs();//会创建当前目录以及上级目录
            System.out.println("创建父目录成功");
        }

        if(file.exists()){
            System.out.println("文件已经存在");
        }else{

            System.out.println("文件不存在");
            try {
                file.createNewFile();
                System.out.println("文件已经建立");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {

        File file=new File("D:"+File.separator+"a"+File.separator+"b"+File.separator+"c"+File.separator+"d.txt");

        System.out.println("文件是否是目录：" +file.isDirectory());
        System.out.println("文件是否是普通文件：" +file.isFile());
        System.out.println("文件最后修改时间：" +new Date(file.lastModified()));
        System.out.println("文件大小: "+file.length());

        File newFile=new File("D:"+File.separator+"hello.txt");
        System.out.println("hello.txt是否是文件："+newFile.isFile());
        System.out.println("hello.txt是否是目录："+newFile.isDirectory());

      File file1=new File("D:"+File.separator+"q");

        System.out.println("file1是否是目录："+file1.isDirectory());
        ////file 是普通文件返回null, 如果是目录返回当前目录下的下一级的所有文件以及文件夹
        File[] files=file1.listFiles();
        if(files!=null) {
            for (File p : files) {
               System.out.println(p);
                //System.out.println(p.getAbsolutePath());

            }
        }else{

            System.out.println("该目录为空");
        }
    }
}
