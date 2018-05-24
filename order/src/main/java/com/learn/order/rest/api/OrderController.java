package com.learn.order.rest.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.order.converter.OrderForm2OrderDTO;
import com.learn.order.dto.OrderDTO;
import com.learn.order.dto.ResultDTO;
import com.learn.order.enums.ResultEnum;
import com.learn.order.exception.OrderException;
import com.learn.order.rest.form.OrderForm;
import com.learn.order.service.OrderService;
import com.learn.order.util.ResultDTOUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("create")
	public ResultDTO<?> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			log.error("请求创建订单 参数校验错误:", orderForm);
			throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
		}
		OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
		if(CollectionUtils.isEmpty(orderDTO.getDetailList())) {
			log.error("创建订单异常,购物车为空 orderForm:{}",orderForm);
			throw new OrderException(ResultEnum.CAR_ERROR);
		}
		OrderDTO dto = orderService.create(orderDTO);
		Map<String,String> map = new HashMap<>();
		map.put("orderId", dto.getOrderId());
		return ResultDTOUtil.success(map);
	}
}
