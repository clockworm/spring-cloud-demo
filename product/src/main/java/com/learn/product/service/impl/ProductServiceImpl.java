package com.learn.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.product.entity.ProductInfo;
import com.learn.product.repository.ProductInfoDao;
import com.learn.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductInfoDao productInfoDao;
	
	@Override
	public List<ProductInfo> findListByProductStatus(Integer status) {
		return productInfoDao.findProductInfoByProductStatus(status);
	}

	@Override
	public List<ProductInfo> findProductInfoByProductIdIn(List<String> productIds) {
		return productInfoDao.findProductInfoByProductIdIn(productIds);
	}

}
