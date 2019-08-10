package comm;


import java.io.*;

public class TestReader2 {

    public static void main(String[] args) {

        File infile = new File("D:/test/input.txt");

        Reader reader=null;
        try {
            reader=new FileReader(infile);

            int len=-1;
            char[] chars=new char[3];

            while((len=reader.read(chars))!=-1){
                System.out.println(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
