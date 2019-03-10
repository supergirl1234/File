/**
 *
 * 通过标记位的方式终止线程
 * Author:Fanleilei
 * Created:2019/3/9 0009
 */
public class Thread9 {

    public static void main(String[] args) {
        MyRunnable runnable=new MyRunnable();
     Thread thread=new Thread(runnable);
     thread.start();
        try {
            //主线程休眠
            Thread.sleep(3000);
            //修改标记位
             runnable.setFlag(false);

             //或者直接通过stop使线程退出，但现在不用它了
            //thread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class MyRunnable implements Runnable{

    private boolean flag=true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int i=0;
        while(this.flag){

            System.out.println(Thread.currentThread().getName()+"循环执行第"+ ++i +"次");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
