package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.converter;

/**
 * @author qiuxianbao
 * @date 2024/01/08
 */
public class ParamNode {
    private String paramName;
    private Class<?> paramType;
    private boolean required;
    private ParamConverter convert;

    public ParamNode(String paramName, Class<?> paramType, boolean required, ParamConverter convert) {
        this.paramName = paramName;
        this.paramType = paramType;
        this.required = required;
        this.convert = convert;
    }
    public String getParamName() {
        return paramName;
    }
    public Class<?> getParamType() {
        return paramType;
    }
    public boolean isRequired() {
        return required;
    }
    public ParamConverter getConvert() {
        return convert;
    }
}
