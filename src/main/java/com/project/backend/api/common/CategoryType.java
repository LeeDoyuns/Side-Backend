package com.project.backend.api.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CategoryType {
    SPORTS("스포츠"),
    WEATHER("날씨"),
    SOCIAL("사회"),
    ECONOMY("경제"),
    ENTERTAINMENTS("연예");

    private final String message;
}
