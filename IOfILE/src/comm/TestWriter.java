package comm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestWriter {

    /*writer是字符输出流*/
    public static void main(String[] args) {

        File file=new File("D:/test/output.txt");
        Writer writer=null;
        try {
            writer=new FileWriter(file);
            /*输出字节流的write方法可以写new char[],String,int*/
            writer.write(1);
            writer.write("hello");
            writer.write(new char[]{'a','b','c'});
            writer.write("world",1,3);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {     /*特别注意的是，如果不关闭数据流的话，则数据写不到文件中，数据就有可能保存在缓存中并没有输出到目标源*/
            if(writer!=null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
