package cn.thinkinjava.design.pattern.extend.templatefactory.handler.base;

import cn.thinkinjava.design.pattern.extend.templatefactory.PiiContent;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * 模板方法
 * 通过抽象类实现
 *
 * @author qiuxianbao
 * @date 2024/01/04
 */
@Slf4j
public abstract class PiiDomainFieldHandlerBase implements PiiDomainFieldHandler{

    @Override
    public <T> boolean handlerRead(T domain, Field domainField, PiiContent piiContent) {
        log.info("{} handlerRead {}", this.getClass().getSimpleName(), domain.getClass().getSimpleName());
       return true;
    }

    @Override
    public <T> boolean handlerWrite(T domain, Field domainField, PiiContent piiContent) {
        log.info("{} handlerWrite {}", this.getClass().getSimpleName(), domain.getClass().getSimpleName());
        return true;
    }
}
