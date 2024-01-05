package cn.thinkinjava.design.pattern.extend.eventdispatch.client;

import cn.thinkinjava.design.pattern.extend.eventdispatch.EventDispatcher;
import cn.thinkinjava.design.pattern.extend.eventdispatch.listener.EventListenerManager;
import cn.thinkinjava.design.pattern.extend.eventdispatch.source.EventSource;
import cn.thinkinjava.design.pattern.extend.eventdispatch.source.EventSourceForTest1;
import cn.thinkinjava.design.pattern.extend.eventdispatch.source.EventSourceFor2;
import cn.thinkinjava.design.pattern.extend.eventdispatch.listener.EventListener;
import cn.thinkinjava.design.pattern.extend.eventdispatch.listener.EventListenerForTest;

/**
 * @author qiuxianbao
 * @date 2024/01/02
 */
public class EventClient {

    public static void main(String[] args) {
        // 创建事件监听器
        EventListener eventListener = new EventListenerForTest();
        EventListenerManager.addEventListener(eventListener);

        // 创建事件源
        EventSource eventSource1 = new EventSourceForTest1();
        EventSource eventSource2 = new EventSourceFor2();

        // 发布事件
        EventDispatcher.dispatchEvent(eventSource1.fireEvent());
        EventDispatcher.dispatchEvent(eventSource2.fireEvent());

//        11:50:17.029 [main] INFO cn.thinkinjava.design.pattern.extend.eventdispatch.source.EventSourceForTest1 - EventSourceForTest1 	 fireEvent EventForTest1
//        11:50:17.067 [main] INFO cn.thinkinjava.design.pattern.extend.eventdispatch.listener.EventListenerForTest - EventListenerForTest 	 handler EventForTest1
//        11:50:17.077 [main] INFO cn.thinkinjava.design.pattern.extend.eventdispatch.source.EventSourceFor2 - EventSourceFor2 	 fireEvent EventFor2
    }
}
