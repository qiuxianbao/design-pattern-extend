package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.impl;


import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.TcpFinder;
import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.TcpRequest;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiuxianbao
 * @date 2024/01/09
 */
@Component
public class DefaultTcpFinder implements TcpFinder {

    private Map<String, EntityNode> map=new HashMap<String, EntityNode>();

    @Override
    public EntityNode lookup(TcpRequest request)throws Exception{
        return map.get(request.getMethod());
    }

    @Override
    public void addMethod(String method, EntityNode entity) throws IllegalArgumentException{
        map.put(method, entity);
    }

}
