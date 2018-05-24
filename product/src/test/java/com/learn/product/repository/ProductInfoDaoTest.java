package com.learn.product.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.product.base.BaseTest;
import com.learn.product.entity.ProductInfo;

public class ProductInfoDaoTest extends BaseTest{

	@Autowired
	private ProductInfoDao productInfoDao;
	
	@Test
	public void testFindProductInfoByProductStatus() {
		List<ProductInfo> list = productInfoDao.findProductInfoByProductStatus(0);
		Assert.assertTrue(list.size() > 0);
	}

	@Test
	public void testFindProductInfoByCategoryType() {
		 List<ProductInfo> list = productInfoDao.findProductInfoByCategoryType(1);
			Assert.assertTrue(list.size() > 0);
	}

}
