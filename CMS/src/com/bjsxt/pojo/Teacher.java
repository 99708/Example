package com.bjsxt.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 教师信息的实体类
 * @author QiaoZH
 *
 */
public class Teacher implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer tid;//教师编号
	private String pwd;
	private Integer rid;
	private Major major;//教师专业信息 *
	private String tname;//教师姓名
	private String sex;//教师性别
	private Integer age;//教师年龄
	private String nation;//民族
	private String party;//政治面貌
	private String education;//学历
	private String marry;//婚姻状况
	private Date birthdate;//出生日期
	private String idcard;//身份证号
	private String phone;//电话
	private Date hiredate;//入职日期
	private String desc;//自我介绍
	
	
	public Teacher(Integer tid, Major major, Integer age, String party,
			String education, String marry, String phone, String desc) {
		super();
		this.tid = tid;
		this.major = major;
		this.age = age;
		this.party = party;
		this.education = education;
		this.marry = marry;
		this.phone = phone;
		this.desc = desc;
	}
	public Teacher(String pwd, Integer rid, Major major, String tname,
			String sex, Integer age, String nation, String party,
			String education, String marry, Date birthdate, String idcard,
			String phone, Date hiredate, String desc) {
		super();
		this.pwd = pwd;
		this.rid = rid;
		this.major = major;
		this.tname = tname;
		this.sex = sex;
		this.age = age;
		this.nation = nation;
		this.party = party;
		this.education = education;
		this.marry = marry;
		this.birthdate = birthdate;
		this.idcard = idcard;
		this.phone = phone;
		this.hiredate = hiredate;
		this.desc = desc;
	}
	public Teacher(Integer tid, String pwd, Integer rid, Major major,
			String tname, String sex, Integer age, String nation, String party,
			String education, String marry, Date birthdate, String idcard,
			String phone, Date hiredate, String desc) {
		super();
		this.tid = tid;
		this.pwd = pwd;
		this.rid = rid;
		this.major = major;
		this.tname = tname;
		this.sex = sex;
		this.age = age;
		this.nation = nation;
		this.party = party;
		this.education = education;
		this.marry = marry;
		this.birthdate = birthdate;
		this.idcard = idcard;
		this.phone = phone;
		this.hiredate = hiredate;
		this.desc = desc;
	}
	public Teacher() {
		super();
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMarry() {
		return marry;
	}
	public void setMarry(String marry) {
		this.marry = marry;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", pwd=" + pwd + ", rid=" + rid
				+ ", major=" + major + ", tname=" + tname + ", sex=" + sex
				+ ", age=" + age + ", nation=" + nation + ", party=" + party
				+ ", education=" + education + ", marry=" + marry
				+ ", birthdate=" + birthdate + ", idcard=" + idcard
				+ ", phone=" + phone + ", hiredate=" + hiredate + ", desc="
				+ desc + "]";
	}
	
}