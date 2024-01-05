package cn.thinkinjava.design.pattern.extend.eventdispatch.event;

/**
 * @author qiuxianbao
 * @date 2024/01/02
 */
public class EventForTest1 implements Event {

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
