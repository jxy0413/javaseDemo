package cn.bjfu.StringDemo;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @Auther jxy
 * @Date 2020-07-04
 */
public class JDK8DateTimeTest {
    @Test
    public void testDate(){
        //偏移量的问题
        Date date = new Date(2020-1900,9-1,8);
        System.out.println(date.toString());
        //格式化
    }

    /**
     * LocalDateTime比较常用
     */
    @Test
    public void test1(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        //of():设置指定的年、月、日、时、分、秒
        LocalDateTime of = LocalDateTime.of(2020, 10, 6, 12, 12, 12);
        System.out.println(of);
        //getXXX()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getMinute());
        //Local体现不可变性  withXXX() 设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(21);
        System.out.println(localDate1);
        //添加
        LocalDate localDate2 = localDate.plusMonths(20);
        System.out.println(localDate2);
        //减少
        LocalDate localDate3 = localDate.minusMonths(20);
        System.out.println(localDate3);
    }

    @Test
    public void test3(){
        Instant now = Instant.now();
        System.out.println(now); //本初子午线
        //东八区时间
        System.out.println(now.atOffset(ZoneOffset.ofHours(8)));
        //获取对应的毫秒数
        System.out.println(now.toEpochMilli());
    }

    /**
     * DatezTimeFormatter：格式化活解析日期
     */
    @Test
    public void test4(){
        //方式一：
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = isoLocalDateTime.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(format);
        //解析 字符串---》日期
        TemporalAccessor parse = isoLocalDateTime.parse("2020-07-04T21:55:54.757");
        System.out.println(parse);
        //方式二：本地化相关的格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        String format1 = dateTimeFormatter.format(localDateTime);//20-7-4 下午9:59
        System.out.println(format1);
        //方式三：自定义的格式
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format2 = dateTimeFormatter1.format(LocalDateTime.now());
        System.out.println(format2);
        //解析
        TemporalAccessor parse1 = dateTimeFormatter1.parse("2020-07-04");
        System.out.println(parse1);
    }
}
