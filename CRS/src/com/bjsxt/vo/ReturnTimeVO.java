package com.bjsxt.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReturnTimeVO {
	
	@JsonProperty(value="name")
	private int dayNum;
	@JsonProperty(value="value")
	private int rate;
}
