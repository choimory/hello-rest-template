package com.choimory.helloresttemplate.json.service;

import com.choimory.helloresttemplate.json.dto.response.JsonResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JsonApiServiceImpl implements JsonApiService{
    @Value("${json.api.url}")
    private String apiUrl;
    @Value("${json.api.key}")
    private String apiKey;

    @Override
    public JsonResponseDto callApi() {
        return null;
    }
}
