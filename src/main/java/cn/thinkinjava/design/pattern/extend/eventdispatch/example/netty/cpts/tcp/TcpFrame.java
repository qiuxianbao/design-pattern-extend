package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp;

public class TcpFrame {
	public static final byte START_FLAG1=(byte)0x55;
	public static final byte START_FLAG2=(byte)0xAA;

	public static final int MIN_FRAME_LENGTH=10;
	public static final byte VERSION=(byte)0x10;

	protected int sequence;	//流水号
	protected int length;		//帧长度
	protected byte version;

	public TcpFrame(){
	}
	public TcpFrame(byte version) {
		this.version = version;
	}
	public TcpFrame(byte version, int length) {
		this.version = version;
		this.length = length;
	}

	public TcpFrame(boolean reply, byte version, int length) {
		this.version = version;
		this.length = length;
	}

	public byte getVersion() {
		return version;
	}
	public void setVersion(byte version) {
		this.version = version;
	}

	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	public static void main(String[] args) {
		System.out.println(START_FLAG1);	//85
		System.out.println(START_FLAG2);	//-86
		System.out.println(MIN_FRAME_LENGTH);	//10
		System.out.println(VERSION);	//16
	}
}
