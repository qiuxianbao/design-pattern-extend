package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.impl;

import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.*;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author qiuxianbao
 * @date 2024/01/09
 */
@Component
public class DefaultTcpDispatch implements TcpDispatch {
    private Executor executor;

    @Autowired
    private TcpFinder finder;

    private Integer tcpWorkThreadCount = 32;

    @PostConstruct
    public void init() {
        executor = new ThreadPoolExecutor(tcpWorkThreadCount, tcpWorkThreadCount, 2L, TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(tcpWorkThreadCount * 16));
    }

    @Override
    public void service(ChannelHandlerContext ctx, TcpRequest request) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                TcpResponse response = new TcpResponse(TcpFrame.VERSION);
                response.setSequence(request.getSequence());
                try {
                    TcpFinder.EntityNode entity = finder.lookup(request);
                    if (entity != null) {
                        entity.onService(request, response);
                    } else {
//                        throw new ExtException(ErrorState.InvalidResource);
                    }

//                    ctx.writeAndFlush(response);
                }
//                catch (ExtException ex) {
//                    log.info("request Exception: ", ex);
//                    response.setResult(ex.toString());
//                    ctx.writeAndFlush(response);
//                }
                catch (Throwable e) {
//                    log.info("request Exception: ", e);
//                    response.setResult(ErrorState.RuntimeException.toString());
//                    ctx.writeAndFlush(response);
                }

            }
        });

    }

    @Override
    public void addMethod(String method, TcpFinder.EntityNode entity){
        finder.addMethod(method, entity);
    }

}
