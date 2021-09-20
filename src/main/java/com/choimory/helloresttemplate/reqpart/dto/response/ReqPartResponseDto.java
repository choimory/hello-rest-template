package com.choimory.helloresttemplate.reqpart.dto.response;

import lombok.*;

@Builder
@RequiredArgsConstructor
public class ReqPartResponseDto {
    private final Integer page;
    private final String param1;
    private final String param2;
    private final String param3;
}
