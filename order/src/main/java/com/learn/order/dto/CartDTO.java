package com.learn.order.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CartDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 商品ID */
	private String productId;
	/** 數量 */
	private Integer productQuantity;

	public CartDTO(String productId, Integer productQuantity) {
		this.productId = productId;
		this.productQuantity = productQuantity;
	}
}
