package com.learn.order.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/**
 * 订单详情明细
 */
@Entity
@Table(name = "order_detail")
@Data
@DynamicUpdate
public class OrderDetail {
	@Id
	private String detailId;
	private String orderId;
	private String productId;
	private String productName;
	private BigDecimal productPrice;
	private Integer productQuantity;
	private String productIcon;
}