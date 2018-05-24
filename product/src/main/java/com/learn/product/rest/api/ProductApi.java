package com.learn.product.rest.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.product.base.ResultDTO;
import com.learn.product.entity.ProductInfo;
import com.learn.product.repository.ProductInfoDao;
import com.learn.product.rest.form.ProductForm;
import com.learn.product.util.ResultDTOUtil;

@RestController
@RequestMapping("product")
public class ProductApi {

	@Autowired
	private ProductInfoDao productInfoDao;
	
	@GetMapping("list")
	public ResultDTO<?> list(@Valid ProductForm productForm){
		List<ProductInfo> list = productInfoDao.findProductInfoByProductStatus(productForm.getProductStatus());
		return ResultDTOUtil.success(list);
	}
	
}
