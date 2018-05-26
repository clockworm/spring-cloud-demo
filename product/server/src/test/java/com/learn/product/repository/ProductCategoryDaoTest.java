package com.learn.product.repository;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.product.base.BaseTest;
import com.learn.product.entity.ProductCategory;

public class ProductCategoryDaoTest extends BaseTest {

	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Test
	public void testFindProductCategoryByCategoryTypeEquals() {
//		fail("Not yet implemented");
	}

	@Test
	public void testFindByCategoryTypeIn() {
		List<ProductCategory> list = productCategoryDao.findByCategoryTypeIn(Arrays.asList(1, 2, 3));
		Assert.assertTrue(list.size() > 0);
	}

}
