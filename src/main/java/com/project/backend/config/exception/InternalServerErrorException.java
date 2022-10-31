package com.project.backend.config.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.project.backend.config.ErrorCode;

@Getter
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends BaseException {
    private ErrorCode errorCode;

    public InternalServerErrorException(ErrorCode errorCode) {
        super(errorCode);
    }
}
