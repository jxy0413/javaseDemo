package cn.bjfu.StringDemo;

import org.junit.Test;

/**
 * @Auther jxy
 * @Date 2020-06-22
 */
public class StringTest {
    /**
     * String:字符串，使用一对""引起来表示
     * 1。String声明为final的 不可被继承的
     * 2。String实现了Serializable接口:表示字符串是支持序列化的
     * 3。String实现了Comparable接口：表示String比较大小
     * 4。String在内部定义了final char[] value用于存储字符串数据
     * 体现：1、当对字符串重新赋值，不能在原有的地方赋值
     *      2、当调用replace()方法时候修改字符或者字符串也必须要指定
     * 4.String代表不可变的字符序列 简称：不可变性
     * 5.通过字面量的方式给一个字符串复制
     * 6。字符串常量池是不会比较存储相同的字符串的
     */
    @Test
    public void test1(){
        String s1 = "abc";       //字面量的定义方式
        String s2 = "abc";
        // s1="hello";
        String s3 = "abc";
        s3+="def";
        System.out.println(s3);
        System.out.println(s1==s2);
        System.out.println(s1);
        System.out.println(s2);

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);
        System.out.println(s5);
    }

    /**
     * String实列化方式
     * 1。通过字面量方式
     * 2。通过new+构造器的方式/
     *
     * 面试题 String s = new String("abc") 方式创造了几个对象
     * 两个：一个是堆空间中new结构，另一个是char[对应的常量池中的
     */
    @Test
    public void test2(){
        //常量池
        String s1 = "hadoop";
        String s2 = "hadoop";
        //堆空间
        String s3 = new String("hadoop");
        String s4 = new String("hadoop");
        System.out.println(s1==s2);  //true
        System.out.println(s1==s3);  //false
        System.out.println(s3==s4);  //false

        System.out.println("*****************");
        Person p1 = new Person("Tom",12);
        Person p2 = new Person("Tom",12);
        System.out.println(p1.name.equals(p2.name));
        System.out.println(p1.name==p2.name);
        System.out.println(p1==p2);
        System.out.println(p1.age==p2.age);
        p1.name="Jerry";
        System.out.println(p1.name);
        System.out.println(p2.name);
    }

    /**
     *1。只要有变量 就会在堆空间创建 就是new
     *2。常量➕常量 就会在常量池中的
     */
    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE"+"hadoop";
        String s5 = s1 + s2;
        String s6 = "javaEE"+s2;
        String s7 = s1  +s2;
        System.out.println(s3==s4);//true
        System.out.println(s3==s5);//false
        System.out.println(s3==s6);//false
        System.out.println(s5==s6);//false
        System.out.println(s3==s7);//false

        String s8 = s5.intern();//此时返回值得到的s8使用的常量池是已经存在的
        System.out.println(s3==s8);//true
    }
}
