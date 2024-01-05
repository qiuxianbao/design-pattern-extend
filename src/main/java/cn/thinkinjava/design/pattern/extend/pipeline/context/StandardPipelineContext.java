package cn.thinkinjava.design.pattern.extend.pipeline.context;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文的具体实现
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
public class StandardPipelineContext implements PipelineContext {
    private Map<String, Object> contextMap = new HashMap<>();

    @Override
    public void set(String contextKey, Object contextValue) {
        contextMap.put(contextKey, contextValue);
    }

    @Override
    public Object get(String contextKey) {
        return contextMap.get(contextKey);
    }

}
