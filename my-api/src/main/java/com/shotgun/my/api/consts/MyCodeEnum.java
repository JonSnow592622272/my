package com.shotgun.my.api.consts;


import com.shotgun.mycommon.base.base.api.Code;

/**
 * @desc 前三位为模块编号，后三位为自增值，保证不重复即可
 **/
public enum MyCodeEnum implements Code {


    /**操作成功*/
    SUCCESS(0, "操作成功"),
    /**部分操作成功，部分失败（不允许单独使用，将错误的部分信息存入到resultInfo的data中）*/
    PARTIAL_SUCCESS(1, "部分操作成功"),

    /**请求参数有误*/
    ERROR_PARAM(100400, "请求参数有误"),
    /**请重新登录*/
    ERROR_NOT_AUTH_NEED_RELOGIN(100401, "请重新登录"),
    /**已登录但无权访问*/
    ERROR_NOT_AUTH(100402, "已登录但无权访问"),
    /**请求未找到*/
    ERROR_NOT_FOUND(100404, "请求未找到"),
    /**服务器异常*/
    ERROR_SERVER(100500, "服务器异常"),
    /**调用远程服务器异常*/
    ERROR_REMOTE(100501, "调用远程服务器异常"),
    /**调用远程服务器返回结果错误，比如：期望返回json，结果返回了非json字符串。亦可用于非异常错误*/
    ERROR_REMOTE_ERROR_RESULT(100502, "调用远程服务器返回结果错误"),

    LOGIN_NOT_AUTH(101000, "无权访问"),
    LOGIN_FAIL(101001, "用户名或密码不正确"),
    LOGIN_VERI_CODE_FAIL(101002, "验证码不正确"),
    LOGIN_USER_BAN(101003, "账户已封禁"),

    SIGN_UP_MOBILE_EXIST(102000, "手机号码已被注册!"),
    SIGN_UP_EMAIL_EXIST(102001, "邮箱已被注册!"),


;

    private int value;
    private String text;

    MyCodeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public String getSystemCode() {
        return CommonConstant.APPLICATION_NAME;
    }

    @Override
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
