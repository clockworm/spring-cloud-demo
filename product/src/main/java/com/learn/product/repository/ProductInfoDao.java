package com.learn.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learn.product.entity.ProductInfo;

public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findProductInfoByProductStatus(Integer status);

    List<ProductInfo> findProductInfoByCategoryType(Integer categoryType);
}