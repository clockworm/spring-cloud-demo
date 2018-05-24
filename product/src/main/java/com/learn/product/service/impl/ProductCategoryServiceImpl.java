package com.learn.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learn.product.entity.ProductCategory;
import com.learn.product.repository.ProductCategoryDao;
import com.learn.product.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryDao categoryDao;

	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> types) {
		return categoryDao.findByCategoryTypeIn(types);
	}

}
