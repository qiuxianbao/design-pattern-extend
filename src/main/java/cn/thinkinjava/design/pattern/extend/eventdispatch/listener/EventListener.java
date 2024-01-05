package cn.thinkinjava.design.pattern.extend.eventdispatch.listener;

import cn.thinkinjava.design.pattern.extend.eventdispatch.event.Event;

/**
 * 事件监听器，处理事件
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
public interface EventListener {

    /**
     * 是否支持此事件
     *
     * @param event
     * @return
     */
    boolean supportEvent(Event event);

    /**
     * 处理事件
     *
     * @return
     */
    boolean handlerEvent(Event event);
}
