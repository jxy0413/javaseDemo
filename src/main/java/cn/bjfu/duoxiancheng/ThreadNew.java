package cn.bjfu.duoxiancheng;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther jxy
 * @Date 2020-06-19
 * 创建线程的方式三：实现callabl接口 5。0新增
 *
 * 如何理解实现Cllable接口比实现Runnable接口创建多线程方法强大？
 * 1.call()可以有返回值
 * 2.call（)可以抛出异常，被外面的操作捕获
 * 3.Callable是支持范型的
 */
//1.创建一个实现callable的实现类
class NumThread implements Callable {
    //2。实现call方法，将线程操作声明在call方法中
    public Object call() throws Exception {
        int sum = 0;
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) {
        //3.创建callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4。将callable接口实现类的对象作为FutureTask构造器中
        FutureTask <Integer>futureTask = new FutureTask<Integer>(numThread);
        //5.创造Thread 调用start方法
        new Thread(futureTask).start();
        try {
            //get方法是获取call()的返回值
            Integer sum = futureTask.get();
            System.out.println("总和为: "+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
