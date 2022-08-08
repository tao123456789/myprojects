package com.example.token.Annotation;

import java.lang.annotation.*;

/**
 * @Target说明了Annotation所修饰的对象范围
 * @Retention定义了该Annotation被保留的时间长短：
 * @Documented用于描述其它类型的annotation应该被作为被标注的程序成员的公共API
 */
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AspectLogAnnptation {
    boolean argsWhith() default true;
}
