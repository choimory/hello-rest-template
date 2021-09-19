package com.choimory.helloresttemplate.json;

import com.choimory.helloresttemplate.common.response.CommonResponseDto;
import com.choimory.helloresttemplate.json.service.JsonApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/json")
@Slf4j
public class JsonApiController {
    private final JsonApiService jsonApiService;

    @GetMapping
    public ResponseEntity<CommonResponseDto<?>> call(){
        return ResponseEntity.ok(CommonResponseDto.builder()
                .build());
    }
}
