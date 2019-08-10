package comm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestFlush {

    public static void main(String[] args) {
        File file=new File("D:/test/output.txt");
        Writer writer=null;
        try {
            writer=new FileWriter(file);
            /*输出字节流的write方法可以写new char[],String,int*/

            writer.write(new char[]{'a','b','c','d','e'},1,2);
            writer.write("world",1,3);
            /*如果不关闭数据流，则需要强制刷新，将缓存区的数据输出到目标文件*/
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
