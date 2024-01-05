package cn.thinkinjava.design.pattern.extend.pipeline;

import cn.thinkinjava.design.pattern.extend.pipeline.value.PipelineValue;
import cn.thinkinjava.design.pattern.extend.pipeline.context.PipelineContext;

/**
 * 管道
 *
 * 适用场景：
 * 当你的数据流需要经过很多同等逻辑处理时，可以考虑使用此套路，便于后续扩展
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
public interface Pipeline {

    /**
     * 执行操作
     *
     * @param context 上下文，即要处理的对象
     * @return
     */
    boolean invoke(PipelineContext context);

    /**
     * 添加操作
     *
     * @param value 管道中的操作对象
     * @return
     */
    boolean addValue(PipelineValue value);

    /**
     * 删除操作
     *
     * @param value 管道中的操作对象
     * @return
     */
    boolean removeValue(PipelineValue value);
}
