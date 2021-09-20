package com.choimory.helloresttemplate.reqpart.service;

import com.choimory.helloresttemplate.common.response.CommonResponseDto;
import com.choimory.helloresttemplate.reqpart.dto.request.ReqPartRequestDto;
import com.choimory.helloresttemplate.reqpart.dto.response.ReqPartResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

public interface ReqPartService {
    Map<String, String> get(ReqPartRequestDto param) throws JsonProcessingException;
    Map<String, String> post(ReqPartRequestDto param) throws JsonProcessingException;
}
