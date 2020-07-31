package cn.bjfu.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther jxy
 * @Date 2020-07-09
 * 1.理解Annotation
 * jdk5.0新增
 * 2.Annotation 就是类加载
 * 使用实例
 * @Override   方法重载的
 * @Deprecated 过时的
 * @SuppressWarnings 抑制警告
 * 3.如何自定义注解
 *  1.注解声明为 @interface
 *  2.内部定义成员，通过使用value表示
 *  3.可以制定成员的默认值，使用default定义
 *  4.如果自定义注解没有成员,表明是一个标识作用
 *
 *  如果有成员，需要指明成员的值 (使用反射）才有意义
 *
 *  4.jdk提供的元注解 修饰其他注解的Annotation定义
 *  元注解：对现有的注解修饰的注解
 *  Retention:制定所修饰的Annotation的生命周期 SOURCE/CLASS(默认行为）/RUNTIME
 *  只有声明为RUNTIME声明周期的注解,才能通过反射获取
 *  Target:用于制定被修饰的Annotation 能用于修饰哪些程序元素
 *  Documented:表示修饰的注解被javadoc所解析的
 *  Inhreited:被修饰的Annotaion
 *
 *  5.通过反射来获取系统信息
 *  6.jdk8中注解的新特性：可重复注解 类型注解
 *  6.2
 *  TYPE_PARAMETER:
 */
@Deprecated
public class AnnotationTest {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(num);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@MyAnnotationns({@MyAnnotation("h1"),@MyAnnotation("h2")})
class Person{
    private String name;
    private int age;

    public void walk(){
        System.out.println("人走路");
    }

    public void eat(){
        System.out.println("人吃饭");
    }
}

interface Info{
    void show();
}

class Student extends Person implements Info{
    @Override
    public void walk(){
        System.out.println("学生走路");
    }
    public void show() {
        System.out.println("展示方法");
    }
}

