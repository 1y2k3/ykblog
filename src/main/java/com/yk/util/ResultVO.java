package com.yk.util;

import lombok.Data;

@Data
public class ResultVO<T> {

    private Integer code;

    private String errMsg;

    private T data;
}
