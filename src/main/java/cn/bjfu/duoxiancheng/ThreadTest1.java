package cn.bjfu.duoxiancheng;

/**
 * @Auther jxy
 * @Date 2020-06-14
 * 创建多线程的方式二：实现Runable接口
 * 1。创建一个实现Runnable接口的类
 * 2。实现类去实现Runnable中的抽象方法
 * 3。创建Thread类子类的
 * 4。将此对象作为参数传递到Thread类的构造器，创造Thread类的对象
 * 5。通过Thread类的对象调用start()
 *
 * 创建线程的两种方式。
 *
 */
class MThread implements Runnable{
    public void run() {
        for(int i =0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadTest1 {
    public static void main(String[] args) {
        MThread t1  = new MThread();
        //调用了Runnable接口的target
        Thread thread = new Thread(t1);
        thread.start();
        //在启动一个线程 遍历100以内的偶数
        Thread t2 = new Thread(t1);
        t2.start();
    }
}
