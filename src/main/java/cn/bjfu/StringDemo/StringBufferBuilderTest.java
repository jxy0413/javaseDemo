package cn.bjfu.StringDemo;

import org.junit.Test;

/**
 * @Auther jxy
 * @Date 2020-07-01
 * 关于StringBuffer和StringBuilder的使用
 */
public class StringBufferBuilderTest {
    /**
     * String StringBuffer StringBuilder三者的异同
     * String：不可变的字符序列  底层结构使用char数组
     * StrignBuffer:可变的字符序列   线程安全的 效率低 底层结构使用char数组
     * StringBuilder:可变的字符序列  jdk5.0新增的 线程不安全 效率高  底层结构使用char数组
     *
     * 源码分析：
     * String str = new String(); //new char[0]
     * String str1 = new String("abc"); new char[]{'a','b','c'}
     *
     * StringBuffer sb = new StringBuffer();  //new char[16]; 底层创建了一个长度为16的数组
     * sb.append('a'); //value[0]='a'
     * sb.append('b'); //value[0]='b'
     *
     * StringBuffer sb2 = new StringBuffer("abc"); /底层创建了一个长度为16的数组+本身的长度
     * 扩容问题：如果要添加的数据底层数组盛不下了，那么就扩容底层的数组
     * 默认情况下，扩容为原来容量的二倍+2，同时将原有的元素复制到新的数组
     * append()
     * StringBuffer(int capacity) 扩容 或者StringBuilder(int capacity)
     */
     @Test
     public void test1() {
         StringBuffer sb = new StringBuffer("abc");
         sb.setCharAt(0, 'm');
         System.out.println(sb);
     }

    /**
     * StringBuffer的常用方法
     * 总结:
     * 增 append、删 delete、改 replace、查charAt、插insert、遍历for()
     */
     @Test
     public void testMethod(){
        StringBuffer s1 = new StringBuffer();
        //添加
        s1.append("abc");
        System.out.println(s1);
        //删除
        s1.delete(0,1);
        System.out.println(s1);
        //替换
        s1.replace(1,2,"hello");
        System.out.println(s1);
        //插入
        s1.insert(2,"hh");
        System.out.println(s1);
        System.out.println(s1.length());
        //反转
        System.out.println(s1.reverse());
     }

    /**
     * StringBuilder StringBuffer String的效率越来越低
     */
}
