package cn.thinkinjava.design.pattern.extend.filterchain.filter;

import cn.thinkinjava.design.pattern.extend.filterchain.FilterChain;
import cn.thinkinjava.design.pattern.extend.filterchain.request.HttpRequest;

/**
 * 过滤器
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
public interface Filter {
    void doFilter(HttpRequest httpRequest, FilterChain filterChain);
}
