package com.yk.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(0, "success"),
    SERVER_ERROR(500,"服务器异常"),
    NO_USER(1000,"查无此人");







    private int code;
    private String errMsg;

    ResultEnum(int code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }
}
