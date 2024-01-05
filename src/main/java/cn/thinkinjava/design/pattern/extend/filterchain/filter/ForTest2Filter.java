package cn.thinkinjava.design.pattern.extend.filterchain.filter;

import cn.thinkinjava.design.pattern.extend.filterchain.FilterChain;
import cn.thinkinjava.design.pattern.extend.filterchain.request.HttpRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * @author qiuxianbao
 * @date 2024/01/02
 */
@Slf4j
public class ForTest2Filter implements Filter {

    @Override
    public void doFilter(HttpRequest httpRequest, FilterChain filterChain) {
        log.info("{} before {}", this.getClass().getSimpleName(), System.currentTimeMillis());
        filterChain.doFilter(httpRequest);
        log.info("{} end {}", this.getClass().getSimpleName(), System.currentTimeMillis());
    }
}
