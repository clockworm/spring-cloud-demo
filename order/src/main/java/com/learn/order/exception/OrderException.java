package com.learn.order.exception;

import com.learn.order.enums.ResultEnum;

import lombok.Getter;

/**
 * 异常信息
 */
@Getter
public class OrderException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private Integer code;

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public OrderException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}