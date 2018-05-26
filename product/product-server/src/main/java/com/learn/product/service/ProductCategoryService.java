package com.learn.product.service;

import java.util.List;

import com.learn.product.entity.ProductCategory;

public interface ProductCategoryService {

	List<ProductCategory> findByCategoryTypeIn(List<Integer> types);
}	
