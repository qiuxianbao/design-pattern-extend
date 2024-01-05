package cn.thinkinjava.design.pattern.extend.eventdispatch.listener;

import cn.thinkinjava.design.pattern.extend.eventdispatch.event.Event;
import lombok.extern.slf4j.Slf4j;

/**
 * @author qiuxianbao
 * @date 2024/01/02
 */
@Slf4j
public class EventListenerForTest implements EventListener {

    @Override
    public boolean supportEvent(Event event) {
        return event.getName().contains("Test");
    }

    @Override
    public boolean handlerEvent(Event event) {
        log.info("{} \t handler {}", this.getClass().getSimpleName(), event.getName());
        return true;
    }
}
