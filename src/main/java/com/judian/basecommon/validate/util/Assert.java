package com.judian.basecommon.validate.util;

import com.judian.basecommon.exception.JdException;

import java.util.Collection;

/**
 * @author LM
 * @version v1.0
 * @description: 自定义断言工具，节省代码
 * @date 2019/7/24 11:01
 */
public class Assert {

    /**
     * 字符串是否为null或是空 断言
     * @param str
     * @param msg
     */
    public static void isBlank(String str, String msg) {
        if (str == null || "".equals(str)) {
            throw new JdException(msg);
        }
    }

    /**
     * 集合是否为null或是空 断言
     * @param collection
     * @param msg
     */
    public static void isEmpty(Collection collection, String msg) {
        if (collection == null || collection.size() == 0) {
            throw new JdException(msg);
        }
    }

}
