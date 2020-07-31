package cn.bjfu.jihe;

import org.junit.Test;

import java.io.Serializable;
import java.util.*;

/**
 * @Auther jxy
 * @Date 2020-07-17
 * 1、集合数组都是对多个数据进行存储操作的结构，简称java容器
 * 说明：此时的存储，主要是指内存层面的存储，不涉及到持久化的存储
 * 2、数组在存储多个数据方面的特点：
 *   > 一旦初始化以后，其长度就确定了
 *   > 数组一旦定义好 其原书的类型的也就确定了 我们也就只能操作指定类型呢数据了
 * 2、2数组在存储多个数据方面的缺点：
 *    一旦初始化以后，就不能改变长度
 *    数组中提供方法有限，对于添加、删除、插入数据等操作，非常不便，效率也不高
 *    获取数组实际元素的个数，没有现成的方法
 *    数组存储数据的特点：有序、可重复 对于无序、不可重复的需求，不能满足
 * 二、集合框架
 *    |----Collection接口
 *              |------List接口  有序 可重复    动态数组
 *                ArrayList   LinkedList Vector
 *              |------Set接口   无序 不可重复   ---》高中讲的集合
 *                HashSet LinkedHashSet TreeSet
 *    |----Map接口：双类集合 用来存储kv  高中函数 y=f(x)
 *              | HashMap、LinkedHashMap、TreeMap、Hashtbale、properties
 *三、Collection接口中的方法使用
 *
 *
 *
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        //add（）；  //将元素e添加到集合coll中
        coll.add(1);
        coll.add(123);
        //size()l  //获取添加元素的个数
        System.out.println(coll.size());
        //addAll(); //将coll1集合中元素添加到当前的集合中
        Collection<Integer>coll1 = new ArrayList();
        coll1.add(3);
        coll1.addAll(coll);
        System.out.println(coll1.size());
        System.out.println(coll1);
        //clear 清空集合元素
        coll.clear();
        //isEmpty 集合中size是否为0
        System.out.println(coll.isEmpty());
        //contains() 是否包含Obj
        boolean contains = coll.contains(1);
        System.out.println(contains);
        System.out.println(coll.contains("TOM"));
        coll.add(new Person("jia",1));
        System.out.println(coll.contains(new Person("jia",1)));
        //containsAll:判断兴参所有的元素都存在集合中
        List<? extends Serializable> serializables = Arrays.asList("123", 345);
        boolean b = coll.containsAll(serializables);
        System.out.println(b);
    }


    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("jia");
        coll.add("123");
        boolean remove = coll.remove(123);
        //remove 从当前元素中移除元素
        System.out.println(remove);
        //removeAll 从当前集合中移除coll1中所有的元
        Collection coll1 = Arrays.asList("123","43");
        boolean removeAll = coll.removeAll(coll1);
        System.out.println(removeAll);
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("jia");
        coll.add("123");
        //求交集 retainAll 交集：获取当前集合 并返回当前集合
        Collection coll1 = Arrays.asList("123","43");
        coll.retainAll(coll1);
        System.out.println(coll);
        //equals 比较两个对象是否相等的
        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4(){
        //集合转为数组
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("jia");
        coll.add("123");
        Object[] objects = coll.toArray();
        for (int i=0;i<objects.length;i++){
            System.out.println(objects[i]);
        }
        //数组到集合 调用Arrays.asList
        List<Object> objects1 = Arrays.asList(objects);
        System.out.println(objects1);
        //iterator 涉及到返回Iterator接口的实例，用于遍历集合元素
    }

    @Test
    public void test5(){
        //集合转为数组
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("jia");
        coll.add("123");
        //迭代器接口  NoSuchElementException
        Iterator iterator = coll.iterator();
        //推荐方式
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test6(){
        //集合转为数组
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("jia");
        coll.add("123");
        //迭代器接口  NoSuchElementException
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            if("jia".equals(next)){
                iterator.remove();
            }
        }
        //remove在遍历的时候 删除集合的操作
        Iterator iterable1 =coll.iterator();
        while (iterable1.hasNext()){
            System.out.println(iterable1.next());
        }
    }

}
