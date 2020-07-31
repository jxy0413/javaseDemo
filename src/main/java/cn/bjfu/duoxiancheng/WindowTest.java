package cn.bjfu.duoxiancheng;

/**
 * @Auther jxy
 * @Date 2020-06-14
 * 例子 ：创建三个窗口卖票 总票数为100张
 * 存在线程安全的问题 待解决
 */
public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        w1.setName("窗口一");
        Window w2 = new Window();
        w2.setName("窗口二");
        Window w3 = new Window();
        w3.setName("窗口三");
        w2.start();
        w1.start();
        w3.start();
    }
}
class  Window extends  Thread{
    private static int ticket = 100;
    //static Object obj = new Object();
    @Override
    public void run() {
            while (true) {
                synchronized (Window.class) { //此时的this就是唯一的Window1对象
                if (ticket > 0) {
                    //还有余票
                    System.out.println(getName() + "：卖票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}