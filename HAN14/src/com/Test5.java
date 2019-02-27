package com;

/**
 * Author:Fanleilei
 * Created:2019/2/27 0027
 */
public class Test5  implements AutoCloseable{


    public void print(){

        System.out.println("message打印");
    }
    @Override
    public void close() throws Exception {
        System.out.println("message关闭");

    }

    public static void main(String[] args) {
        Test5 p1=new Test5();
        p1.print();
        try {
            p1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //AutoCloseable 的close能够被自动调用
        /*try(//实例化对象的代码,实例化对象的类实现AutoCloseable接口){

        }catch(){

        }finally{

        }*/

        //下面这段代码的结果与上面的一样，会自动关闭
        try(Test5 p2=new Test5()){
            p2.print();

        } catch (Exception e) {
            e.printStackTrace();
        }


        Test5 p3=null;

        try {
            p3 = new Test5();
            p3.print();
        }catch(Exception e){


        }finally{

            //自己关闭对象
            if(p3!=null){

                try {
                    p3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
