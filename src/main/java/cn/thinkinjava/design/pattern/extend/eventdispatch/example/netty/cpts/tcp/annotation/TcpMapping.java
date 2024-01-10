package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.annotation;

import java.lang.annotation.*;

/**
 *
 * @author qiuxianbao
 * @date 2024/01/08
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TcpMapping {
    String[] value() default {};
}
