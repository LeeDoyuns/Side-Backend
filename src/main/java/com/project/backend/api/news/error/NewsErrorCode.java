package com.project.backend.api.news.error;

import com.project.backend.config.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NewsErrorCode implements ErrorCode {
    IMG_UPLOAD_ERROR("이미지 저장 중 에러가 발생했습니다."),
    NOT_FOUND_IMAGE("이미지를 찾을 수 없습니다");


    private final String message;
}
