package cn.bjfu.jihe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jxy on 2020/11/16 0016 21:49
 * Collection、Map的工具类
 * 面试题：Collection 和 Collections区别?
 */
public class CollectionsTest {
    @Test
    public void test(){
        //对List数据进行反转
        List list = new ArrayList();
        list.add(123);
        list.add(345);
        list.add(134);
        list.add(345);
        list.add(134);
        list.add(345);
        list.add(134);
        list.add(345);
        list.add(134);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        //进行随机化处理
        Collections.shuffle(list);
        System.out.println(list);
        //swap
        Collections.swap(list,1,2);
        int frequency = Collections.frequency(list, 134);
        System.out.println(frequency);
    }

    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(345);
        list.add(134);
        list.add(345);
//        List dest = new ArrayList();
//        Collections.copy(dest,list);  //throw new IndexOutOfBoundsException("Source does not fit in dest");
        List list1 = Collections.synchronizedList(list);
        System.out.println(list1);
    }
}
