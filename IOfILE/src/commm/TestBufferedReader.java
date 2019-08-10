package commm;

import java.io.*;

public class TestBufferedReader {

    public static void reader1() {
        try {
            Reader rea = new FileReader(new File("D:/test/input.txt"));
            BufferedReader reader = new BufferedReader(rea);
            CharArrayWriter out = new CharArrayWriter();

            char[] chars = new char[3];
            int len = -1;
            while ((len = reader.read(chars)) != -1) {
                out.write(chars);
            }
            System.out.println(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read2() {

        try {

            Reader rea = new FileReader(new File("D:/test/input.txt"));
            BufferedReader reader = new BufferedReader(rea);
            String str = reader.readLine();//读一行
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        reader1();
        System.out.println("++++++++++++++++++++");
        read2();

    }
}
