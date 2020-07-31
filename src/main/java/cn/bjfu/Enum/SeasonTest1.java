package cn.bjfu.Enum;

/**
 * @Auther jxy
 * @Date 2020-07-07
 * 使用Enum注解
 * 定义的枚举类 默认继承java.lang.Enum
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 autumn = Season1.AUTUMN;
        System.out.println(autumn);
        Season1[] values = Season1.values();
        for(int i=0;i<values.length;i++){
            System.out.println(values[i]);
        }
        Thread.State[] values1 = Thread.State.values();
        for(int i=0;i<values1.length;i++){
            System.out.println(values1[i]);
        }
        System.out.println("*******************");
        //如果没有找到objName枚举对象，则返回
        Season1 season1 = Season1.valueOf("WINTER");
        season1.show();
        System.out.println(season1);
    }
}

interface Info{
    void show();
}

enum Season1 implements Info{
    SPRING("春天", "春暖花开"){
        public void show() {
            System.out.println("春在哪里");
        }
    },
    SUMMER("夏天", "烈日炎炎"){
        public void show() {
            System.out.println("夏在哪里");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        public void show() {
            System.out.println("秋在哪里");
        }
    },
    WINTER("冬天", "白雪皑皑"){
        public void show() {
            System.out.println("冬在哪里");
        }
    };

    // private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    //私有化类的构造器
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //提供呢当前枚举类的多个对象 public static final

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


}
//4.其他诉求 可以

