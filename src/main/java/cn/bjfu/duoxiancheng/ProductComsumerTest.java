package cn.bjfu.duoxiancheng;

/**
 * @Auther jxy
 * @Date 2020-06-22
 */
public class ProductComsumerTest {
    public static void main(String[] args) {
        Clerker clerker = new Clerker();
        Thread  proThread = new Thread(new Producers(clerker));
        Thread  consumerThread = new Thread(new Consumers(clerker));
        proThread.setName("生产者一");
        consumerThread.setName("消费者一");
        proThread.start();
        consumerThread.start();
    }
}
//售货员
class Clerker{
    //刚开始0个产品
    private int product=0;
    //开始生产产品
    public synchronized void addProduct(){
        //产品大于20停止生产 太快了
        if(product>20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            product++;
            System.out.println("生产者生产了"+product+"个产品");
            //唤醒我要继续生产
            notifyAll();
        }
    }
    //开始消费产品
    public synchronized void getProduct(){
        //没有产品 停止
        if(product<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("消费者消费了第"+product+"个产品");
            product--;
            notifyAll();
        }
    }
}
class Producers implements Runnable{
    Clerker clerker;
    public Producers(Clerker clerker){
        this.clerker = clerker;
    }
    public void run() {
        System.out.println("生产者开始生产产品");
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerker.addProduct();
        }
    }
}
class Consumers implements Runnable{
    Clerker clerker;
    public Consumers(Clerker clerker){
        this.clerker = clerker;
    }
    public void run() {
        System.out.println("消费者开始生产产品");
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerker.getProduct();
        }
    }
}