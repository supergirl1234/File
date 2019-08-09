package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class out {

    public static void main(String[] args) {
        File file=Paths.get("D:"+File.separator+"test"+File.separator+"output1.txt").toFile();
        FileOutputStream out=null;
        try {
            out=new FileOutputStream(file);
            out.write(1);
            out.write('A');
            byte[] bytes=new byte[]{'a','b','c','d'};
            out.write(bytes);
            out.write(bytes,1,3);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            /*要记得关闭数据流*/
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
