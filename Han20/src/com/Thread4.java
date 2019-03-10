package com;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Author:Fanleilei
 * Created:2019/3/9 0009
 */
public class Thread4 {

    public static void main(String[] args) {
        //业务
        Callable<String> callable=new MyCallable();
        FutureTask<String> futureTask=new FutureTask<>(callable);

        Thread thread=new Thread(futureTask);

        //当前线程的名称
        System.out.println(Thread.currentThread().getName());
        thread.start();
    }

}

class MyCallable implements Callable<String>{

    private int tick=10;

    @Override
    public String call() throws Exception {
        while(tick>0){
            System.out.println(Thread.currentThread().getName()+"剩余"+tick--+"张票");
        }
        return "票卖完了";
    }
}
