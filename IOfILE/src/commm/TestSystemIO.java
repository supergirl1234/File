package commm;



import java.io.*;

public class TestSystemIO {


    public static void out1() {

        OutputStream out = null;
        try {

            out = System.out;
            out.write(2);
            out.write(new byte[]{'a', 's', 'd', 'f'});
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void in1() {

        System.out.println("请输入内容");
        try (InputStream in = System.in;) {

            int value = -1;
            while ((value = in.read()) != -1) {
                System.out.println(new String(String.valueOf(value)));//怎么输出数据字符

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void in2() {

        System.out.println("请输入内容"); //12gjxnjd
        try (InputStream in = System.in;) {
            byte[] bytes = new byte[5];
            int len = -1;
            while ((len = in.read(bytes)) != -1) {

                System.out.println(new String(bytes,0,len));//12gjx
                                                                   // njd
                /*这样子会导致输入的数据一次读不完导致数据不完整*/

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*可以利用内存流，现将读出的部分数据存放在内存中，当数据全部读完时再将数据从内存中输出*/
    public static void RealIn3() {

        System.out.println("请输入内容"); //12gjxnjd
        try (InputStream in = System.in;
            ByteArrayOutputStream out=new ByteArrayOutputStream()) {
            byte[] bytes = new byte[5];
            int len = -1;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes,0,len);//将读到的数据存储到内存中
                if(len<bytes.length){/*判断数据是否读完*/
                  break;
                }

            }
            System.out.println(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //out1();
        //in1();
        //in2();

        RealIn3();

    }
}
