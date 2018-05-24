package com.learn.order.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.learn.order.enums.OrderStatusEnum;
import com.learn.order.enums.PayStatusEnum;

import lombok.Data;

/**
 * 订单表
 */
@Entity
@Table(name = "order_master")
@DynamicUpdate
@Data
public class OrderMaster {
	/** 订单ID */
	@Id
	private String orderId;
	/** 买家姓名 */
	private String buyerName;
	/** 买家联系方式 */
	private String buyerPhone;
	/** 买家地址 */
	private String buyerAddress;
	/** 买家微信 */
	private String buyerOpenid;
	/** 总金额 */
	private BigDecimal orderAmount;
	/** 订单状态 0 新建 1完结 2取消 */
	private Integer orderStatus = OrderStatusEnum.NEW.getCode();
	/** 支付状态 0 等待支付 1 支付完成 */
	private Integer payStatus = PayStatusEnum.WAIT.getCode();
	/** 订单创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
}
