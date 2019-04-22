package com.xyq.entity;

/**
 * 出租单信息实体类
 * @author Administrator
 *
 */
public class Rental {
	
	private Integer rentid;//出租单编号
	private Double payable;//应付金额
	private Double deposit;//预付金额
	private Double priced;//实付金额
	private String begindate;//起租日期
	private String dateable;//应归还日期
	private String returndate;//归还日期
	private String status;//出租单状态
	private String idcard;//客户身份证号码
	private Integer carid;//汽车编号
	private Integer uid;//服务人员编号
	
	private Customer customer;//客户信息

	public Rental(Integer rentid, Double payable, Double deposit, Double priced, String begindate, String dateable,
			String returndate, String status, String idcard, Integer carid, Integer uid, Customer customer) {
		super();
		this.rentid = rentid;
		this.payable = payable;
		this.deposit = deposit;
		this.priced = priced;
		this.begindate = begindate;
		this.dateable = dateable;
		this.returndate = returndate;
		this.status = status;
		this.idcard = idcard;
		this.carid = carid;
		this.uid = uid;
		this.customer = customer;
	}

	public Rental() {
		super();
	}

	public Integer getRentid() {
		return rentid;
	}

	public void setRentid(Integer rentid) {
		this.rentid = rentid;
	}

	public Double getPayable() {
		return payable;
	}

	public void setPayable(Double payable) {
		this.payable = payable;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public Double getPriced() {
		return priced;
	}

	public void setPriced(Double priced) {
		this.priced = priced;
	}

	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getDateable() {
		return dateable;
	}

	public void setDateable(String dateable) {
		this.dateable = dateable;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Integer getCarid() {
		return carid;
	}

	public void setCarid(Integer carid) {
		this.carid = carid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Rental [rentid=" + rentid + ", payable=" + payable + ", deposit=" + deposit + ", priced=" + priced
				+ ", begindate=" + begindate + ", dateable=" + dateable + ", returndate=" + returndate + ", status="
				+ status + ", idcard=" + idcard + ", carid=" + carid + ", uid=" + uid + ", customer=" + customer + "]";
	}
	
}
