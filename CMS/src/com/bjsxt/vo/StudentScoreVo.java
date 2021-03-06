package com.bjsxt.vo;

/**
 * 学生成绩实体类
 * @author 997
 *
 */
public class StudentScoreVo {
	
	private int sid;
	private String sname;
	private int grade;
	private String cname;
	private String subname;
	private String tname;
	private double score;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public StudentScoreVo(int sid, String sname, int grade, String cname,
			String subname, String tname, double score) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.grade = grade;
		this.cname = cname;
		this.subname = subname;
		this.tname = tname;
		this.score = score;
	}
	public StudentScoreVo() {
		super();
	}
	@Override
	public String toString() {
		return "StudentScoreVo [sid=" + sid + ", sname=" + sname + ", grade="
				+ grade + ", cname=" + cname + ", subname=" + subname
				+ ", tname=" + tname + ", score=" + score + "]";
	}
}
