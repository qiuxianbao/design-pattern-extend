package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp;

import io.netty.channel.Channel;

import java.util.Map;

/**
 * @author qiuxianbao
 * @date 2024/01/08
 */
public class TcpRequest extends TcpFrame {

    protected String method;    //调用的方法，相当于url路径
    protected Map<String, String> params;    //参数，Form表单格式

    protected Channel ctx;

    public TcpRequest() {
        super();
    }

    public TcpRequest(byte version) {
        super(version);
    }

    public TcpRequest(byte version, int length) {
        super(version, length);
    }

    public TcpRequest(byte version, int length, int sequence) {
        super(version, length);
        this.sequence = sequence;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Channel getCtx() {
        return ctx;
    }

    public void setCtx(Channel ctx) {
        this.ctx = ctx;
    }
}