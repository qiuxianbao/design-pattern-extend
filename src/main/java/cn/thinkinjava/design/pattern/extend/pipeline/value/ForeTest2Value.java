package cn.thinkinjava.design.pattern.extend.pipeline.value;

import cn.thinkinjava.design.pattern.extend.pipeline.context.PipelineContext;

/**
 * 管道中的操作对象的具体实现
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
public class ForeTest2Value extends AbstractPipelineValue {

    @Override
    protected boolean doExecute(PipelineContext context) {
        return true;
    }
}
