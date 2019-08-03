package com.judian.basecommon.dto;

import com.judian.basecommon.enums.SystemErrorCode;

/**
 * @author LM
 * @description: 后端统一返回对象
 * @version v1.0
 * @date 2019/5/15 17:06
 */

@SuppressWarnings({"all"})
public class R<T> {

    private static final transient String CODE_SUCCESS = "0000";
    private static final transient String CODE_MSG = "success";

    private String resCode;
    private String resMsg;
    private T resData;

    public R() {}

    /**
     * 返回成功
     * 每个接口基本上都有自己的返回消息(MSG)
     * 不提供无参的方法
     *
     * @return ResultJsonMap
     */
    public static R ok() {
        R result = new R();
        result.setResCode(CODE_SUCCESS);
        result.setResMsg(CODE_MSG);
        return result;
    }

    public static  R ok(String msg) {
        R ok = ok();
        ok.setResMsg(msg);
        return ok;
    }

    public static <T> R<T> ok(T data) {
        R<T> ok = (R<T>)ok();
        ok.setResData(data);
        return ok;
    }

    public static <T> R error(String msg) {
        R result = new R();
        result.setResCode(SystemErrorCode.NORMAL_FAILD.getCode());
        result.setResMsg(msg);
        return result;
    }
    /**
     * 返回失败
     * @param msg
     * @return R
     */
    public static <T> R error(String code, String msg) {
        R result = new R();
        result.setResCode(code);
        result.setResMsg(msg);
        return result;
    }

    /**
     * 返回失败，带有业务数据
     * @param msg
     * @return R
     */
    public static <T> R<T> error(String code, String msg, T data) {
        R<T> result = (R<T>)error(code, msg);
        result.setResData(data);
        return result;
    }

    /**
     * 返回系统失败
     * @param systemErrorCode
     * @return R
     */
    public static <T> R error(SystemErrorCode systemErrorCode) {
        R result = new R();
        result.setResCode(systemErrorCode.getCode());
        result.setResMsg(systemErrorCode.getMsg());
        return result;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public T getResData() {
        return resData;
    }

    public void setResData(T resData) {
        this.resData = resData;
    }

    @Override
    public String toString() {
        return "R{" +
                "resCode='" + resCode + '\'' +
                ", resMsg='" + resMsg + '\'' +
                ", resData=" + resData +
                '}';
    }
}
