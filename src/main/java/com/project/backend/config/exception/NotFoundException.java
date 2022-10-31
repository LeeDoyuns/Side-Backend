package com.project.backend.config.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.project.backend.config.ErrorCode;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends BaseException {
    private ErrorCode errorCode;

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
