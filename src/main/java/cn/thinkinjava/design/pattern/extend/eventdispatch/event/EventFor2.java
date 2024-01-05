package cn.thinkinjava.design.pattern.extend.eventdispatch.event;

/**
 * @author qiuxianbao
 * @date 2024/01/02
 */
public class EventFor2 implements Event {

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
