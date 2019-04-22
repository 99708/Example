package com.bjsxt.pojo;

/**
 * 检查单管理实体类
 * @author Qiao
 *
 */
public class Checked {
	private Integer checkid;//检查单号
	private String checkdate;//检查时间
	private String problem;//问题
	private Double pay;//赔费
	private Integer uid;//检查员
	private Integer rentid;//出租单编号
	
	private User user;//检查员信息
	private Rental rental;//出租单信息
	public Checked(Integer checkid, String checkdate, String problem, Double pay, Integer uid, Integer rentid,
			User user, Rental rental) {
		super();
		this.checkid = checkid;
		this.checkdate = checkdate;
		this.problem = problem;
		this.pay = pay;
		this.uid = uid;
		this.rentid = rentid;
		this.user = user;
		this.rental = rental;
	}
	public Checked() {
		super();
	}
	public Integer getCheckid() {
		return checkid;
	}
	public void setCheckid(Integer checkid) {
		this.checkid = checkid;
	}
	public String getCheckdate() {
		return checkdate;
	}
	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public Double getPay() {
		return pay;
	}
	public void setPay(Double pay) {
		this.pay = pay;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getRentid() {
		return rentid;
	}
	public void setRentid(Integer rentid) {
		this.rentid = rentid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Rental getRental() {
		return rental;
	}
	public void setRental(Rental rental) {
		this.rental = rental;
	}
	@Override
	public String toString() {
		return "Checked [checkid=" + checkid + ", checkdate=" + checkdate + ", problem=" + problem + ", pay=" + pay
				+ ", uid=" + uid + ", rentid=" + rentid + ", user=" + user + ", rental=" + rental + "]";
	}
	
	
}
