package cn.thinkinjava.design.pattern.extend.pipeline.context;

/**
 * 上下文
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
public interface PipelineContext {

    String FOR_TEST = "forTest";

    void set(String contextKey, Object contextValue);

    Object get(String contextKey);
}
