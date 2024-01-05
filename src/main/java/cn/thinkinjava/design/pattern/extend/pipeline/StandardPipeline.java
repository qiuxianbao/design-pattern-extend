package cn.thinkinjava.design.pattern.extend.pipeline;

import cn.thinkinjava.design.pattern.extend.pipeline.value.PipelineValue;
import cn.thinkinjava.design.pattern.extend.pipeline.context.PipelineContext;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 管道实现类
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
@Slf4j
public class StandardPipeline implements Pipeline{
    private List<PipelineValue> valueList = new ArrayList<>();

    @Override
    public boolean invoke(PipelineContext context) {
        boolean result = true;
        for (PipelineValue item : valueList) {
            try {
                result = item.execute(context);
                if (!result) {
                    log.error("{}, execute is wrong", this.getClass().getSimpleName());
                }

            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }

        return result;
    }

    @Override
    public boolean addValue(PipelineValue value) {
        if (valueList.contains(value)) {
            return true;
        }

        return valueList.add(value);
    }

    @Override
    public boolean removeValue(PipelineValue value) {
        return valueList.remove(value);
    }
}
