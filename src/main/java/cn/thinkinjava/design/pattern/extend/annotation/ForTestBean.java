package cn.thinkinjava.design.pattern.extend.annotation;

/**
 * 代测试的Bean
 *
 * @author qiuxianbao
 * @date 2024/01/04
 */
@ForTestAnnotation
public class ForTestBean {

    public ForTestBean() {
        System.out.println(ForTestBean.class.getSimpleName() + " init");
    }

}
