package com.learn.order.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.learn.order.entity.OrderDetail;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

	/** 订单ID */
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
	private Integer orderStatus;
	/** 支付状态 0 等待支付 1 支付完成 */
	private Integer payStatus;
	/** 订单创建时间 */
	// @JsonSerialize(using = Date2LongSerializer.class)
	private Date createTime;
	/** 更新时间 */
	// @JsonSerialize(using = Date2LongSerializer.class)
	private Date updateTime;
	/** 訂單詳情 */
	private List<OrderDetail> detailList;

}