package com.project.backend.api.common;

import com.project.backend.config.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserType implements ErrorCode {
    REPORTER("기자"),
    USER("사용자");

    private final String message;

}
