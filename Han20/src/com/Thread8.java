package com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author:Fanleilei
 * Created:2019/3/9 0009
 */
public class Thread8 {
    public static void printTime() {
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
        System.out.println(time);
    }

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread thread = new Thread(mt,"子线程A");
        thread.start();
        System.out.println(Thread.currentThread().getName());
       try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("代码结束");
    }
}
class MyThread implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("主线程睡眠前的时间");
            Thread8.printTime();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
            System.out.println("睡眠结束的时间");
            Thread8 .printTime();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}