package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.converter;


public interface ConverterFactory {
    void addConverter(Class<?> cls, ParamConverter convert);
    ParamConverter getConverter(Class<?> cls);
}
