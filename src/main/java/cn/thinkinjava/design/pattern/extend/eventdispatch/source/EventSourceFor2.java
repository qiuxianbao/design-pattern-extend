package cn.thinkinjava.design.pattern.extend.eventdispatch.source;

import cn.thinkinjava.design.pattern.extend.eventdispatch.event.Event;
import cn.thinkinjava.design.pattern.extend.eventdispatch.event.EventFor2;
import lombok.extern.slf4j.Slf4j;

/**
 * @author qiuxianbao
 * @date 2024/01/02
 */
@Slf4j
public class EventSourceFor2 implements EventSource {

    @Override
    public Event fireEvent() {
        Event event = new EventFor2();
        log.info("{} \t fireEvent {}", this.getClass().getSimpleName(), event.getName());
        return event;
    }
}
