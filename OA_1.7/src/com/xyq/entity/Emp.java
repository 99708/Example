package com.xyq.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Emp implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 用户名
	 */
	private String empid;
	private String password;
	/**
	 * 用户真实姓名
	 */
	private String realname;
	private String mgrid;
	private String sex;
	/**
	 * 出生日期
	 */
	private Date birthdate;
	/**
	 * 入职时间
	 */
	private Date hiredate;
	/**
	 * 离职时间
	 */
	private Date leavedate;
	/**
	 * 员工的在职状态  '0-离职  1-在职'
	 */
	private int onduty;
	/**
	 * 员工类型  '1.普通员工  2.管理人员 含经理、总监、总裁等  3.管理员';
	 */
	private int emptype;
	private String phone;
	private String qq;
	private String emercontactperson;
	private String idcard;
	private Dept dept;
	private Position position;
	/**
	 * 上级领导
	 */
	private Emp mgremp;
	/**
	 * 下级员工集合
	 */
	private List<Emp> nextemp;
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Emp(String empid, String realname, Date hiredate, int onduty,
			String phone, Dept dept, Position position) {
		super();
		this.empid = empid;
		this.realname = realname;
		this.hiredate = hiredate;
		this.onduty = onduty;
		this.phone = phone;
		this.dept = dept;
		this.position = position;
	}
	/**
	 * 修改的构造
	 * @param empid
	 * @param realname
	 * @param mgrid
	 * @param birthdate
	 * @param hiredate
	 * @param leavedate
	 * @param onduty
	 * @param phone
	 * @param qq
	 * @param emercontactperson
	 * @param idcard
	 * @param dept
	 * @param position
	 * @param mgremp
	 */
	public Emp(String empid, String realname, String mgrid, Date birthdate,
			Date hiredate, Date leavedate, int onduty, String phone, String qq,
			String emercontactperson, String idcard, Dept dept,
			Position position, Emp mgremp) {
		super();
		this.empid = empid;
		this.realname = realname;
		this.mgrid = mgrid;
		this.birthdate = birthdate;
		this.hiredate = hiredate;
		this.leavedate = leavedate;
		this.onduty = onduty;
		this.phone = phone;
		this.qq = qq;
		this.emercontactperson = emercontactperson;
		this.idcard = idcard;
		this.dept = dept;
		this.position = position;
		this.mgremp = mgremp;
	}

	/**
	 * 作为添加的构造方法
	 * @param empid
	 * @param realname
	 * @param sex
	 * @param birthdate
	 * @param hiredate
	 * @param onduty
	 * @param emptype
	 * @param phone
	 * @param qq
	 * @param emercontactperson
	 * @param idcard
	 * @param dept
	 * @param position
	 * @param mgremp
	 */
	public Emp(String empid, String realname, String sex, Date birthdate,
			Date hiredate, int onduty, int emptype, String phone, String qq,
			String emercontactperson, String idcard, Dept dept,
			Position position, Emp mgremp) {
		super();
		this.empid = empid;
		this.realname = realname;
		this.sex = sex;
		this.birthdate = birthdate;
		this.hiredate = hiredate;
		this.onduty = onduty;
		this.emptype = emptype;
		this.phone = phone;
		this.qq = qq;
		this.emercontactperson = emercontactperson;
		this.idcard = idcard;
		this.dept = dept;
		this.position = position;
		this.mgremp = mgremp;
	}

	public Emp(String empid, String password, String realname, String mgrid,
			String sex, Date birthdate, Date hiredate, Date leavedate,
			int onduty, int emptype, String phone, String qq,
			String emercontactperson, String idcard, Dept dept,
			Position position, Emp mgremp, List<Emp> nextemp) {
		super();
		this.empid = empid;
		this.password = password;
		this.realname = realname;
		this.mgrid = mgrid;
		this.sex = sex;
		this.birthdate = birthdate;
		this.hiredate = hiredate;
		this.leavedate = leavedate;
		this.onduty = onduty;
		this.emptype = emptype;
		this.phone = phone;
		this.qq = qq;
		this.emercontactperson = emercontactperson;
		this.idcard = idcard;
		this.dept = dept;
		this.position = position;
		this.mgremp = mgremp;
		this.nextemp = nextemp;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getMgrid() {
		return mgrid;
	}
	public void setMgrid(String mgrid) {
		this.mgrid = mgrid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Date getLeavedate() {
		return leavedate;
	}
	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}
	public int getOnduty() {
		return onduty;
	}
	public void setOnduty(int onduty) {
		this.onduty = onduty;
	}
	public int getEmptype() {
		return emptype;
	}
	public void setEmptype(int emptype) {
		this.emptype = emptype;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmercontactperson() {
		return emercontactperson;
	}
	public void setEmercontactperson(String emercontactperson) {
		this.emercontactperson = emercontactperson;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Emp getMgremp() {
		return mgremp;
	}
	public void setMgremp(Emp mgremp) {
		this.mgremp = mgremp;
	}
	public List<Emp> getNextemp() {
		return nextemp;
	}
	public void setNextemp(List<Emp> nextemp) {
		this.nextemp = nextemp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", password=" + password + ", realname="
				+ realname + ", mgrid=" + mgrid + ", sex=" + sex
				+ ", birthdate=" + birthdate + ", hiredate=" + hiredate
				+ ", leavedate=" + leavedate + ", onduty=" + onduty
				+ ", emptype=" + emptype + ", phone=" + phone + ", qq=" + qq
				+ ", emercontactperson=" + emercontactperson + ", idcard="
				+ idcard + ", dept=" + dept + ", position=" + position
				+ ", mgremp=" + mgremp + ", nextemp=" + nextemp + "]";
	}
	

}
