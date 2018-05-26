package com.learn.product.rest.form;

import org.hibernate.validator.constraints.Range;

import lombok.Data;
import lombok.NonNull;

@Data
public class ProductForm {
	
	@NonNull
	@Range(min=0, max=1)
	private Integer productStatus;

}
