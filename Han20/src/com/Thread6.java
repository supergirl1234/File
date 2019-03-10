package com;

/**
 * Author:Fanleilei
 * Created:2019/3/9 0009
 */

//yield
public class Thread6 {

    public static void main(String[] args) {

        Runnable runnable=()->{
            for(int i=0;i<3;i++){
                Thread.yield();
                System.out.println(Thread.currentThread().getName()+"i="+i);
            }

        };

        new Thread(runnable,"线程1").start();
        new Thread(runnable,"线程2").start();
        new Thread(runnable,"线程3").start();
    }
}
