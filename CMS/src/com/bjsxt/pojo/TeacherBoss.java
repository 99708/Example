package com.bjsxt.pojo;

/**
 * 班主任实体类
 * @author HaoziDada
 */
public class TeacherBoss {
	private int tid; //教师编号
	private String tname; //教师姓名
	private String sex; //教师性别
	private String cname; //任课班级
	private int grade; //任课年级
	private String mname; //任课专业
	private String hiredate; //任职时间
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "TeacherBoss [tid=" + tid + ", tname=" + tname + ", sex=" + sex
				+ ", cname=" + cname + ", grade=" + grade + ", mname=" + mname
				+ ", hiredate=" + hiredate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + grade;
		result = prime * result
				+ ((hiredate == null) ? 0 : hiredate.hashCode());
		result = prime * result + ((mname == null) ? 0 : mname.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + tid;
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
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
		TeacherBoss other = (TeacherBoss) obj;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (grade != other.grade)
			return false;
		if (hiredate == null) {
			if (other.hiredate != null)
				return false;
		} else if (!hiredate.equals(other.hiredate))
			return false;
		if (mname == null) {
			if (other.mname != null)
				return false;
		} else if (!mname.equals(other.mname))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (tid != other.tid)
			return false;
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		return true;
	}
	public TeacherBoss(int tid, String tname, String sex, String cname,
			int grade, String mname, String hiredate) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.sex = sex;
		this.cname = cname;
		this.grade = grade;
		this.mname = mname;
		this.hiredate = hiredate;
	}
	public TeacherBoss() {
		super();
	}
	
}
