package cn.thinkinjava.design.pattern.extend.pipeline.value;

import cn.thinkinjava.design.pattern.extend.pipeline.context.PipelineContext;
import lombok.extern.slf4j.Slf4j;

/**
 * 管道中的操作对象的抽象
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
@Slf4j
public abstract class AbstractPipelineValue implements PipelineValue {

    @Override
    public boolean execute(PipelineContext context) {
        log.info("{} start", this.getClass().getSimpleName());
        boolean result = doExecute(context);
        log.info("{} end", this.getClass().getSimpleName());
        return result;
    }

    /**
     * 由子类实现
     *
     * @param context
     * @return
     */
    protected abstract boolean doExecute(PipelineContext context);
}
