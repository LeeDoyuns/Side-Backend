package com.project.backend.config.exception;

import com.project.backend.config.ErrorCode;

public class BaseException extends RuntimeException{
    protected ErrorCode code;

    public BaseException(ErrorCode code){
        super(code.getMessage());
        this.code = code;
    }
}
