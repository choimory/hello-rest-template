package com.choimory.helloresttemplate.xml.service;

import com.choimory.helloresttemplate.xml.dto.response.XmlResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class XmlApiServiceImpl implements XmlApiService{
    @Value("${xml.api.url}")
    private String apiUrl;
    @Value(("${xml.api.key"))
    private String apiKey;

    @Override
    public XmlResponseDto callApi() {
        return null;
    }
}
