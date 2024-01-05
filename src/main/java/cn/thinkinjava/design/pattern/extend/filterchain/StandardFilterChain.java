package cn.thinkinjava.design.pattern.extend.filterchain;

import cn.thinkinjava.design.pattern.extend.filterchain.request.HttpRequest;
import cn.thinkinjava.design.pattern.extend.filterchain.filter.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiuxianbao
 * @date 2024/01/02
 */
public class StandardFilterChain implements FilterChain {
    private List<Filter> filterList = new ArrayList<>();
    private int currentIndex = 0;

    @Override
    public void doFilter(HttpRequest httpRequest) {
        if (currentIndex == filterList.size()) {
            return;
        }

        Filter filter = filterList.get(currentIndex);
        currentIndex = currentIndex + 1;
        filter.doFilter(httpRequest, this);
    }

    @Override
    public void addFilter(Filter filter) {
        if (filterList.contains(filter)) {
            return;
        }
        filterList.add(filter);
    }
}
