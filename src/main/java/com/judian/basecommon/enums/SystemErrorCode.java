package com.judian.basecommon.enums;

/**
 * @author LM
 * @description: 系统异常码
 * @date 2019/5/15 20:43
 */
public enum SystemErrorCode {

    /**
     * 一般msg可根据业务填入,系统异常与通用业务失败一样的错误码
     */
    NORMAL_FAILD("1000", "通用业务失败"),

    ;

    private String code;

    private String msg;

    SystemErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
