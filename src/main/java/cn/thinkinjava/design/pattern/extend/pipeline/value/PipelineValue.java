package cn.thinkinjava.design.pattern.extend.pipeline.value;

import cn.thinkinjava.design.pattern.extend.pipeline.context.PipelineContext;

/**
 * 管道中的操作对象
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
public interface PipelineValue {

    /**
     * 具体的操作
     *
     * @param context 上下文
     * @return
     */
    boolean execute(PipelineContext context);
}
