package cn.bjfu.jihe;

import org.junit.Test;

import java.util.*;

/**
 * Created by jxy on 2020/11/16 15:49
 * |----Map:双列数据，存储key-value对的数据 --类似于高中的函数 y = f(x)
 *          |----HashMap:作为Map的主要实现类； 1.2 线程不安全、效率高  能存储null的key和value
 *                |-----LinkedHashMap 1.4: 保证遍历map元素时，可以按照添加到顺序实现遍历
 *                           原因：在原有的HashMap底层基础上，添加了一对指针，指向前一个跟后一个指针
 *                           频繁的遍历效果好
 *          |----TreeMap:可以按照添加的key-value对进行排序，实现排序遍历 考虑key的实现
 *                       底层使用的红黑树
 *          |----Hashtable:作为古老的  1.0 线程安全、效率低 不能存储null的key和value
 *                     |---Properties 常用来处理配置文件 key和value都是String类型
 * HashMap的底层:数组+链表  jdk1.7
 *               数组+链表+红黑树 jdk1.8
 *
 *面试题：
 *1、HashMap的底层实现原理？
 *2、HashMap和Hashtable的亦同
 *3、CurrentHashMap和Hashtable的亦同
 *
 * 二、Map结构的理解
 *     底层是Entry
 *     Map中的key：无序、不可重复，使用Set存储所有的key
 *     Map中的value: 无序的、可重复的，使用Collection存储所有的value
 *     一个键值对：key-value构成了一个Entry对象
 * 三、HashMap的底层实现原理？
 * jdk7为例子：
 *    HashMap map = new HashMap();
 *    在实例化以后，底层创建了一个是16的一维数组Entry[] table。
 *    .....
 *    map.put(key1,value1)
 *    首先，计算key1的hashCode()计算key1哈希值，经过某种算法计算以后，得到Entry数组中存放位置
 *    如果位置上的数据为空，此时的key1-value1添加成功  情况1
 *    如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据），比较key1和存在的哈希值
 *        如果都不相同，此时key1-value1添加成功  情况2
 *        如果key1的哈希值相同，继续比较：调用key1所在类的equals()方法，比较：
 *        如果equals()返回false:此时key1-value1添加成功  情况3
 *        如果equals()放回true:使用value1替换相同key的value值
 *    补充：关于情况2和情况3：
 *        关于情况2和情况3，此时key-value1和原来的数据以链表的方式存储
 *     不断的添加过程中，当超出临界值时并且要存放的位置非空时候 会涉及到扩容问题，默认的扩容方式：扩容到原来的2倍，并且将原有的数据复制过来
 *
 *     JDK8 相较于jdk7在底层实现方面的不同：
 *     1、new HashMap():底层没有创建长度为16的数组
 *     2、jdk 8底层数组是：Node[]，并非Entry[]
 *     3、首次调用Put方法时候，底层创建长度为16的数组
 *     4、jdk底层结构只有：数组+链表  jdk8 数组+链表+红黑树
 *     当数组的某一个位置的元素以链表存在个数>8并且当前数组的长度>64时
 *     此时索引位置上的所有数据改成红黑树存储
 * 四、LinkedHashMap的底层实现原理（了解）
 *     static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *五、Map常用方法
 * 添加   put
 * 删除   remove
 * 修改   put
 * 查询   get
 * 长度   size
 * 遍历   keySet()/values()/entrySet
 */
public class MapTest {
    /**
     * 向TreeMap创建key-value对象，要求key必须由同一个类创建的对象
     */
    @Test
    public void test6(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else{
                    throw new RuntimeException("类型值异常");
                }
            }
        });
        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",24);
        User u3 = new User("Tom",213);
        User u4 = new User("Jerry",243);
        User u5 = new User("Tom",232);
        User u6 = new User("Jerry",22444);
        map.put(u1,23);
        map.put(u2,24);
        map.put(u3,23);
        map.put(u4,24);
        map.put(u5,23);
        map.put(u6,24);
        Set iteratorEntry = map.entrySet();
        Iterator iterator1 = iteratorEntry.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }

    @Test
    public void test5(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",456);
        //遍历所有的key集 keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("************************");
        //遍历所有的value集合
        Collection values = map.values();
        Iterator iteratorValue = values.iterator();
        while (iteratorValue.hasNext()){
            System.out.println(iteratorValue.next());
        }
        System.out.println("************************");
        //遍历所有的k-v类型
        Set iteratorEntry = map.entrySet();
        Iterator iterator1 = iteratorEntry.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }


    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",456);
        System.out.println(map.get("AA"));
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);
        boolean isExistValue = map.containsValue("123");
        System.out.println(isExistValue);
    }

    @Test
    public void testMethod(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",456);
        map.put("AA",43);
        System.out.println(map);
        //remove(Object obj)
        Object cc = map.remove("BB");
        System.out.println(cc);
        System.out.println(map.remove("CC1"));
        map.clear();
        System.out.println(map.size());
        System.out.println(map);
    }

    @Test
    public void test2(){
        Map map = new HashMap();
        map.put(123,"AA");
        map.put(456,"BBB");
        map.put(125,"CCC");
        System.out.println(map);

        Map map1 = new LinkedHashMap();
        map1.put(123,"AA");
        map1.put(456,"BBB");
        map1.put(125,"CCC");
        System.out.println(map1);
    }

    @Test
    public void test1(){
        Map map = new HashMap();
        map.put(null,null);
        map.put(null,"jia");
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
//        Map map1 = new Hashtable();
//        map1.put(null,null);
    }
}
