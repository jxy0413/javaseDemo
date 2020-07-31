package cn.bjfu.Enum;

import lombok.Data;
import lombok.ToString;

/**
 * @Auther jxy
 * @Date 2020-07-07
 * 枚举类的使用：
 * 1。枚举类的理解：类的对象只有有限个，确定呢 我们称此类为枚举类
 * 2。当需要定义一组常量时，强烈建议使用枚举类
 * 3。如何枚举类只有一个对象，就是单例模式
 *
 * 二、如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0，可以使用enum关键字定义枚举类
 *
 * 四、使用enum实现接口使用
 *    情况一：实现接口，在enum类中实现
 *    情况二：
 */
public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);

    }
}
//自定义枚举类
@Data
@ToString
class Season{
    // private final 修饰
    private final String seasonName;
    private final String seasonDesc;
    //私有化类的构造器
    private Season(String seasonName,String seasonDesc){
         this.seasonName = seasonName;
         this.seasonDesc = seasonDesc;
    }
    //提供呢当前枚举类的多个对象 public static final
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","烈日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","白雪皑皑");

    //4.其他诉求 可以
}