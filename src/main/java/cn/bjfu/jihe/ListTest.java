package cn.bjfu.jihe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @Auther jxy
 * @Date 2020-07-22
 * 面试题：ArrayList LinkedList Vector三者的异同
 * ArrayList 主要实现类  线程不安全 效率高 底层使用Object数组
 *
 * Vector 作为List接口的古老实现类 线程安全的 效率低  底层使用Object数组
 * 同：三个类实现了List接口，存储有序、可重复的数据
 * 不同：
 */
public class ListTest {
   @Test
   public void test(){
       List List = new ArrayList();

   }
}
