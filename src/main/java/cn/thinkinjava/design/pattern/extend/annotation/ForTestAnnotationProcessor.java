package cn.thinkinjava.design.pattern.extend.annotation;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 * 注解解析器
 *
 * @author qiuxianbao
 * @date 2024/01/04
 */
@Component
public class ForTestAnnotationProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 获取目标类是否有ForTestAnnotation注解
        ForTestAnnotation annotation = AnnotationUtils.findAnnotation(AopUtils.getTargetClass(bean),
                ForTestAnnotation.class);

        if (annotation == null) {
            return bean;
        }

        // 处理想要的扩展
        System.out.println(beanName + " has ForTestAnnotation");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
