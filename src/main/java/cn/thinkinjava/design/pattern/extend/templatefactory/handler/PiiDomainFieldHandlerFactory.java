package cn.thinkinjava.design.pattern.extend.templatefactory.handler;

import cn.thinkinjava.design.pattern.extend.templatefactory.handler.base.PiiDomainFieldHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 工厂类
 * 手动添加处理器
 *
 * @author qiuxianbao
 * @date 2024/01/04
 */
public class PiiDomainFieldHandlerFactory {

    /**
     * 创建领域处理器
     *
     * @return
     */
    public static List<PiiDomainFieldHandler> createPiiDomainFieldHandler() {
        List<PiiDomainFieldHandler> piiDomainFieldHandlerList = new ArrayList();
        // 添加处理器
        piiDomainFieldHandlerList.add(new ForTestSupportFieldHandler());
        piiDomainFieldHandlerList.add(new ForTestNotSupportFieldHandler());
        return piiDomainFieldHandlerList;
    }
}
