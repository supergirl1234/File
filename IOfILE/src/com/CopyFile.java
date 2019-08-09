package com;

import java.io.*;

public class CopyFile {

    public static void copy(String src, String dest) {

        /*检测工作*/
        if (src == null || src.isEmpty()) {
            throw new IllegalArgumentException("src源文件不能为空");

        }
        if (dest == null || dest.isEmpty()) {
            throw new IllegalArgumentException("dest目标文件不能为空");

        }

        File InFile = new File(src);
        File OutFile = new File(dest);

        if(!InFile.exists()){

            throw  new IllegalArgumentException("源文件不存在");
        }
        if(!InFile.isFile()){

            throw  new IllegalArgumentException("源文件不是一个文件类型");
        }

        File parentFile=InFile.getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                throw new RuntimeException("can't create " + parentFile.getAbsolutePath() + " directory");
            }
        }

        try (InputStream in = new FileInputStream(InFile);
             OutputStream out = new FileOutputStream(OutFile);) {

            int value = -1;
            byte[] bytes = new byte[1024];
            while ((value =in.read(bytes))!=-1) {

                out.write(bytes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        String src = "D:/test/input.txt";
        String dest = "D:/test/a.txt";

        copy(src,dest);
        long end=System.currentTimeMillis();

    }
}
