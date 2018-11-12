package com.bjsxt.pojo;

/**
 * 任班主任查询
 * @author HaoziDada
 */
public class MajClasses {
	private int cid;  //班级编号
	private String cname; //班级名称
	private String grade; //年级
	private int mid;  //专业编号
	private String mname;  //专业名称
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "MajClasses [cid=" + cid + ", cname=" + cname + ", grade="
				+ grade + ", mid=" + mid + ", mname=" + mname + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cid;
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + mid;
		result = prime * result + ((mname == null) ? 0 : mname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MajClasses other = (MajClasses) obj;
		if (cid != other.cid)
			return false;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (mid != other.mid)
			return false;
		if (mname == null) {
			if (other.mname != null)
				return false;
		} else if (!mname.equals(other.mname))
			return false;
		return true;
	}
	public MajClasses(int cid, String cname, String grade, int mid, String mname) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.grade = grade;
		this.mid = mid;
		this.mname = mname;
	}
	public MajClasses() {
		super();
	}
	
}
