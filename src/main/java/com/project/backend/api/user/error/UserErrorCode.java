package com.project.backend.api.user.error;

import com.project.backend.config.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {

    NOT_FOUND("사용자 정보를 찾을 수 없습니다."),

    SERVER_ERROR("조회 중 오류가 발생했습니다."),

    ALREADY_LOGIN_ID("이미 존재하는 계정입니다."),

    ALREADY_NICKNAME("이미 존재하는 닉네임 입니다.");

    private final String message;
}
