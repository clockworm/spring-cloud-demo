package com.learn.product.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.product.dto.CartDTO;
import com.learn.product.entity.ProductInfo;
import com.learn.product.enums.ResultEnum;
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

	@Override
	@Transactional
	public ResultEnum decreaseStock(List<CartDTO> cartDTOS) {
        for (CartDTO cartDTO:cartDTOS) {
            ProductInfo productInfo = productInfoDao.getOne(cartDTO.getProductId());
            if (productInfo == null){
                return ResultEnum.PRODUCT_NOT_EXIST;
            }
            Integer count = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (count < 0) {
            	return  ResultEnum.PRODUCT_STOCK_ERROR;
            }
            productInfo.setProductStock(count);
            productInfoDao.save(productInfo);
        }
        return ResultEnum.SUCCESS;
	}

}
