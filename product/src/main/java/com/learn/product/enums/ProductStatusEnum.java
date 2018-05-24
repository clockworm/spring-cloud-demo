package com.learn.product.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum implements CodeEnum {
	UP(1, "在架"), 
	DOWN(0, "下架");

	/** 返回编码 */
	private Integer code;
	/** 返回信息 */
	private String message;

	ProductStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
