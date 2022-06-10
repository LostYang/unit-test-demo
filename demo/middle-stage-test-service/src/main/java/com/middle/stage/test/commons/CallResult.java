package com.middle.stage.test.commons;

import lombok.Data;


@Data
public class CallResult {

    /**
     * 成功
     */
    public static final int RETURN_STATUS_OK = 1;

    /**
     * 失败
     */
    public static final int RETURN_STATUS_FAIL = -1;

    /**
     * 未注册
     */
    public static final int RETURN_STATUS_UNREGISTERED = -2;

    /**
     * 密码不正确
     */
    public static final int RETURN_STATUS_PASW_INCORRECT = -3;

    /**
     * 参数异常
     */
    public static final int RETURN_STATUS_PARAM_ERROR = -4;

    /**
     * 状态值
     */
    private int code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 数据对象
     */
    private Object content;

    public CallResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CallResult(int code, String msg, Object content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public static CallResult success(int code, String msg, Object content) {
        return new CallResult(code, msg, content);
    }

    public static CallResult fail(int code, String msg) {
        return new CallResult(code, msg);
    }
}
