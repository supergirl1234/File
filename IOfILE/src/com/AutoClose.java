package com;


/*自动关闭字节流*/
public class AutoClose implements  AutoCloseable {

    public void print(){

        System.out.println("打印");
    }
    @Override
    public void close() throws Exception {
        System.out.println("打印完毕");

    }

    public static void main(String[] args) {
         AutoClose autoClose=new AutoClose();

         autoClose.print();
        try {
            autoClose.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("++++++++++++++++++++++++");
        //但是，如果将AutoClose创建对象的过程放在try()括号中，则clos会自动调用
        try(AutoClose p=new AutoClose()){
            p.print();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
