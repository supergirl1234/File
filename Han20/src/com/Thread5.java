package com;

import java.time.LocalDateTime;

/**
 * Author:Fanleilei
 * Created:2019/3/9 0009
 */

//sleep
public class Thread5 {

    public static void main(String[] args) {

        //最简洁的写法
        Runnable runnable=new Runnable() {
            @Override
            // public synchronized void run() {
            //这两句是不一样的
            public  void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+"执行当前时间"+LocalDateTime.now());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        //所有的代码是依次进入到run()方法中的。
        new Thread(runnable,"线程1").start();
        new Thread(runnable,"线程2").start();
    }
}
