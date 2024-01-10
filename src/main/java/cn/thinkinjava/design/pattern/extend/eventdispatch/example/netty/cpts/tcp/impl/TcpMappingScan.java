package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.impl;

import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.TcpDispatch;
import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.TcpFinder;
import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.TcpRequest;
import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.TcpResponse;
import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.annotation.TcpMapping;
import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.annotation.TcpParam;
import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.converter.ConverterFactory;
import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.converter.ParamConverter;
import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.converter.ParamNode;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author qiuxianbao
 * @date 2024/01/08
 */
@Component
public class TcpMappingScan implements BeanPostProcessor {

    @Autowired
    private TcpDispatch tcpDispatch;
    @Autowired
    private ConverterFactory converterFactory;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithMethods(bean.getClass(), new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                ParamNode[] params = filterMethod(method, converterFactory);
                TcpMapping mthAno = method.getAnnotation(TcpMapping.class);
                for (String mtd : mthAno.value()) {
                    tcpDispatch.addMethod(mtd, new TcpFinder.EntityNode(method, params, bean));
                }
            }
        }, new ReflectionUtils.MethodFilter() {
            @Override
            public boolean matches(Method method) {
                return method.getAnnotation(TcpMapping.class) != null;
            }
        });

        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public ParamNode[] filterMethod(Method method, ConverterFactory cnverterFactory) {
        Class<?> paramTypes[] = method.getParameterTypes();
        Annotation[][] paramAno = method.getParameterAnnotations();
        String paramNames[] = new LocalVariableTableParameterNameDiscoverer().getParameterNames(method);
        ParamNode[] params = new ParamNode[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> paramType = paramTypes[i];
            String paramName = paramNames[i];
            @SuppressWarnings("rawtypes")
            ParamConverter convert = null;
            boolean required = false;
            if (!paramType.isAssignableFrom(TcpRequest.class) &&
                    !paramType.isAssignableFrom(TcpResponse.class)) {

                Annotation[] ano = paramAno[i];
                for (Annotation a : ano) {
                    if (a.annotationType() == TcpParam.class) {
                        String[] name = ((TcpParam) a).name();
                        if (name.length > 0) {
                            paramName = name[0];
                        }
                        required = ((TcpParam) a).required();
                        Class<?>[] cvt = ((TcpParam) a).convert();
                        if (cvt.length > 0) {
                            convert = cnverterFactory.getConverter(cvt[0]);
                        } else {
                            convert = cnverterFactory.getConverter(paramType);
                        }
                        break;
                    }
                }
                if (paramName == null) {
                    throw new IllegalArgumentException("param lose ");
                }
            }
            params[i] = new ParamNode(paramName, paramType, required, convert);
        }
        return params;
    }
}
