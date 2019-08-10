package commm;


import java.io.*;
import java.util.Date;

/*字符打印流*/
//PrintWriter(OutputStream out)  和PrintWriter(Writer writer)
public class TestPrintWriter {


    public static void run1(){

        try(OutputStream o=new FileOutputStream(new File("D:/test/output.txt"));
            PrintWriter out=new PrintWriter(o);) {

            out.print(new Date());
            out.println(2);
            out.print(true);
            out.print(new char[]{'1','2','3'});
            out.print(2.0000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void run2(){

        try(Writer o=new FileWriter(new File("D:/test/output.txt"));
            PrintWriter out=new PrintWriter(o);) {

            out.print(new Date());
            out.print(new char[]{'1','2','3'});
            out.print(2.0000);
            out.print("helloworld");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
      //run1();
      run2();
    }
}
