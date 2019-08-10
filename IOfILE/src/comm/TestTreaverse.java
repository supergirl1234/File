package comm;


import java.io.*;

/*字节流可以转化为字符流*/
public class TestTreaverse {

    public static void main(String[] args) {

        File infile = new File("D:/test/input.txt");
        File outfile = new File("D:/test/output.txt");

        //Reader和Writer也是可以自动关闭的；
        try(
                InputStream in=new FileInputStream(infile);
                InputStreamReader reader=new InputStreamReader(in);
                OutputStream out=new FileOutputStream(outfile);
                OutputStreamWriter writer=new OutputStreamWriter(out);
                ) {

             int len=-1;
            while ((len=reader.read())!=-1){
                writer.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
