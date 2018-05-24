package com.learn.product.service;


import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.product.base.BaseTest;
import com.learn.product.entity.ProductCategory;

public class ProductCategoryServiceTest extends BaseTest {

	@Autowired
	private ProductCategoryService categoryService;

	@Test
	public void testFindByCategoryTypeIn() {
		List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3));
		Assert.assertTrue(list.size() > 0);
	}

}
