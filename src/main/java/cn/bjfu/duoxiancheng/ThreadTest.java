package cn.bjfu.duoxiancheng;

/**
 * @Auther jxy
 * @Date 2020-06-13
 * 1。多线程的创建，方式一：继承Thread类子类
 * 2。重写Thread类run()  --> 将此线程
 * 3. 创建继承Thread类子类对象
 * 4。调用start()
 *
 *
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+" : "+i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        //调用对象的start（）方法 启动当前线程 调用当前的线程run()
        t1.start();
        //问题二 在启动一个线程 遍历100以内的线程 不可以让已经start的线程去执行
        MyThread t2 = new MyThread();
        t2.start();
        //如下的操作仍站在main线程中执行
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);

            }
        }
    }
}
