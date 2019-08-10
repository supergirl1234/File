package commm;

import com.out;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TestByteArray2 {

    public static void main(String[] args) {

        /*  ByteArrayInputStream继承了InputStream、ByteArrayOutputStream继承了OutputStream*/
        byte[] bytes=new byte[]{'q','w','r','t','t','y'};
        try(ByteArrayInputStream in=new ByteArrayInputStream(bytes);
            ByteArrayOutputStream out=new ByteArrayOutputStream()){
            byte[] buff=new byte[3];
            int len=-1;
            while ((len = in.read(buff)) != -1) {
                // 每个字节处理之后所有数据都在outputStream类中
                out.write(buff,0,len);

            }
            /*要想输出结果，直接输出ByteArrayOutputStream对象即可*/
            System.out.println(out);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
