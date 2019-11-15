package com.shotgun.my.api.consts;


import com.shotgun.mycommon.base.base.Code;

/**
 * @desc 前三位为模块编号，后三位为自增值，保证不重复即可
 **/
public enum CodeEnum implements Code {

    /**
     * 操作成功
     */
    SUCCESS(0, "操作成功"),


    LOGIN_NOT_AUTH(100000, "无权访问"),
    LOGIN_FAIL(100001, "用户名或密码不正确"),
    LOGIN_VERI_CODE_FAIL(100002, "验证码不正确"),
    LOGIN_USER_BAN(100003, "账户已封禁"),


    SIGN_UP_MOBILE_EXIST(101000, "手机号码已被注册!"),
    SIGN_UP_EMAIL_EXIST(101001, "邮箱已被注册!"),


;

    private int value;
    private String text;

    CodeEnum(int value, String text) {
        this.value = value;
        this.text = text;
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
    }}
