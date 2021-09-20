package com.choimory.helloresttemplate.reqpart.service;

import com.choimory.helloresttemplate.common.BasicAuthDto;
import com.choimory.helloresttemplate.common.BearerTokenDto;
import com.choimory.helloresttemplate.reqpart.dto.request.ReqPartRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReqPartServiceImpl implements ReqPartService{
    @Value("${reqpart.api.get}")
    private String getApiUrl;
    @Value("${reqpart.api.post}")
    private String postApiUrl;

    @Override
    public Map<String, String> get(final ReqPartRequestDto param) throws JsonProcessingException {
        /*Request Header*/
        List<MediaType> accept = new ArrayList<>();
        accept.add(MediaType.APPLICATION_JSON_UTF8);
        HttpHeaders requestHeader = buildHeader(accept,
                MediaType.APPLICATION_JSON_UTF8,
                BasicAuthDto.builder()
                        .id("authId")
                        .pw("authPw")
                        .build(),
                null);

        /*Request Parameter*/
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("page", param.getPage().toString());
        requestParams.add("param1", param.getParam1());
        requestParams.add("param2", param.getParam2());
        requestParams.add("param3", param.getParam3());

        /*Build URI*/
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(getApiUrl)
                .queryParams(requestParams)
                .encode()
                .build();

        /*Call API*/
        HttpEntity<?> request = new HttpEntity<>(requestHeader);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.exchange(uri.toUri(), HttpMethod.GET, request, Map.class);

        return response.getBody();
    }

    @Override
    public Map<String, String> post(final ReqPartRequestDto param) throws JsonProcessingException {
        /*Request Header*/
        List<MediaType> accept = new ArrayList<>();
        accept.add(MediaType.APPLICATION_JSON_UTF8);
        HttpHeaders requestHeader = buildHeader(accept, MediaType.APPLICATION_JSON_UTF8, null, BearerTokenDto.builder()
                .token("bearer token")
                .build());

        /*URI*/
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(postApiUrl)
                .encode()
                .build();

        /*Call API*/
        HttpEntity<?> request = new HttpEntity<>(param, requestHeader);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.exchange(uri.toUri(), HttpMethod.POST, request, Map.class);

        return response.getBody();
    }

    private HttpHeaders buildHeader(List<MediaType> accept, MediaType contentType, @Nullable BasicAuthDto basicAuth, @Nullable BearerTokenDto bearerToken){
        HttpHeaders requestHeader = new HttpHeaders();

        /*Accept*/
        requestHeader.setAccept(accept);

        /*Content-Type*/
        requestHeader.setContentType(contentType);

        /*Basic-Auth*/
        if(basicAuth != null) {
            requestHeader.setBasicAuth(basicAuth.getId(), basicAuth.getPw());
        }

        /*BearerToken*/
        if(bearerToken != null){
            requestHeader.setBearerAuth(bearerToken.getToken());
        }

        return requestHeader;
    }
}
