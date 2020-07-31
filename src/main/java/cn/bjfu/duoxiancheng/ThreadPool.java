package cn.bjfu.duoxiancheng;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther jxy
 * @Date 2020-06-19
 * 创建线程的方法：使用线程池
 */
class NumberThread implements Runnable{
    public void run() {
       for(int i=0;i<=100;i++){
           if(i%2==0){
               System.out.println(i);
           }
       }
    }
}
class NumberThread1 implements Runnable {
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //提供指定线程数量的线程池
        ThreadPoolExecutor executorService =(ThreadPoolExecutor)Executors.newFixedThreadPool(10);
        //执行指定的线程池
        executorService.execute(new NumberThread());  //适合Runnable
        executorService.execute(new NumberThread1());
        //executorService.submit();//适合Callable
        //关闭线程池
        executorService.shutdown();
    }
}
