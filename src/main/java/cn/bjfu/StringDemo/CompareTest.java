package cn.bjfu.StringDemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther jxy
 * @Date 2020-07-04
 * 1。说明 Java中的对象 只能进行比较== != 不能使用> 或者<的
 *    但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小
 *    如何实现？使用两个接口中的任何一个 Comparable 或者 Comparator
 * 2。Comparable接口的使用
 *
 * 对比 Comparable接口与Comparator使用对比
 * 一个是一劳永逸 一个是临时
 */
public class CompareTest {
    /**
     * Comparable接口的使用举例：
     * 1.String、包装类实现了Comparable接口 重写了compareTo()方法
     * 2、重写comparezTo(obj)规则
     * 3、像String、包装类重写compareTo规则
     * 4、对于自定义类来说，需要排序我们可以自定义类实现Comparable接口、重写compareTo方法
     */
    @Test
    public void test1(){
        String[] arr  = new String[]{"AA","MM","BB"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[4];
        arr[0]= new Goods("lianxiang",34);
        arr[1]= new Goods("xiaomi",12);
        arr[2]= new Goods("huawei",24);
        arr[3]= new Goods("dell",334);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Comparator接口的使用：订制排序
     * 1。背景 没有实现java.lang.Comparable接口而又不方便改代码
     * 2。重写compare(Object o1,Object o2)的方法
     */
    @Test
    public void test3(){
        String[] arr  = new String[]{"AA","MM","BB"};
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods[] arr = new Goods[4];
        arr[0]= new Goods("lianxiang",34);
        arr[1]= new Goods("xiaomi",12);
        arr[2]= new Goods("huawei",24);
        arr[3]= new Goods("dell",334);
        //产品名称从低到高 在按照价格从高到低
        Arrays.sort(arr, new Comparator<Goods>() {
            public int compare(Goods o1, Goods o2) {
                if(o1.getName().equals(o2.getName())){
                   return - Double.compare(o1.getPrice(),o2.getPrice());
                }else{
                   return o1.getName().compareTo(o2.getName());
                }
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
