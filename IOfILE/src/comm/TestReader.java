package comm;

import java.io.*;

public class TestReader {

    /*reader是字符输入流*/
    public static void main(String[] args)  {

        File infile = new File("D:/test/input.txt");
        File outfile = new File("D:/test/output.txt");
        Reader reader=null;
        Writer writer=null;
        try {
             reader=new FileReader(infile);
             writer=new FileWriter(outfile);

             int value=-1;
           while ((value=reader.read())!=-1){
               writer.write(value);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            /*如果不关闭流的话，则数据无法写入到文件中，数据就有可能保存在缓存中并没有输出到目标源*/
            if(reader!=null){

                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(writer!=null){

                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
