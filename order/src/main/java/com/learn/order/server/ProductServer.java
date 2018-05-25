package com.learn.order.server;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learn.order.dto.CartDTO;
import com.learn.order.dto.ProductInfoDTO;
import com.learn.order.dto.ResultDTO;
import com.learn.order.enums.ResultEnum;

@FeignClient(name="product")
public interface ProductServer {
	
	@PostMapping("listForOrder")
	public ResultDTO<List<ProductInfoDTO>> listForOrder(@RequestBody List<String> productIds);
	
	@PostMapping("decreaseStock")
	public ResultDTO<ResultEnum> decreaseStock(@RequestBody List<CartDTO> cartDTOS);
}
