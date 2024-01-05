package cn.thinkinjava.design.pattern.extend.eventdispatch.source;

import cn.thinkinjava.design.pattern.extend.eventdispatch.event.Event;

/**
 * 事件源
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
public interface EventSource {

    /**
     * 发出事件
     *
     * @return
     */
    Event fireEvent();
}
