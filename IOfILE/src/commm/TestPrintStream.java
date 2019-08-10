package commm;


import java.io.*;

/*字节打印流*/
public class TestPrintStream {

    public static void main(String[] args) {

        /*PrintStream(OutputStream out)*/
        try(  OutputStream o=new FileOutputStream(new File("D:/test/output.txt"));
              PrintStream out=new PrintStream(o);) {

               out.println(2);
               out.print(true);
               out.print(new char[]{'1','2','3'});
               out.print(2.0000);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
