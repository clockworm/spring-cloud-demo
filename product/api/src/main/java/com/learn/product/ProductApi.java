package com.learn.product;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learn.product.dto.CartDTO;
import com.learn.product.dto.ProductInfoDTO;
import com.learn.product.dto.ResultDTO;
import com.learn.product.enums.ResultEnum;

@FeignClient(name="product")
public interface ProductApi {
	
	@PostMapping("listForOrder")
	public ResultDTO<List<ProductInfoDTO>> listForOrder(@RequestBody List<String> productIds);
	
	@PostMapping("decreaseStock")
	public ResultDTO<ResultEnum> decreaseStock(@RequestBody List<CartDTO> cartDTOS);
}


