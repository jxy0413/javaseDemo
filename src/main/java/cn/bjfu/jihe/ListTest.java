package cn.bjfu.jihe;

import org.junit.Test;

import java.util.*;


/**
 * @Auther jxy
 * @Date 2020-07-22
 * 面试题：ArrayList LinkedList Vector三者的异同
 *
 * 同：三个类实现了List接口，存储有序、可重复的数据  动态数组
 * 不同：
 *     ArrayList 主要实现类  线程不安全 效率高 底层使用Object数组
 *     Vector 作为List接口的古老实现类 线程安全的 效率低  底层使用Object数组
 *     LinkedList 底层使用的是双向链表 对于频繁的插入、删除操作 效率比ArrayList高
 *
 * ArrayList源码分析：jdk 7 、 jdk 8不同
 *     在jdk 7 情况下
 *     List list = new ArrayList(); 空参的造一个长度为10的数组
 *     list.add（123）；// elementData[0] = new Integer(123);
 *     ...
 *     list.add(11); 如果此次添加导致底层elementData数组容量不够，则扩容
 *     默认情况下，扩容是原来容量的1.5倍，同时将原有数组复制到新的数组中
 *     结论：建议开发中使用带参数的构造器：ArrayList list = new ArrayList(容量);
 *     在jdk 8情况下
 *     ArrayList list = new ArrayList();//底层并没有帮咱们创建 初始化为{}
 *     list.add(123); 第一次调用的时候，才创建长度为10的数组，并将123添加到element中
 *     其他无异
 *     小结：节省内存 7对象的创建像饿汉 8对象的创建像懒汉
 * LinkedList源码分析：
 *     LinkedList
 *     LinkedList list = new LinkedList()；
 *     内部声明了Node类型的first和last属性 默认为null
 *     list.add(123);
 *     node体现了双向链表的说法
 *     其中node 就是 底层 双向链表
 * Vector源码分析：
 * jdk7和jdk8中通过Vector    初始化是10 每次扩容是2倍
 */
public class ListTest {
   @Test
   public void testZongjie(){
       /**
        * 增 add(Object obj)
        * 删 remove(int index)
        * 改 set(int index,Object ele)
        * 查 get(int index)
        * 插 add(int index,Object ele)
        * 长度 size()
        * 遍历 1 迭代遍历
        *      2 增强for
        *      3普通的
        */
       List list = new ArrayList();
       list.add(123);
       list.add(345);
       list.add("jia");
       //方式一
       Iterator iterator = list.iterator();
       while (iterator.hasNext()){
           System.out.println(iterator.next());
       }
       System.out.println("********************************");
       //方式二
       for(Object obj:list){
           System.out.println(obj);
       }
       System.out.println("********************************");
       //方式三
       for(int i=0;i<list.size();i++){
           System.out.println(list.get(i));
       }
   }

   @Test
   public void test(){
       List List = new ArrayList();
       List list1 = new Vector();
       List list2 = new LinkedList();
   }
    /**
     * List接口的常用方法
     */
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(345);
        list.add("jia");
        list.add(123);
        System.out.println(list);
        //在index位置添加操作
        list.add(1,"jia1");
        System.out.println(list);
        //addAll
        List<Integer> list1 = Arrays.asList(1, 2, 4);
        list.addAll(list1);
        System.out.println(list.size());
    }

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(345);
        list.add(123);
        int index = list.indexOf(456);
        System.out.println(index);
        int index1 = list.indexOf(123);
        System.out.println(index1);
        //lastIndexOF
        System.out.println(list.lastIndexOf(456));
        Object remove = list.remove("123");
        System.out.println(remove);
        //设置index位置的值
        list.set(1,"CC");
        System.out.println(list);
        //设置一个左闭右开的集合
        List list1 = list.subList(1, 2);
        System.out.println(list1);
    }

    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }
    private void updateList(List list){
        list.remove(2);
    }
}
