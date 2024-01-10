package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.client.resource;


import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.TcpRequest;
import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.annotation.TcpMapping;
import org.springframework.stereotype.Component;

/**
 * @author qiuxianbao
 * @date 2024/01/09
 */
@Component
public class CtrlSendResource {

    @TcpMapping(value = "lightBoxParkTopology")
    public void lightBoxParkTopology(TcpRequest request) throws Exception {
        System.out.println("lightBoxParkTopology");
    }

    @TcpMapping(value = "lightBoxOcrRecordCompare")
    public void lightBoxOcrRecordCompare(TcpRequest request) throws Exception {
        System.out.println("lightBoxOcrRecordCompare");
    }
}
