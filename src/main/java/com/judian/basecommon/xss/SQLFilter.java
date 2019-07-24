package com.judian.basecommon.xss;

import com.judian.basecommon.exception.JdException;

/**
 * SQL过滤
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-04-01 16:16
 */
public class SQLFilter {

    /**
     * SQL注入过滤
     *
     * @param str 待验证的字符串
     */
    public static String sqlInject(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        //去掉'|"|;|\字符
        str = str.replace("'", "");
        str = str.replace("\"", "");
        str = str.replace(";", "");
        str = str.replace("\\", "");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alert", "drop"};

        //判断是否包含非法字符
        for (String keyword : keywords) {
            if (str.contains(keyword)) {
                throw new JdException("包含非法字符");
            }
        }

        return str;
    }
}
