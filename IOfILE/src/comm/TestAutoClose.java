package comm;


import java.io.*;

/*Reader和Writer都是继承了Closeable接口，而Closeable接口又继承了AutoClose类*/
public class TestAutoClose {

    public static void main(String[] args) {
        File infile = new File("D:/test/input.txt");
        File outfile = new File("D:/test/output.txt");

        //Reader和Writer也是可以自动关闭的；
        try( Reader reader=new FileReader(infile);
             Writer writer=new FileWriter(outfile)) {

            int value=-1;
            while ((value=reader.read())!=-1){
                writer.write(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
