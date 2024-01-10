package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp;

/**
 * @author qiuxianbao
 * @date 2024/01/08
 */
public class TcpResponse extends TcpFrame {

    protected String result;	//返回结果，Json格式

    public TcpResponse(){
        super();
    }

    public TcpResponse(byte version){
        super(version);
    }

    public TcpResponse(byte version,int length){
        super(version,length);
    }

    public TcpResponse(byte version,int length,int sequence){
        super(version,length);
        this.sequence=sequence;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
