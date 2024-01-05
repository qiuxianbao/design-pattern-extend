package cn.thinkinjava.design.pattern.extend.filterchain.client;

import cn.thinkinjava.design.pattern.extend.filterchain.FilterChain;
import cn.thinkinjava.design.pattern.extend.filterchain.StandardFilterChain;
import cn.thinkinjava.design.pattern.extend.filterchain.request.HttpRequest;
import cn.thinkinjava.design.pattern.extend.filterchain.request.StandardHttpRequest;
import cn.thinkinjava.design.pattern.extend.filterchain.filter.ForTest1Filter;
import cn.thinkinjava.design.pattern.extend.filterchain.filter.ForTest2Filter;

/**
 * 客户端
 *
 * @author qiuxianbao
 * @date 2024/01/02
 */
public class FilterClient {

    public static void main(String[] args) {
        FilterChain filterChain = new StandardFilterChain();
        filterChain.addFilter(new ForTest1Filter());
        filterChain.addFilter(new ForTest2Filter());

        HttpRequest request = new StandardHttpRequest();
        filterChain.doFilter(request);

        //ForTest1Filter before 1704180891151
        //ForTest2Filter before 1704180891151
        //ForTest2Filter end 1704180891152
        //ForTest1Filter end 1704180891152
    }
}
