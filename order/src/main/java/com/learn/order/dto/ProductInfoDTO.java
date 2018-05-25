package com.learn.order.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class ProductInfoDTO {
	private String productId;
	private String productName;
	private BigDecimal productPrice;
	private Integer productStock;
	private String productDescription;
	private String productIcon;
	private Integer productStatus;
	private Integer categoryType;
	private Date createTime;
	private Date updateTime;
}
