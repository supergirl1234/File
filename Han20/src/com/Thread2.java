package com;

/**
 * Author:Fanleilei
 * Created:2019/3/9 0009
 */
//继承Thread类有局限性，单继承
//public Thread(Runnable target)
//使用多线程方法
//1.复用业务逻辑
//2.实现Runnable接口，可以继续实现接口
//3.实现Runnable接口，可以采用函数式编程


//public class Thread implements Runnable
public class Thread2 {


    public static void main(String[] args) {

        PrintInfo task=new PrintInfo();
        Runnable runnable=new PersonInfoRunnable(task);
        Thread thread1=new Thread(runnable);
        thread1.start();
        Thread thread2=new Thread(runnable);
        thread2.start();


        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
              task.print("hello","java");
            }
        });
        thread3.start();
        Thread thread4=new Thread(new Runnable() {
            @Override
            public void run() {
                task.print("hello","world");
            }
        });
        thread4.start();

        //Lamdba表达式
        Thread thread5=new Thread(()->task.print("hello"));
        thread5.start();

    }
}

class PrintInfo{


    public void print(Object... args){
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);

        }

    }
}

class PersonInfoRunnable implements Runnable{
    private  final PrintInfo task;

    public PersonInfoRunnable(PrintInfo task) {
        this.task = task;
    }

    @Override
    public void run() {
        this.task.print("hello","java","world");

    }
}
