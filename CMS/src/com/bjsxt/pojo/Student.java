package com.bjsxt.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 学生信息的实体类
 * @author QiaoZH
 *
 */

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer sid;//学号
	private String pwd;
	private Integer rid;
	private String sname;//姓名
	private String sex;//性别
	private Integer age;//年龄
	private String idcard;//身份证号
	private Date birthdate;//生日
	private String party;//政治面貌
	private String phone;//电话
	private String address;//住址
	private String health;//健康状况
	private Major major;//专业信息
	private Classes classes;//班级信息
	private Integer gcode;//年级
	private Date enterdate;//入学日期
	
	
	public Student(Integer sid, Integer age, String party, String phone,
			String address, String health, Major major, Classes classes) {
		super();
		this.sid = sid;
		this.age = age;
		this.party = party;
		this.phone = phone;
		this.address = address;
		this.health = health;
		this.major = major;
		this.classes = classes;
	}
	public Student(String pwd, Integer rid, String sname, String sex,
			Integer age, String idcard, Date birthdate, String party,
			String phone, String address, String health, Major major,
			Classes classes, Integer gcode, Date enterdate) {
		super();
		this.pwd = pwd;
		this.rid = rid;
		this.sname = sname;
		this.sex = sex;
		this.age = age;
		this.idcard = idcard;
		this.birthdate = birthdate;
		this.party = party;
		this.phone = phone;
		this.address = address;
		this.health = health;
		this.major = major;
		this.classes = classes;
		this.gcode = gcode;
		this.enterdate = enterdate;
	}
	public Student(Integer sid, String pwd, Integer rid, String sname,
			String sex, Integer age, String idcard, Date birthdate,
			String party, String phone, String address, String health,
			Major major, Classes classes, Integer gcode, Date enterdate) {
		super();
		this.sid = sid;
		this.pwd = pwd;
		this.rid = rid;
		this.sname = sname;
		this.sex = sex;
		this.age = age;
		this.idcard = idcard;
		this.birthdate = birthdate;
		this.party = party;
		this.phone = phone;
		this.address = address;
		this.health = health;
		this.major = major;
		this.classes = classes;
		this.gcode = gcode;
		this.enterdate = enterdate;
	}
	public Student() {
		super();
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
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
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public Integer getGcode() {
		return gcode;
	}
	public void setGcode(Integer gcode) {
		this.gcode = gcode;
	}
	public Date getEnterdate() {
		return enterdate;
	}
	public void setEnterdate(Date enterdate) {
		this.enterdate = enterdate;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", pwd=" + pwd + ", rid=" + rid
				+ ", sname=" + sname + ", sex=" + sex + ", age=" + age
				+ ", idcard=" + idcard + ", birthdate=" + birthdate
				+ ", party=" + party + ", phone=" + phone + ", address="
				+ address + ", health=" + health + ", major=" + major
				+ ", classes=" + classes + ", gcode=" + gcode + ", enterdate="
				+ enterdate + "]";
	}	
}
