package com.learn.order.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultDTO<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 状态码 0成功 大于0为异常 */
	private Integer code;
	/** 返回的信息 */
	private String message;
	/** 返回的数据 */
	private T data;
	
	private Long count;
	
	private Integer page;
	
	private Integer totalPage;

}