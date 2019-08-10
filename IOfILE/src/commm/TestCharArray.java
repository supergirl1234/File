package commm;


import com.sun.xml.internal.messaging.saaj.util.CharReader;
import com.sun.xml.internal.messaging.saaj.util.CharWriter;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/*字符内存流*/
public class TestCharArray {

    public static void main(String[] args) {
        char[] chars=new char[]{'a','s','d','f','g','h','j','k','l'};
        try(CharArrayReader reader=new CharArrayReader(chars);
            CharArrayWriter writer=new CharArrayWriter();){
            int len=-1;
            char[] buff=new char[3];
            while((len=reader.read(buff))!=-1){

                writer.write(buff,0,len);
            }
            System.out.println(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
