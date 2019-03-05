package com;

import java.io.*;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Author:Fanleilei
 * Created:2019/3/5 0005
 */

//public class BufferedReader extends Reader
//public BufferedReader(Reader in)
public class TestBufferReader {
    //要想从控制台输入数据，从键盘输入，就要用到System.in
    //BufferedReader  -> InputStreamReader  ->  InputStream
    public static void code1() {
        try(InputStream in=System.in;
            Reader read=new InputStreamReader(in);
            BufferedReader reader=new BufferedReader(read);){

            System.out.println("请输入内容：");
           /* String str=reader.readLine();
            System.out.println(str);*/

           String line;
           while(!(line=reader.readLine()).equals("q")){
               System.out.println(line);

           }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        File file=Paths.get("D:","javatxt","1.txt").toFile();

        try(InputStream in=new FileInputStream(file);
           Reader read=new InputStreamReader(in);
           //上面两行可以直接通过下面的一行代码代替
            //Reader read=new FileReader(file);
           BufferedReader reader=new BufferedReader(read);){


            String[] name=new String[10];
            String line=null;
            int index=0;
            while((line=reader.readLine())!=null){

                name[index]=line;
                index++;
            }
            Random random=new Random();
            int select=random.nextInt(name.length);
            System.out.println("选择的姓氏为："+name[select]);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
