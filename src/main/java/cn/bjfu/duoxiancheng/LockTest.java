package cn.bjfu.duoxiancheng;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther jxy
 * @Date 2020-06-17
 * 解决线程安全问题的方式三：Lock锁--JDK5.0新增
 *
 * 1。面试题 synchronized 与 Lock的异同
 * 同：二者都可以解决线程安全的问题
 * 异：synchronized机制在执行相应的同步代码以后，自动的释放同步监视器
 *    lock需要手动的启动，同时结束的时候也需要手动的实现
 * 面试题：如何解决线程安全问题？集中
 */
class  WindowTestD implements Runnable{
    private int ticket = 100;
    //实例对象
    private ReentrantLock lock = new ReentrantLock(true);
    public void run() {
        while (true){
            try {
                //调用lock方法
                lock.lock();
                if(ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"票号为 : "+ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                //3。调用解锁方法 unlock
                lock.unlock();
            }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        WindowTestD  w1 = new WindowTestD();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
