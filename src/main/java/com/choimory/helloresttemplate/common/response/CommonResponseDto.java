package com.choimory.helloresttemplate.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
public class CommonResponseDto<T> {
    @Builder.Default
    private final Integer code = CommonResponseCode.OK.getCode();
    @Builder.Default
    private final String message = CommonResponseCode.OK.getMessage();
    private final T data;
}
