package com.learn.product.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductInfoDTO {
	   @JsonProperty("id")
	    private String productId;
	    @JsonProperty("name")
	    private String productName;
	    @JsonProperty("price")
	    private BigDecimal productPrice;
	    @JsonProperty("description")
	    private String productDescription;
	    @JsonProperty("icon")
	    private String productIcon;
}
