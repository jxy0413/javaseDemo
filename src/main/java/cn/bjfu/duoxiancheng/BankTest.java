package cn.bjfu.duoxiancheng;

/**
 * @Auther jxy
 * @Date 2020-06-17
 * 使用同步机制 将单例模式中的懒汉试改写为线程安全的
 */
public class BankTest {

}
class Bank{
    private Bank(){};

    private static Bank instance = null;

    //方式一：效率稍差
//    public static synchronized Bank getInstance(){
//        if(instance==null){
//            instance = new Bank();
//        }
//        return instance;
//    }

    //方式二：效率稍高
    public static Bank getInstance(){
        if(instance==null){
            synchronized (Bank.class){
                if(instance==null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}