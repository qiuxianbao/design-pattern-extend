package cn.thinkinjava.design.pattern.extend.annotation.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 客户端
 *
 * @author qiuxianbao
 * @date 2024/01/04
 */
public class ForTestClient {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                "cn.thinkinjava.main.extend.annotation");

        System.out.println(ForTestClient.class.getSimpleName());
    }

}
