package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts;

/**
 * 模拟Netty接收服务端请求
 *
 * @author qiuxianbao
 * @date 2024/01/09
 */

import cn.thinkinjava.design.pattern.extend.DesignPatternExtendApplication;
import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.TcpDispatch;
import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.TcpRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

@SpringBootTest(classes = DesignPatternExtendApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EventNettyCptsClientTest {

    @Autowired
    private TcpDispatch tcpDispatch;

    /**
     * channelRead0(ChannelHandlerContext ctx, TcpFrame frame)
     */
    @Test
    public void testChannelRead0() {
        TcpRequest request = new TcpRequest();
        request.setMethod("lightBoxParkTopology");
        request.setParams(new HashMap<String, String>() {{
            put("lightBoxParkTopology", "true");
        }});

        tcpDispatch.service(null, request);

        //
        TcpRequest request2 = new TcpRequest();
        request2.setMethod("lightBoxOcrRecordCompare");
        request2.setParams(new HashMap<String, String>() {{
            put("lightBoxOcrRecordCompare", "true");
        }});

        tcpDispatch.service(null, request2);
    }

}
