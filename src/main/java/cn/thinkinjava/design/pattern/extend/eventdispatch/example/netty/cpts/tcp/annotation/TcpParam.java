package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.annotation;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TcpParam {
	String[] name() default {};
	boolean required() default true;
	Class<?>[] convert() default {};
}
