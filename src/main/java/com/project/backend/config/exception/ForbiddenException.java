package com.project.backend.config.exception;

import com.project.backend.config.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenException extends BaseException {
    private ErrorCode errorCode;

    public ForbiddenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
