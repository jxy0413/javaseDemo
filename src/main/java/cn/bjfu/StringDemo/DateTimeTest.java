package cn.bjfu.StringDemo;

import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @Auther jxy
 * @Date 2020-07-01
 * JDK 8之前日期和时间的API测试
 */
public class DateTimeTest {
    /**
     * Calendar 日历类的使用
     */
    @Test
    public void test5(){
        //1.实例化
        //方式一：创建其子类
        Calendar calendar = Calendar.getInstance();
        //2.常用方法
        //get
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //set
        calendar.set(Calendar.DAY_OF_MONTH,22);
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        //getTime:日历--》date
        Date time = calendar.getTime();
        //setTime():Date ---> 日历类
        Date date = new Date();
        calendar.setTime(date);
    }


    /**
     * SimpleDateFormat的使用：SimpleDateFormat对日期类的格式化和解析
     * 1.1 格式化 日期---》字符串
     * 1.2 解析：格式化的逆过程 字符串--》日期
     * 2。SimpleDateFormat的方法
     */
    @Test
    public void test3(){
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化 日期--》字符串
        Date date = new Date();
        //使用默认的构造器
        String format = sdf.format(date);
        System.out.println(format);
        //解析 格式化的逆过程,字符串---》日期
        String str = "2020-07-06 上午11:25";
        try {
            Date parse = sdf.parse(str);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //*************************************
        //解析 必须按照一些格式
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = simpleDateFormat1.format(date);
        System.out.println(format1);
        //解析
        try {
            Date parse = simpleDateFormat1.parse("2020-07-04 11:32:28");
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * 联系一: 字符串 "2020-09-08" 转为java.sql.Date
     */
    @Test
    public void test4(){
        String birth = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = sdf.parse(birth);
            java.sql.Date birthDay = new java.sql.Date(parse.getTime());
            System.out.println(birthDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    /**
     * java.util.Date类
     *        |---java.sql.Date类
     * 1.两个构造器的使用
     * 2.两个方法的使用
     *     toString():显示当前的年、月、日、时、分、秒
     * 3.java.sql.Date 对应着数据库的日期
     * 如何实例化
     * sql.Date ===> util.Date 直接多态
     * util.Date ===> sql.Date
     */
    @Test
    public void test2(){
        //构造器-：Date() 创建一个当前时间的Date对象
        Date date = new Date();
        System.out.println(date.toString()); //Thu Jul 02 17:06:28 CST 2020
        System.out.println(date.getTime());  //1593680853098
        Date date1 = new Date(1593680853098L);
        System.out.println(date1.toString());

        Date date2 = new Date();
        java.sql.Date date7 = new java.sql.Date(date2.getTime());
        System.out.println(date7);
    }
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年的毫秒的时间戳
        System.out.println(time);
    }
}
