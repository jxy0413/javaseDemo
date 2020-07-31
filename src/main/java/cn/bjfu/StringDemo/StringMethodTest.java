package cn.bjfu.StringDemo;

import org.junit.Test;

/**
 * @Auther jxy
 * @Date 2020-06-24
 */
public class StringMethodTest {
    @Test
    public void test4(){
        int sum = 0;
        for(int i=0;i<10000000;i++){
            sum++;
        }
        System.out.println(sum);
        String str ="hell0";
    }

    @Test
    public void test3(){
        String s1 = "helloworld";
        boolean ld = s1.endsWith("ld");
        System.out.println(ld);
        boolean he = s1.startsWith("He");
        System.out.println(he);
        String s2 = "wo";
        System.out.println(s1.contains(s2));
        System.out.println(s1.indexOf("lo"));
        System.out.println(s1.indexOf("lo",5));
        System.out.println(s1.lastIndexOf("lo"));
        //什么情况下，调用indexOf(str)和lastIndexOf(Str)返回值相同
        //存在唯一 或者不存在
    }


    @Test
    public void test2(){
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        String s3 =  "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);
        String s5 = "abc";
        String s6 = new String("abd");
        System.out.println(s5.compareTo(s6));
        String s7 = "北京林业大学";
        System.out.println(s7.substring(2));
        System.out.println(s7.substring(2,4));

    }

    @Test
    public void test1() {
        StringBuilder sb = new StringBuilder();
        String s1 = "helloWorld";
        System.out.println(s1.length());
        char c = s1.charAt(0);
        System.out.println(c);
        System.out.println(s1.toLowerCase());
        System.out.println(s1);
        String s3 = " he ll o world";
        String s4 = s3.trim();
        System.out.println(s3);
        System.out.println(s4);
    }
}
