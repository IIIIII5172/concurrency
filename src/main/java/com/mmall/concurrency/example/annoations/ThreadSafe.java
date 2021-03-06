package com.mmall.concurrency.example.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author IIIIII
 * @create 2019-01-02-22:58
 * @package com.mmall.concurrency.annoations
 * 课程里用来标记【线程安全】的注解
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {
    String value() default "";
}
