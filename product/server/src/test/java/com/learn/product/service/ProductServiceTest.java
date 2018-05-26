package com.learn.product.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.product.base.BaseTest;
import com.learn.product.entity.ProductInfo;
import com.learn.product.enums.ProductStatusEnum;

public class ProductServiceTest extends BaseTest {

	@Autowired
	private ProductService productService;

	@Test
	public void testFindListByProductStatus() {
		List<ProductInfo> list = productService.findListByProductStatus(ProductStatusEnum.UP.getCode());
		Assert.assertTrue(list.size() > 0);
	}

}
