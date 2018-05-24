package com.learn.order.util;

import com.learn.order.dto.ResultDTO;
import com.learn.order.enums.ResultEnum;

/**
 * @author TangLingYun
 * @describe 微服務交互对象
 */
public class ResultDTOUtil {

	/** 请求成功 */
	public static ResultDTO<?> success(Object object) {
		ResultDTO<Object> ResultDTO = new ResultDTO<>();
		ResultDTO.setCode(ResultEnum.SUCCESS.getCode());
		ResultDTO.setMessage("成功");
		ResultDTO.setData(object);
		return ResultDTO;
	}

//	/** 请求成功分頁組件 */
//	public static ResultDTO<?> page(PageInfo<?> page) {
//		ResultDTO<Object> ResultDTO = new ResultDTO<>();
//		ResultDTO.setCode(ResultEnum.SUCCESS.getCode());
//		ResultDTO.setMessage("成功");
//		ResultDTO.setData(page.getList());
//		ResultDTO.setCount(page.getTotal());
//		ResultDTO.setPage(page.getPageNum());
//		ResultDTO.setTotalPage(page.getPages());
//		return ResultDTO;
//	}
	
	
	/** 请求成功 */
	public static ResultDTO<?> success() {
		return success(null);
	}

	/** 请求失败 */
	public static ResultDTO<?> error(Integer code, String message) {
		ResultDTO<?> ResultDTO = new ResultDTO<>();
		ResultDTO.setCode(code);
		ResultDTO.setMessage(message);
		ResultDTO.setData(null);
		return ResultDTO;
	}
	
	/** 请求失败 */
	public static ResultDTO<?> error(ResultEnum e) {
		ResultDTO<?> ResultDTO = new ResultDTO<>();
		ResultDTO.setCode(e.getCode());
		ResultDTO.setMessage(e.getMessage());
		ResultDTO.setData(null);
		return ResultDTO;
	}

	/** 请求错误 */
	public static ResultDTO<?> fail(String message) {
		ResultDTO<?> ResultDTO = new ResultDTO<>();
		ResultDTO.setCode(ResultEnum.PARAM_ERROR.getCode());
		ResultDTO.setMessage(message);
		ResultDTO.setData(null);
		return ResultDTO;
	}
}