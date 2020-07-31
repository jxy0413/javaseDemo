package cn.bjfu.duoxiancheng;

/**
 * @Auther jxy
 * @Date 2020-06-15
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window3 w  = new Window3();
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
class Window3 implements Runnable{
    private int ticket = 100;
    // Object object  =new Object();

    public void run() {
        while (ticket>0){
            show();
        }
    }
    private synchronized void show(){
        if(ticket>0){
//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
            System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ticket);
            ticket--;
        }
    }
}
