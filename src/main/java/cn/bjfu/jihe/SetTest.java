package cn.bjfu.jihe;

import org.junit.Test;

import java.util.*;

/**
 * Created by jxy on 2020/11/15 0015 20:55
 * 1、Set接口框架结构   储存无序、不可重复的数据 高中讲的集合
 *     ---HashSet:作为Set接口的主要实现类，线程不安全，可以存储null值
 *           ---LinkedHashSet: 作为HashSet的子类，遍历内部数据时候，可以按照添加的顺序
 *     ---TreeSet:底层是红黑树 可以按照添加对象的指定属性，进行排序
 */
public class SetTest {
    /**
     * Set 存储无序的、不可重复的数据
     * 以HashSet为例说明：
     * 1、无序性：不等于随机性，存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的
     * 2、不可重复性：保证添加的元素按照equals方法，不能返回true,只能返回false，及相同的元素只能添加一个
     *
     * 二、添加元素的过程：以HashSet为例：
     * 我们向HashSet添加元素a，首先调用元素a所在类的hashCode方法，计算元素a的哈希值
     * 此哈希值通过某种算法在HashSet底层数组的存放位置，我们判断数组此位置上是否已经有元素
     * 如果此位置没有其他元素，则元素a直接添加成功 如果此位置上有其他元素b(或者已经存在多个元素)
     * 首先比较元素a与元素b的hash值，如果hash值不相同，则元素a添加成功，如果hash值相同，进而调用elulas方法
     * 返回true,添加失败   equlas 返回false 添加成功
     *
     * 对于添加成功的情况2和情况3而言：元素a与已经存在索引位置上的数据以链表的方式进行存储
     * jdk7：元素a放到数组中，指向原来的元素
     * jdk8: 原来的元素放在数组中，指向元素a
     * 底层是数组，初始容量16 当使用率超过0.75 扩容为原来的2倍
     *
     * 1、Set接口没有新的定义方法，使用的都是Collection的方法
     * 2、所在类一定要重写hashCode和equlas方法
     */
    @Test
    public void test(){
         Set set = new HashSet();
         set.add(123);
         set.add(456);
         set.add("AAA");
         set.add(123);
         set.add("BBB");
         set.add(new User("jia",1));
         set.add(new User("jia",1));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet的使用
    //作为HashSet的子类 在原有的HashSet的基础的上 有一个双向链表
    //在添加数据的同时，每个数据还维护了两个引用，记录了前一个跟后一个数据
    //优点：对于频繁的遍历操作，LinkedHashSet效率要高一些
    @Test
    public void test1(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("AAA");
        set.add(123);
        set.add("BBB");
        set.add(new User("jia",1));
        set.add(new User("jia",1));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * TreeSet
     * 1、向TreeSet中添加的数据，要求是相同类来比较大小，不能是不同类的对象 默认是从小到大的顺序
     * 比较两个对象是否相同的标准是：compareTo 返回0 不在是equlas
     */
    @Test
    public void test2(){
        Set set = new TreeSet();
//        set.add(123);
//        set.add(456);
//        set.add(-12);
//        set.add(123);
        set.add(new User("jia1",11));
        set.add(new User("jia1",12));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3(){
       //按照年龄从小到大
       Comparator com = new Comparator() {
           @Override
           public int compare(Object o1, Object o2) {
               if(o1 instanceof User && o2 instanceof User){
                   return Integer.compare(((User) o1).getAge(),((User) o2).getAge());
               }else{
                   throw new RuntimeException();
               }
           }
       };
       TreeSet set = new TreeSet(com);
        set.add(new User("jia1",12));
        set.add(new User("jia1",12));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
