package commm;


import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*内存流*/
/*文件流的操作里面一定会产生一个文件数据，
如果需要进行IO处理，但是又不希望产生文件。这种情况下就可以使用内存作为操作终端*/
/*字节内存流*/
public class TestByteArray {

    public static void main(String[] args) {

        /*  ByteArrayInputStream继承了InputStream、ByteArrayOutputStream继承了OutputStream*/
        byte[] bytes=new byte[]{'q','w','r','t','t','y'};
        ByteArrayInputStream in=new ByteArrayInputStream(bytes);
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        int value=-1;
        while((value=in.read())!=-1){
           // 每个字节处理之后所有数据都在outputStream类中
            out.write(value);

        }
        /*要想输出结果，直接输出ByteArrayOutputStream对象即可*/
        System.out.println(out);
        try {
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
