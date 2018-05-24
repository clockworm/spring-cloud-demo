package com.learn.product.service;

import java.util.List;

import com.learn.product.entity.ProductInfo;

public interface ProductService {

	/** 所有在架下架状态商品列表 */
	List<ProductInfo> findListByProductStatus(Integer status);

	/***/
	List<ProductInfo> findProductInfoByProductIdIn(List<String> productIds);
}
