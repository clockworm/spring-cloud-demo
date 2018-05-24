package com.learn.order.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.order.dto.OrderDTO;
import com.learn.order.entity.OrderMaster;
import com.learn.order.enums.OrderStatusEnum;
import com.learn.order.enums.PayStatusEnum;
import com.learn.order.repository.OrderDetailDao;
import com.learn.order.repository.OrderMasterDao;
import com.learn.order.service.OrderService;
import com.learn.order.util.KeyUtil;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMasterDao masterDao;
	@Autowired
	private OrderDetailDao detailDao;

	@Override
	public OrderDTO create(OrderDTO orderDTO) {
		//TODO 查询商品信息(API)
		//TODO 计算总价
		//TODO 扣库存
		//订单入库 
		OrderMaster orderMaster = new OrderMaster();
		orderDTO.setOrderId(KeyUtil.genUniqueKey());
		BeanUtils.copyProperties(orderDTO, orderMaster);
		orderMaster.setOrderAmount(new BigDecimal(5));
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
		masterDao.save(orderMaster);
		return orderDTO;
	}
}