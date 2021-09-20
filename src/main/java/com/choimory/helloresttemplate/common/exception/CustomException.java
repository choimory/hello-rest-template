package com.choimory.helloresttemplate.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private final Integer code;
    private final String message;
}
