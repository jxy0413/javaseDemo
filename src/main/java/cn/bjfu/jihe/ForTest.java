package cn.bjfu.jihe;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Auther jxy
 * @Date 2020-07-22
 * JDK5.0 新增了foreach循环，用于遍历集合 数组
 */
public class ForTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("jia");
        coll.add("123");
        //for 集合元素的类型 局部变量：集合对象
        for(Object obj:coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        String [] arr = new String[]{"MM","MM","MM"};
        //普通方式for赋值
//        for(int i=0;i<arr.length;i++){
//            arr[i] = "GG";
//        }

        //增强for循环
        for(String s:arr){
            s="GG";
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
