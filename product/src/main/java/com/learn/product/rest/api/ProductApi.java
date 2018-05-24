package com.learn.product.rest.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.product.dto.ProductDTO;
import com.learn.product.dto.ProductInfoDTO;
import com.learn.product.dto.ResultDTO;
import com.learn.product.entity.ProductCategory;
import com.learn.product.entity.ProductInfo;
import com.learn.product.rest.form.ProductForm;
import com.learn.product.service.ProductCategoryService;
import com.learn.product.service.ProductService;
import com.learn.product.util.ResultDTOUtil;

@RestController
@RequestMapping("product")
public class ProductApi {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductCategoryService categoryService;

	@GetMapping("list")
	public ResultDTO<?> list(@Valid ProductForm productForm) {
		List<ProductInfo> productInfos = productService.findListByProductStatus(productForm.getProductStatus());
		List<Integer> types = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
		List<ProductCategory> productCategorys = categoryService.findByCategoryTypeIn(types);
		List<ProductDTO> list = new ArrayList<>();
		for (ProductCategory productCategory : productCategorys) {
			ProductDTO dto = new ProductDTO();
			dto.setCategoryName(productCategory.getCategoryName());
			dto.setCategoryType(productCategory.getCategoryType());

			List<ProductInfoDTO> ps = new ArrayList<>();
			for (ProductInfo productInfo : productInfos) {
				if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
					ProductInfoDTO productInfoDTO = new ProductInfoDTO();
					BeanUtils.copyProperties(productInfo, productInfoDTO);
					ps.add(productInfoDTO);
				}
			}
			dto.setProductInfoDTOList(ps);
			list.add(dto);
		}
		return ResultDTOUtil.success(list);
	}

	@GetMapping("listForOrder")
	public ResultDTO<?> listForOrder(List<String> productIds) {
		List<ProductInfo> list = productService.findProductInfoByProductIdIn(productIds);
		return ResultDTOUtil.success(list);
	}

}
