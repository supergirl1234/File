package com;

/**
 * Author:Fanleilei
 * Created:2019/3/9 0009
 */
public class Thread1 extends  Thread {
    private final String title;

    public Thread1(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        //多线程处理的业务逻辑
        for(int i=0;i<10;i++){
            System.out.println(this.title+" "+i);

        }
    }

    public static void main(String[] args) {
        Thread thread1=new Thread1("线程1");
        Thread thread2=new Thread1("线程2");
        Thread thread3=new Thread1("线程3");

        /*thread1.run();
        thread2.run();
        thread3.run();*///只是做了一个顺序打印，和多线程一点关系都没有
        //用start来调用线程
        //此时再次执行代码发现，所有的线程对象变味了交替执行
        thread1.start();
        thread2.start();
        thread3.start();
        //所以，每一个线程对象只能够启动一次


    }
}
