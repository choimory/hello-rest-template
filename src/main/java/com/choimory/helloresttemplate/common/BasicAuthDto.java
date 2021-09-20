package com.choimory.helloresttemplate.common;

import lombok.*;

@Builder
@Getter
@RequiredArgsConstructor
public class BasicAuthDto {
    private final String id;
    private final String pw;
}
