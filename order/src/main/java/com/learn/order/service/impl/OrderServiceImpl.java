package com.learn.order.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.order.dto.CartDTO;
import com.learn.order.dto.OrderDTO;
import com.learn.order.dto.ProductInfoDTO;
import com.learn.order.dto.ResultDTO;
import com.learn.order.entity.OrderDetail;
import com.learn.order.entity.OrderMaster;
import com.learn.order.enums.OrderStatusEnum;
import com.learn.order.enums.PayStatusEnum;
import com.learn.order.repository.OrderMasterDao;
import com.learn.order.server.ProductServer;
import com.learn.order.service.OrderService;
import com.learn.order.util.KeyUtil;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMasterDao masterDao;
	// @Autowired
	// private OrderDetailDao detailDao;
	@Autowired
	private ProductServer productServer;

	@Override
	public OrderDTO create(OrderDTO orderDTO) {
		// TODO 查询商品信息(API)
		List<String> productIds = orderDTO.getDetailList().stream().map(OrderDetail::getProductId)
				.collect(Collectors.toList());
		ResultDTO<List<ProductInfoDTO>> listForOrder = productServer.listForOrder(productIds);
		List<ProductInfoDTO> productInfos = listForOrder.getData();
		System.err.println(productInfos);
		// TODO 计算总价
		// TODO 扣库存
		List<CartDTO> cartDTOS = orderDTO.getDetailList().stream()
				.map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
		productServer.decreaseStock(cartDTOS);
		// 订单入库
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