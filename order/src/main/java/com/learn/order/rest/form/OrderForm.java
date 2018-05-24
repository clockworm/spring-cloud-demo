package com.learn.order.rest.form;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class OrderForm {

	@NotEmpty(message="买家必填")
	private String name;
	
	@NotEmpty(message="手机号必填")
	private String phone;
	
	@NotEmpty(message="地址必填")
	private String address;
	
	@NotEmpty(message="openid必填")
	private String openid;
	
	@NotEmpty(message="购物车不能为空")
	private String items;
}
