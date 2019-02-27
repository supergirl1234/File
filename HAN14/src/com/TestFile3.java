package com;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Author:Fanleilei
 * Created:2019/2/27 0027
 */
public class TestFile3 {

    //递归方式遍历指定文件目录下的所有文件以及子目录
    public static  void findFile(File file,int level){
        if(file.isFile()){
            System.out.println(repeatSpace(level)+"|-"+file.getName());

        }else{
            System.out.println(repeatSpace(level)+"+"+file.getName());
            File[] files=file.listFiles();
                if(files!=null){
                    for(File p:files){
                        findFile(p,level+2);

                    }
            }

        }

    }
    private static String repeatSpace(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        //另一种方式创建文件
        //先创建路径，再将路径转换为文件
        //D:\test\a.txt
        Path path=Paths.get("D:","test","a.txt");

        //将路径转换为文件
        File file=path.toFile();
        if(file.exists()) {
            try {
                System.out.println("删除文件");
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println("-------------");
        File file1=new File("D:"+File.separator+"d"+File.separator+"ss.txt");
       if(file1.exists()){
           System.out.println("文件存在");
           file1.delete();//删除只是删除文件，不删除它上级的目录等
           System.out.println("删除文件");

       }

       File file2=new File("D:"+File.separator+"a");
        findFile(file2,3);

    }
}
