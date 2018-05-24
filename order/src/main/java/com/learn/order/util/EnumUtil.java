package com.learn.order.util;

import com.learn.order.enums.CodeEnum;

/**
 * 枚举工具类
 */
public class EnumUtil {

    /** 通过code获取枚举*/
    public static <T extends CodeEnum> T getEnumByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if(code.equals(each.getCode())){
                return  each;
            }
        }
        return null;
    }
}
