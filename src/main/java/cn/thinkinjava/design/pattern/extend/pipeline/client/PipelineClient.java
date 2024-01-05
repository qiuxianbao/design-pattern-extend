package cn.thinkinjava.design.pattern.extend.pipeline.client;

import cn.thinkinjava.design.pattern.extend.pipeline.Pipeline;
import cn.thinkinjava.design.pattern.extend.pipeline.StandardPipeline;
import cn.thinkinjava.design.pattern.extend.pipeline.value.PipelineValue;
import cn.thinkinjava.design.pattern.extend.pipeline.context.PipelineContext;
import cn.thinkinjava.design.pattern.extend.pipeline.context.StandardPipelineContext;
import cn.thinkinjava.design.pattern.extend.pipeline.value.ForeTest1Value;
import cn.thinkinjava.design.pattern.extend.pipeline.value.ForeTest2Value;

/**
 * 客户端
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
public class PipelineClient {

    public static void main(String[] args) {
        // 管道
        Pipeline pipeline = new StandardPipeline();

        // 管道中对象
        PipelineValue foreTestValue = new ForeTest1Value();
        PipelineValue graySwitchValue = new ForeTest2Value();
        pipeline.addValue(foreTestValue);
        pipeline.addValue(graySwitchValue);

        // 上下文
        PipelineContext context = new StandardPipelineContext();

        // 调用
        pipeline.invoke(context);
        System.out.println(context.get(PipelineContext.FOR_TEST));

//        ForeTest1Value start
//        ForeTest1Value end
//        ForeTest2Value start
//        ForeTest2Value end
//        true
    }
}
