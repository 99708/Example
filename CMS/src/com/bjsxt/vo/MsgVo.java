package com.bjsxt.vo;

/**
 * 状态实体类
 * @author 997
 *
 */
public class MsgVo {
	private String code;//状态码
	private String info;//响应信息
	public MsgVo(String code, String info) {
		super();
		this.code = code;
		this.info = info;
	}
	public MsgVo() {
		super();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
