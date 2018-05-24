package com.learn.order.service;

import com.learn.order.dto.OrderDTO;

public interface OrderService {

	/** 创建订单 */
	OrderDTO create(OrderDTO orderDTO);

}