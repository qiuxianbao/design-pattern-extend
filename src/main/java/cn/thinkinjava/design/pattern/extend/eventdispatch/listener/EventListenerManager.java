package cn.thinkinjava.design.pattern.extend.eventdispatch.listener;

import java.util.ArrayList;
import java.util.List;

/**
 * 事件监听器管理
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
public class EventListenerManager {

    private static List<EventListener> eventListenerList = new ArrayList<>();

    /**
     * 添加事件监听器
     *
     * @param eventListener
     * @return
     */
    public static boolean addEventListener(EventListener eventListener) {
        if (eventListenerList.contains(eventListener)) {
            return true;
        }
        return eventListenerList.add(eventListener);
    }

    /**
     * 移除事件监听器
     *
     * @param eventListener
     * @return
     */
    public static boolean removeEventListener(EventListener eventListener) {
        if (eventListenerList.contains(eventListener)) {
            return eventListenerList.remove(eventListener);
        }

        return true;
    }

    /**
     * 获取事件监听器
     *
     * @return
     */
    public static List<EventListener> getEventListenerList() {
        return eventListenerList;
    }

}
