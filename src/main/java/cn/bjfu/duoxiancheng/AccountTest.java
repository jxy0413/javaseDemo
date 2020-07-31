package cn.bjfu.duoxiancheng;

/**
 * @Auther jxy
 * @Date 2020-06-17
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元 每次存1000 存3次 每次存完打印账户余额
 * 分析:
 * 1.是否是多线程问题？ 是 两个储蓄
 * 2.是否有共享数据？   有 账户
 * 3.是否有线程安全问题？ 有
 * 4.需要考虑如何解决线程安全问题？ 同步机制
 */
class Account{
     private double balance;

     public Account(double balance){
         this.balance = balance;
     }

     public synchronized void deposite(double amt){
         balance+=amt;
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println(Thread.currentThread().getName()+": 存钱成功，余额为："+balance);
     }
}
class Clustomer extends Thread{
    private Account account;

    public Clustomer (Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            account.deposite(1000);
        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Clustomer c1 = new Clustomer(account);
        Clustomer c2 = new Clustomer(account);
        c1.setName("师琦");
        c2.setName("贾相宇");
        c1.start();
        c2.start();
    }
}
