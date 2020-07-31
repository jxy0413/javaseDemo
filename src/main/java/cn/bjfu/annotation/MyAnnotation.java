package cn.bjfu.annotation;

import java.lang.annotation.*;

/**
 * 注解声明为@interface;
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(ElementType.TYPE)
public @interface MyAnnotation {
   String value() default "hello";
}
