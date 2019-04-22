package com.bjsxt.pojo;

/**
 * 汽车实体类
 * @author HaoziDada
 */
public class Car {
	
	private Integer carid; //汽车编号
	private String type; //汽车型号
	private String color; //汽车颜色
	private Double price; //汽车价格
	private Double rentprice; //租金
	private Double deposit;  //押金
	private String status;  //出租状态(未出租、出租中)
	private String desc;   //简介
	private String img;  //图片附件文件名
	
	public Integer getCarid() {
		return carid;
	}
	public void setCarid(Integer carid) {
		this.carid = carid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getRentprice() {
		return rentprice;
	}
	public void setRentprice(Double rentprice) {
		this.rentprice = rentprice;
	}
	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Car [carid=" + carid + ", type=" + type + ", color=" + color + ", price=" + price + ", rentprice="
				+ rentprice + ", deposit=" + deposit + ", status=" + status + ", desc=" + desc + ", img=" + img + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carid == null) ? 0 : carid.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((deposit == null) ? 0 : deposit.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((rentprice == null) ? 0 : rentprice.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Car other = (Car) obj;
		if (carid == null) {
			if (other.carid != null)
				return false;
		} else if (!carid.equals(other.carid))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (deposit == null) {
			if (other.deposit != null)
				return false;
		} else if (!deposit.equals(other.deposit))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (rentprice == null) {
			if (other.rentprice != null)
				return false;
		} else if (!rentprice.equals(other.rentprice))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	public Car(Integer carid, String type, String color, Double price, Double rentprice, Double deposit, String status,
			String desc, String img) {
		super();
		this.carid = carid;
		this.type = type;
		this.color = color;
		this.price = price;
		this.rentprice = rentprice;
		this.deposit = deposit;
		this.status = status;
		this.desc = desc;
		this.img = img;
	}
	public Car() {
		super();
	}
}
