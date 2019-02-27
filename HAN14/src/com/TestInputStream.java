package com;

import java.io.*;
import java.nio.file.Paths;

/**
 * Author:Fanleilei
 * Created:2019/2/27 0027
 */
public class TestInputStream {

    public static void code1() {
        //字节输入流和输出流的缓存方式读取和写入
        File file=Paths.get("D:","test","input.txt").toFile();
        File destfile=Paths.get("D:","test","output.txt").toFile();

        try(InputStream in=new FileInputStream(file);
            OutputStream out=new FileOutputStream(destfile)) {

            byte[] buff=new byte[3];
            int len=-1;
            while((len=in.read(buff))!=-1){
                out.write(buff,0,len);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //文件复制
    public static void copy(String srcFilePath, String destFilePath) {
        //检测工作
        if(srcFilePath==null||srcFilePath.isEmpty()){
            throw new IllegalArgumentException("srcFilePath must be not null/empty");

        }
        if(destFilePath==null||destFilePath.isEmpty()){
            throw new IllegalArgumentException("destFilePath must be not null/empty");
        }

        File srcFile=Paths.get(srcFilePath).toFile();
        File destFile=Paths.get(destFilePath).toFile();

        if(!srcFile.exists()||!srcFile.isFile()){
            throw new IllegalArgumentException("srcFilePath file not exists or not file");
        }

        File parentFile=srcFile.getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                throw new RuntimeException("can't create " + parentFile.getAbsolutePath() + " directory");
            }
        }

        //文件复制
        try(InputStream in=new FileInputStream(srcFile);
            OutputStream out=new FileOutputStream(destFile)){

            byte[] data=new byte[1024];
            int len=-1;
            while((len=in.read(data))!=-1){
                out.write(data,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    /*//文件复制
    public static void copy(String srcFilePath, String destFilePath) {
        //参数校验
        if (srcFilePath == null || srcFilePath.isEmpty()) {
            throw new IllegalArgumentException("srcFilePath must be not null/empty");
        }
        if (destFilePath == null || destFilePath.isEmpty()) {
            throw new IllegalArgumentException("destFilePath must be not null/empty");
        }

        //文件校验以及准备工作
        File srcFile = Paths.get(srcFilePath).toFile();
        File destFile = Paths.get(destFilePath).toFile();

        if (!srcFile.exists() || !srcFile.isFile()) {
            throw new IllegalArgumentException("srcFilePath file not exists or not file");
        }

        File parentFile = destFile.getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                throw new RuntimeException("can't create " + parentFile.getAbsolutePath() + " directory");
            }
        }

        //文件复制
        try (FileInputStream in = new FileInputStream(srcFile);
             FileOutputStream out = new FileOutputStream(destFile)
        ) {
            //缓存数组
            byte[] buff = new byte[1024]; //1k , 2k, 4k, 8k
            int len = -1;
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }*/
    public static void main(String[] args) {
        String src = "D:\\test\\test1\\input.txt";
        String dest = "D:\\test\\test1\\test2\\a.txt";
        long start=System.currentTimeMillis();
        copy(src,dest);
        long end=System.currentTimeMillis();
        System.out.println("复制所用时间为："+(end-start)/1000+"s");
    }
}
