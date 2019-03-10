package com;

/**
 * Author:Fanleilei
 * Created:2019/3/9 0009
 */
public class Thread7 {
    public static void main(String[] args) {
        //业务逻辑
        Runnable runnable=new MyRunnable();
        //线程
        Thread thread=new Thread(runnable,"Thread-A");
        thread.start();

        //在主线程中调用线程对象的join方法，会阻塞线程
        //直到调用线程对象的run方法执行完毕，主线程才会继续执行
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class MyRunnable implements  Runnable{

    private int tick = 100;
    @Override
    public void run() {
        while(this.tick>0){
            System.out.println(Thread.currentThread().getName()+" tick="+tick--);
        }
    }
}