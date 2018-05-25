package com.learn.order.server;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learn.order.dto.ResultDTO;

@FeignClient(name="product")
public interface ProductServer {
	
	@PostMapping("listForOrder")
	public ResultDTO<?> listForOrder(@RequestBody List<String> productIds);
}
