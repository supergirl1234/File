package com;


import java.io.*;
import java.util.Arrays;

/*read是读取数据，write是输出数据*/
public class InputAndOut {


    public static  void FileToFile1(String path1,String path2){

        File file1=new File(path1);
        File file2=new File(path2);
        FileInputStream in=null;
        FileOutputStream out=null;
        try {
            in=new FileInputStream(file1);
            out=new FileOutputStream(file2);
            int value=-1;
            while((value=in.read())!=-1){/*当file1中有数据可读时*/

                out.write(value);/*就将从file1文件中读出的数据写入file2中*/

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


    public static void main(String[] args) throws IOException {
        String one="D:/test/input.txt";
        String two="D:/test/output.txt";
        FileToFile1(one,two);



    }

}
