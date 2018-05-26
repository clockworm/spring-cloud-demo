package com.learn.product.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/**
 * 商品
 */
@Entity
@Table(name = "product_info")
@DynamicUpdate
@Data
public class ProductInfo {
	@Id
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

	// @JsonIgnore
	// public String getProductStatusMsg() {
	// return EnumUtil.getEnumByCode(productStatus,
	// CategoryStatusEnum.class).getMessage();
	// };
}
