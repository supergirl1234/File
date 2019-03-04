package com;

import java.io.*;

/**
 * Author:Fanleilei
 * Created:2019/3/4 0004
 */

//多文件合并，文件不能太大，考虑内存有限
public class TestManyFile3 {

    public static void MergeManyFile(String[] mergeFile,String outPath ){
      //初始化所有输入文件
        File[] files=new File[mergeFile.length];
        for(int i=0;i<mergeFile.length;i++){

            files[i]=new File(mergeFile[i]);
        }

        try(ByteArrayOutputStream memory=new ByteArrayOutputStream();
        OutputStream out=new FileOutputStream(new File(outPath));) {
            for (File p : files) {
                try(InputStream in = new FileInputStream(p);) {

                    byte[] buff=new byte[3];
                    int len=-1;
                    while((len=in.read(buff))!=-1){

                        memory.write(buff,0,len);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }

            //内存流输入到文件
            out.write(memory.toByteArray());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        MergeManyFile(new String[]{"D:"+File.separator+"javatxt"+File.separator+"data1.txt",
                "D:"+File.separator+"javatxt"+File.separator+"data2.txt",
                "D:"+File.separator+"javatxt"+File.separator+"data3.txt"},
                "D:"+File.separator+"javatxt"+File.separator+"data.txt");
    }
}
