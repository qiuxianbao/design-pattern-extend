package cn.thinkinjava.design.pattern.extend.filterchain;

import cn.thinkinjava.design.pattern.extend.filterchain.request.HttpRequest;
import cn.thinkinjava.design.pattern.extend.filterchain.filter.Filter;

/**
 * 拦截器链
 *
 * 适用场景：
 * 常见的web请求场景
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
public interface FilterChain {
    void doFilter(HttpRequest httpRequest);
    void addFilter(Filter filter);
}
