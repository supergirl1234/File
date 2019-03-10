package com;

/**
 * Author:Fanleilei
 * Created:2019/3/9 0009
 */

//Runnable实现的多线程的程序类可以更好的描述出程序共享的概念
public class Thread3 extends Thread {


    private  int tick=10;

    @Override
    public void run() {
        while(tick>0){

            System.out.println(this.getName()+"剩余："+tick--+"张票");
        }
    }

    public static void main(String[] args) {
/*

        Thread thread1=new Thread3();
        thread1.setName("Thread-A");
        Thread thread2=new Thread3();
        thread2.setName("Thread-B");

        //此时启动两个线程实现卖票处理，结果变为了卖各自的票
        //如果想实现两个线程合作卖票，将tick变成static int的数据类型
        thread1.start();
        thread2.start();
*/


//Runnable实现的多线程的程序类可以更好的描述出程序共享的概念

        //这种情况下，实现了数据的共享，两个线程共同卖票
        Runnable runnable=new Runnable() {
            private  int tick=10;
            @Override
            public void run() {
                while(tick>0){
                     //Thread.currentThread()获取当前线程
                    System.out.println(Thread.currentThread().getName()+"剩余："+tick--+"张票");
                }
            }
        };

        new Thread(runnable,"Thread-A").start();
        new Thread(runnable,"Thread-B").start();


    }
}
