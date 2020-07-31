package cn.bjfu.duoxiancheng;

/**
 * @Auther jxy
 * @Date 2020-06-17
 *
 * 死锁：
 *   不同的线程分别占用对方的资源需要同步资源不放弃
 *   都在等在对方的资源
 */
public class DeadThread {
    static StringBuffer s1 = new StringBuffer();
    static StringBuffer s2 = new StringBuffer();
    public static void main(String[] args){
        new Thread(new Runnable() {
            public void run() {
                synchronized (s1){
                    s1.append("a");
                    s2.append("1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                synchronized (s2){
                    s1.append("c");
                    s2.append("3");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1){
                        s1.append("d");
                        s2.append("4");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}
