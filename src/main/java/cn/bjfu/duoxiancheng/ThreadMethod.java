package cn.bjfu.duoxiancheng;

/**
 * @Auther jxy
 * @Date 2020-06-13
 * 测试Thread常用方法：
 * 1。start（）：启动当前线程：调用当前的run（）
 * 2。run（）：通常需要重写Thread()的此方法，将创建的线程执行的操作生命在此方法中
 * 3。currentThread：静态方法，返回当前代码的线程
 * 4。getName():获取当前线程的名字
 * 5。setName（）：设置当前线程的名字
 * 6。yield（）：主动释放当前CPU资源
 * 7。join（）：在线程a中调用线程b的join（） 此时线程a进入阻塞状态 直到b完全执行后 线程a才开始
 * 8。stop（）：使用此方法，强制结束当前线程
 * 9。sleep（）:让当前线程睡眠多久 1000 毫秒数
 * 10。isAlive():判断当前线程是否存活
 * 线程的优先级：
 * public final static int MIN_PRIORITY = 1;
 * public final static int NORM_PRIORITY = 5;
 * public final static int MAX_PRIORITY = 10;
 * 2。如何获取和设置当前线程的优先级
 * getPriority()
 * setPriority(int )
 * 说明 ： 高优先级的线程要抢占低优先级的cpu的执行权，但是只是从概率讲，高优先级的概率大
 */
public class ThreadMethod {
    public static void main(String[] args){
        HelloThread h1 = new HelloThread();
        h1.setName("线程一：");
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
        for(int i =0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
            }
//            System.out.println(h1.isAlive());
//            if(i==20){
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(h1.isAlive());

    }
}

class HelloThread extends Thread{
    @Override
    public void run() {
        for(int i =0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+this.getPriority()+":"+i);
            }
//            if(i%20==0){
//                yield();
//            }

        }
    }
}