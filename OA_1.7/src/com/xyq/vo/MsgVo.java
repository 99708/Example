package com.xyq.vo;

public class MsgVo {
	private int code;
	private String info;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public MsgVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MsgVo(int code, String info) {
		super();
		this.code = code;
		this.info = info;
	}
	@Override
	public String toString() {
		return "MsgVo [code=" + code + ", info=" + info + "]";
	}
	
	
}
