package cn.thinkinjava.design.pattern.extend.templatefactory.client;

import cn.thinkinjava.design.pattern.extend.templatefactory.PiiContent;
import cn.thinkinjava.design.pattern.extend.templatefactory.PiiHandlerRegistry;
import cn.thinkinjava.design.pattern.extend.templatefactory.handler.ForTestNotSupportFieldHandler;
import cn.thinkinjava.design.pattern.extend.templatefactory.handler.ForTestSupportFieldHandler;
import cn.thinkinjava.design.pattern.extend.templatefactory.handler.base.PiiDomainFieldHandler;

import java.util.Map;

/**
 * 客户端
 *
 * @author qiuxianbao
 * @date 2024/01/04
 */
public class PiiClient {

    public static void main(String[] args) {
        // 通过工厂，把处理器放到Map中
        PiiHandlerRegistry.init();

        // 遍历处理器
        for (Map.Entry<String, PiiDomainFieldHandler> entryHandler :
                PiiHandlerRegistry.getPiiDomainFieldHandlerMap().entrySet()) {
            System.out.println(entryHandler.getKey() + "\t" + entryHandler.getValue().getPiiDomainMeta());
        }

        //
        PiiContent piiContent = new PiiContent();
        piiContent.putPiiContext(PiiContent.FORTEST, PiiContent.FORTEST);

        // 请求处理
        System.out.println("ForTestSupportFieldHandler start");
        PiiHandlerRegistry.handlerRead(new ForTestSupportFieldHandler(), null, piiContent);
        System.out.println("ForTestSupportFieldHandler end");

        // 请求处理
        System.out.println("ForTestNotSupportFieldHandler start");
        PiiHandlerRegistry.handlerRead(new ForTestNotSupportFieldHandler(), null, piiContent);
        System.out.println("ForTestNotSupportFieldHandler end");
    }
}
