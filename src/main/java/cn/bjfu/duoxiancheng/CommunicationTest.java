package cn.bjfu.duoxiancheng;

/**
 * @Auther jxy
 * @Date 2020-06-17
 * 线程通信的例子：使用线程1-100 线程1，线程2 交替打印
 *
 * 涉及到的三个方法
 * wait()：一旦执行此方法，就进入阻塞状态
 * notify():一旦执行此方法，就会唤醒wait的线程 如果多的，就唤醒优先级高的
 * nofifyAll():一旦执行此方法，就会全部唤醒
 *
 * 说明：
 * wait()、notify()、nofifyAll()三个方法必须使用在同步代码块或同步方法中。
 * 以上三个方法是定义在Object上的
 *
 * 面试题：
 * sleep() 和 wait()的异同
 * 同：一旦执行方法，都可以当前线程进入阻塞状态
 * 异：两个方法声明位置不一样 Thread类中生命的Sleep()  Object中声明wait()
 *    调用的要求不同 sleep()都可以调用 wait()必须在同步代码块或者同步方法中调用
 *    sleep()不会释放 wait会释放
 *
 */
class  Number implements  Runnable{
    private int number = 1;

    public void run() {
        while(true) {
            synchronized (this) {
                notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + " : " + number);
                    number++;
                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
         Number number = new Number();
         Thread t1 =  new Thread(number);
         Thread t2 =  new Thread(number);
         t1.setName("线程一");
         t2.setName("线程二");
         t1.start();
         t2.start();
    }
}
