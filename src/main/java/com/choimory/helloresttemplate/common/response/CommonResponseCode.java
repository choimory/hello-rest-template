package com.choimory.helloresttemplate.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommonResponseCode {
    OK(200, "정상")
    , NOT_FOUND(404, "경로를 찾지 못함")
    , INTERNAL_SERVER_ERROR(500, "서버 오류");

    private final Integer code;
    private final String message;
}
