package com.xyq.vo;

public class RoleVo {
	private Integer mid;
	private Integer rid;
	private Integer uid;
	private String uname;
	private String pwd;
	private String idcard;
	private String sex;
	private String address;
	private String phone;
	private String position;
	private String rname;
	private String rdesc;
	private String mname;
	private String murl;
	private Integer pid;
	private String mdesc;
	public RoleVo(Integer mid, Integer rid, Integer uid, String uname, String pwd, String idcard, String sex,
			String address, String phone, String position, String rname, String rdesc, String mname, String murl,
			Integer pid, String mdesc) {
		super();
		this.mid = mid;
		this.rid = rid;
		this.uid = uid;
		this.uname = uname;
		this.pwd = pwd;
		this.idcard = idcard;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.position = position;
		this.rname = rname;
		this.rdesc = rdesc;
		this.mname = mname;
		this.murl = murl;
		this.pid = pid;
		this.mdesc = mdesc;
	}
	public RoleVo() {
		super();
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRdesc() {
		return rdesc;
	}
	public void setRdesc(String rdesc) {
		this.rdesc = rdesc;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMurl() {
		return murl;
	}
	public void setMurl(String murl) {
		this.murl = murl;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getMdesc() {
		return mdesc;
	}
	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}
	@Override
	public String toString() {
		return "RoleVo [mid=" + mid + ", rid=" + rid + ", uid=" + uid + ", uname=" + uname + ", pwd=" + pwd
				+ ", idcard=" + idcard + ", sex=" + sex + ", address=" + address + ", phone=" + phone + ", position="
				+ position + ", rname=" + rname + ", rdesc=" + rdesc + ", mname=" + mname + ", murl=" + murl + ", pid="
				+ pid + ", mdesc=" + mdesc + "]";
	}
	
}
