package com.judian.basecommon.exception;

/**
 * @author LM
 * @description: 聚点异常类,【其他异常类继承该类】
 * @date 2019/4/3 15:36
 */
public class JdException extends RuntimeException {

    public JdException(String message) {
        super(message);
    }

}
