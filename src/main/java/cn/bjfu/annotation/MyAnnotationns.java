package cn.bjfu.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Auther jxy
 * @Date 2020-07-14
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationns {
    MyAnnotation[] value();
}
