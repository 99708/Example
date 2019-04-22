package com.xyq.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarTypeVO {
	
	@JsonProperty(value="value")
	private int carCount; //车的数量
	@JsonProperty(value="name")
	private String type;  //车的类型
	public CarTypeVO(int carCount, String type) {
		super();
		this.carCount = carCount;
		this.type = type;
	}
	public CarTypeVO() {
		super();
	}
	public int getCarCount() {
		return carCount;
	}
	public void setCarCount(int carCount) {
		this.carCount = carCount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "CarTypeVO [carCount=" + carCount + ", type=" + type + "]";
	}
	
	
}
