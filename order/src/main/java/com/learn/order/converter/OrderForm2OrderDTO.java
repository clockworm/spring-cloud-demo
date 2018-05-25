package com.learn.order.converter;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.learn.order.dto.OrderDTO;
import com.learn.order.entity.OrderDetail;
import com.learn.order.enums.ResultEnum;
import com.learn.order.exception.OrderException;
import com.learn.order.rest.form.OrderForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderForm2OrderDTO {

	public static OrderDTO convert(OrderForm orderForm) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setBuyerName(orderForm.getName());
		orderDTO.setBuyerOpenid(orderForm.getOpenid());
		orderDTO.setBuyerAddress(orderForm.getAddress());
		orderDTO.setBuyerPhone(orderForm.getPhone());

		List<OrderDetail> list = new ArrayList<>();
		Gson gson = new Gson();
		try {
			list = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {}.getType());
		} catch (Exception e) {
			log.error("[Json转换出错,string={}],错误日志={}", orderForm.getItems(), e);
			throw new OrderException(ResultEnum.PARAM_ERROR);
		}
		orderDTO.setDetailList(list);
		return orderDTO;
	}

}
