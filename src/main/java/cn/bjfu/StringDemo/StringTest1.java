package cn.bjfu.StringDemo;

import org.junit.Test;

/**
 * @Auther jxy
 * @Date 2020-06-29
 * 涉及到String类与其他结构之间的转换
 */
public class StringTest1 {
    @Test
    public void test5(){
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2+"hadoop";
        System.out.println(s1==s3);
        final String s4 = "javaEE";
        String s5 = s4+"hadoop";
        System.out.println(s1==s5);
    }
    /**
     * String与byte[]之前的转换
     * 编码：字符串---》字节 （能看懂 --》看不懂的）
     * String --> byte[]
     * 解码：编码的逆过程
     * byte[] --> String
     */
    @Test
    public void test4(){
        String str = "abc123中国";
        byte[] bytes = str.getBytes(); //使用默认的字符集，进行转换
        for(byte b:bytes){
            System.out.println(b);
        }
        String by = new String(bytes);
        System.out.println(by);
    }

    /**
     * String与char[]之间的转换
     */
    @Test
    public void test3(){
        String str = "abc123";
        char[] chars = str.toCharArray();
        for(char c:chars){
            System.out.println(c);
        }
        char a [] =new char[]{'1','2','2'};
        String str1 =  new String(a);
        System.out.println(str1);
    }
    @Test
    public void test1(){
        String str  = "123";
        int i = Integer.parseInt(str);
        System.out.println(i);
    }
    /**
     * 将基本数据类型 转为String
     */
    @Test
    public void test2(){
        int num = 123;
        String s = String.valueOf(num);
        System.out.println(s);
    }
}
