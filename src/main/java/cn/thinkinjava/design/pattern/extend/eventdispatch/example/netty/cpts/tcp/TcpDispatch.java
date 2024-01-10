package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp;


import io.netty.channel.ChannelHandlerContext;

public interface TcpDispatch {

	void service(ChannelHandlerContext ctx, TcpRequest request);

	void addMethod(String method, TcpFinder.EntityNode resource);
}
