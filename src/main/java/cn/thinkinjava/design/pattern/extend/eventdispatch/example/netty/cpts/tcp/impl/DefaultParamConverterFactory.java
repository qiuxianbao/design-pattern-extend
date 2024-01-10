package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.impl;


import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.converter.ConverterFactory;
import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.converter.ParamConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DefaultParamConverterFactory implements ConverterFactory {

    private Map<Class, ParamConverter> map = new HashMap<>();

    public DefaultParamConverterFactory() {
        map.put(Integer.class, new ParamConverter.String2IntegerConverter());
        map.put(Long.class, new ParamConverter.String2LongConverter());
        map.put(Short.class, new ParamConverter.String2ShortConverter());
        map.put(Byte.class, new ParamConverter.String2ByteConverter());
        map.put(String.class, new ParamConverter.String2StringConverter());
        map.put(Double.class, new ParamConverter.String2DoubleConverter());
        // TODO-QIU: 2024年1月9日, 0009
//		map.put(Date.class,new ParamConverter.String2DateConverter());
    }

    public DefaultParamConverterFactory(Map<Class, ParamConverter> cvt) {
        for (Map.Entry<Class, ParamConverter> entry : cvt.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void addConverter(Class<?> cls, ParamConverter convert) {
        map.put(cls, convert);
    }

    @Override
    public ParamConverter getConverter(Class<?> cls) {
        return map.get(cls);
    }

}
