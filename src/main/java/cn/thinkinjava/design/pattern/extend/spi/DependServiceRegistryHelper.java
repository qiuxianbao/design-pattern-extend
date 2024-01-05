package cn.thinkinjava.design.pattern.extend.spi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiuxianbao
 * @date 2024/01/02
 */
public class DependServiceRegistryHelper {

    /**
     * 存储策略依赖的服务, 统一管理
     */
    private static Map<String, Object> dependManagerMap = new HashMap<>();

    public static boolean registryMap(Map<Class, Object> dependManagerMap) {
        for (Map.Entry<Class, Object> dependEntry : dependManagerMap.entrySet()) {
            registry(dependEntry.getKey(), dependEntry.getValue());
        }
        return true;
    }

    public static boolean registry(Class cls, Object dependObject) {
        dependManagerMap.put(cls.getCanonicalName(), dependObject);
        return true;
    }


    public static Object getDependObject(Class cls) {
        return dependManagerMap.get(cls.getCanonicalName());
    }
}
