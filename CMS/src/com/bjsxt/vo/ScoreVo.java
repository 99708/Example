package com.bjsxt.vo;

/**
 * 班级平均成绩实体类
 * @author 997
 *
 */
public class ScoreVo {
	
	private String  subname;
	private double  avg;
	
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public ScoreVo(String subname, double avg) {
		super();
		this.subname = subname;
		this.avg = avg;
	}
	public ScoreVo() {
		super();
	}
	
	

}
