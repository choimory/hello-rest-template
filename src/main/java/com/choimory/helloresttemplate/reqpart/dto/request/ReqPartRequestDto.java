package com.choimory.helloresttemplate.reqpart.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
public class ReqPartRequestDto {
    private final Integer page;
    private final String param1;
    private final String param2;
    private final String param3;
}
