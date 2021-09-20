package com.choimory.helloresttemplate.common;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class BearerTokenDto {
    private final String token;
}
