package com;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Author:Fanleilei
 * Created:2019/3/2 0002
 */
public class TestFile1 {

    public static void main(String[] args) {
        String data="Hello World";//大写 data.toUpperCase();
        //字节内存流
        try(ByteArrayInputStream in=new ByteArrayInputStream(data.getBytes());
            ByteArrayOutputStream out=new ByteArrayOutputStream()){


            byte[] buff=new byte[3];
            int len=-1;
            while((len=in.read(buff))!=-1){


                //业务逻辑
                for(int i=0;i<len;i++){
                    if(buff[i]>='a'&&buff[i]<='z'){
                        buff[i]= (byte) (buff[i]-32);


                    }

                }
                // 每个字节进处理,处理之后所有数据都在outputStream类中
                out.write(buff,0,len);
            }
            // 直接输出output对象
            System.out.println(out);
            System.out.println(out.getClass());

            /*byte[] newData=out.toByteArray();
            System.out.println(new String(newData));*/


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
