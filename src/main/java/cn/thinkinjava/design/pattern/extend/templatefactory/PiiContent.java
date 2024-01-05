package cn.thinkinjava.design.pattern.extend.templatefactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文对象
 *
 * @author qiuxianbao
 * @date 2024/01/04
 */
public class PiiContent {

    public static String FORTEST="fortest";

    private Map<String, Object> piiDataMap = new HashMap<>();

    private Map<String, Object> piiContextMap = new HashMap<>();

    public void putPiiData(String domainFieldName, Object domainFieldValue) {
        piiDataMap.put(domainFieldName, domainFieldValue);
    }

    public Object getPiiData(String domainFieldName) {
        return piiDataMap.get(domainFieldName);
    }

    public void putPiiContext(String contextName, Object contextNameValue) {
        piiContextMap.put(contextName, contextNameValue);
    }

    public Object getPiiContext(String contextName) {
        return piiContextMap.get(contextName);
    }
}
