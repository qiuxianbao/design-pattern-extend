package cn.thinkinjava.design.pattern.extend.templatefactory.handler;

import cn.thinkinjava.design.pattern.extend.templatefactory.handler.base.PiiDomainFieldHandlerBase;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @author qiuxianbao
 * @date 2024/01/04
 */
@Slf4j
public class ForTestNotSupportFieldHandler extends PiiDomainFieldHandlerBase {

    @Override
    public <T> boolean isSupport(T domain, Field domainField) {
        if (this.getClass().getSimpleName().equalsIgnoreCase(domain.getClass().getSimpleName())) {
            log.info("{} is support, to do some business", this.getClass().getSimpleName());
            return true;
        }
        return false;
    }

    @Override
    public String getPiiDomainMeta() {
        return this.getClass().getSimpleName();
    }
}
