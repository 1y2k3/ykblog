package com.yk.exception;

import com.yk.enums.ResultEnum;
import lombok.Data;

@Data
public class GlobalException extends RuntimeException {

    private int code;

    public GlobalException(ResultEnum resultEnum) {
        super(resultEnum.getErrMsg());
        this.code = resultEnum.getCode();
    }
}
