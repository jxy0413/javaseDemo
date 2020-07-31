package cn.bjfu.duoxiancheng;

/**
 * @Auther jxy
 * @Date 2020-06-14
 * 例子 ：创建三个窗口卖票 总票数为100张
 *
 * 实现的方式没有类单继承的局限性
 * 实现的方式更适合处理多个线程共享数据的情况
 *
 * 联系
 * Thread类也继承了Runable接口
 * 相同点：两种方式 都需要重写run()方法，将线程要执行的逻辑生命在Run方法
 *
 * 1。问题：卖票过程中，出现了重票，错票
 * 2。原因：当某个线程操作车票的过程中，尚未操作完成时候，其他线程参与进来，也操作车票
 * 3。如何解决：当一个线程a操作ticket的时候 其他线程不能参与进来 直到线程a操作ticket时候
 * 线程才可以操作 即使线程a出来阻塞，也不能改变
 * 4。在Java中 我们通过同步机制 来解决线程安全问题
 *
 * 方式一：同步代码块
 * Synchronized(同步监视器）{
 *     //需要被同步的代码
 * }
 * 说明：操作共享数据的代码 即为需要被同步的代码   -->不能包多了 也不能包含少了
 *      共享数据：多个线程共同操作的变量 比如 本文的ticket就是
 *      同步监视器：俗称 锁 任何一个类的对象 都可以充当锁
 *      要求：必须多个线程共用同一个一把锁
 * 5。同步的方式，解决了线程的安全的方式  --好处
 * 缺点  效率低了
 *
 * 在实现Runnable接口可以考虑用this
 *
 * 方式二：同步方法
 * 如果操作共享数据的代码正好是一个方法
 *
 * 同步方法仍然设计到同步监视器，只是不需要我们显示的声明
 * 非静态的
 *
 */
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w  = new Window1();
        Thread t1  = new Thread(w);
        Thread t2  = new Thread(w);
        Thread t3  = new Thread(w);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Window1 implements Runnable{
    private int ticket = 100;
   // Object object  =new Object();

    public void run() {
        while (true){
            synchronized (this){
                if(ticket>0){
//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}
