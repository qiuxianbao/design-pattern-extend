package cn.thinkinjava.design.pattern.extend.eventdispatch;

import cn.thinkinjava.design.pattern.extend.eventdispatch.event.Event;
import cn.thinkinjava.design.pattern.extend.eventdispatch.listener.EventListener;
import cn.thinkinjava.design.pattern.extend.eventdispatch.listener.EventListenerManager;
import org.apache.commons.collections.CollectionUtils;

/**
 * 事件分发器
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
public class EventDispatcher {

    private EventDispatcher() {
    }

    /**
     * 分发事件
     *
     * @param event
     */
    public static void dispatchEvent(Event event) {
        if (CollectionUtils.isNotEmpty(EventListenerManager.getEventListenerList())) {
            for (EventListener eventListener : EventListenerManager.getEventListenerList()) {
                if (eventListener.supportEvent(event)) {
                    eventListener.handlerEvent(event);
                }
            }
        }
    }
}
