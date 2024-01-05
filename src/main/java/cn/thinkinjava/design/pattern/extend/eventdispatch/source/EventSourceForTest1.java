package cn.thinkinjava.design.pattern.extend.eventdispatch.source;

import cn.thinkinjava.design.pattern.extend.eventdispatch.event.Event;
import cn.thinkinjava.design.pattern.extend.eventdispatch.event.EventForTest1;
import lombok.extern.slf4j.Slf4j;

/**
 * @author qiuxianbao
 * @date 2024/01/02
 */
@Slf4j
public class EventSourceForTest1 implements EventSource {

    @Override
    public Event fireEvent() {
        Event event = new EventForTest1();
        log.info("{} \t fireEvent {}", this.getClass().getSimpleName(), event.getName());
        return event;
    }
}
