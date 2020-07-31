package cn.bjfu.duoxiancheng;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther jxy
 * @Date 2020-06-22
 */
public class AccountBank {
    public static void main(String[] args) {
        Accounts account = new Accounts(3000);
        Clustomers c1 = new Clustomers(account);
        Clustomers c2 = new Clustomers(account);
        c1.setName("师琦");
        c2.setName("贾相宇");
        c1.start();
        c2.start();
    }
}
class Accounts{
    private double balance;
    public Accounts(double balance){
        this.balance=balance;
    }
    private ReentrantLock lock = new ReentrantLock(true);
    public void cosumerMoney(double amt){
            lock.lock();
            try {
                if(balance>=amt){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    balance-=amt;
                    System.out.println(Thread.currentThread().getName()+": 成功取钱："+amt+",当前余额为："+balance);
                }else{
                    System.out.println("余额不足,不能取钱");
                }
            }finally {
                lock.unlock();
            }
    }
}
class Clustomers extends Thread{
    private Accounts account;

    public Clustomers (Accounts account){
        this.account = account;
    }

    @Override
    public void run() {
            account.cosumerMoney(2000);
    }
}