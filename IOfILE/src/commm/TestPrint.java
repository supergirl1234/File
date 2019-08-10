package commm;


import java.io.*;

/*自己设计一个打印流*/
public class TestPrint {


    private OutputStream outputStream;

    public TestPrint(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    public void print(String str){
        try {
            outputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void println(String str){

        print(str);
    }
    public void println(int value){

        print(String.valueOf(value));
    }
    public void println(double value){

        print(String.valueOf(value));
    }
    public void println(boolean str){

        print(String.valueOf(str));
    }


    public static void main(String[] args) {

        try {
            OutputStream out=new FileOutputStream(new File("D:/test/output.txt"));
            TestPrint p=new TestPrint(out);
            p.print("Hello");
            p.println("world");
            p.println(1);
            p.println(true);
            p.println(2.000);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
