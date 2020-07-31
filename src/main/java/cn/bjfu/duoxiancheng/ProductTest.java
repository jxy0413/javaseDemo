package cn.bjfu.duoxiancheng;

/**
 * @Auther jxy
 * @Date 2020-06-19
 * 生产者将产品交给店员，而消费者从店员处取走产品
 * 产品一次只能持有固定数量的产品，如果
 *
 * 分析:
 * 1。是否是多线程的问题？是 生产者线程，消费者线程
 * 2。是否有共享数据？是  店员 产品
 * 3。如何解决线程的安全问题 同步机制
 * 4。是否涉及到线程的通信？是
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");
        Comsumer c1 = new Comsumer(clerk);
        c1.setName("消费者1");
        Comsumer c2 = new Comsumer(clerk);
        c2.setName("消费者2");
        p1.start();
        c1.start();
        c2.start();

    }
}
class Clerk{
    private int productCount = 0;

    //生产
    public synchronized void produceProdut() {
        if(productCount<20){
            notify();
            productCount++;
            System.out.println(Thread.currentThread().getName()+":开始生产第"+productCount+"个产品");
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费
    public synchronized void comsumerProdut() {
         if(productCount>0){
             notify();
             System.out.println(Thread.currentThread().getName()+":开始消费第"+productCount+"个产品");
             productCount--;
         }else{
             //等待
             try {
                 wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }
}
class Producer extends Thread{  //生产者
    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":开始生产产品。。。。");
        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProdut();
        }
    }
}
class Comsumer extends Thread{
    private Clerk clerk;

    public Comsumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":开始消费产品。。。。");
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.comsumerProdut();
        }
    }
}