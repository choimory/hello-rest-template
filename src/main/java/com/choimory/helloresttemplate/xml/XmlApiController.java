package com.choimory.helloresttemplate.xml;

import com.choimory.helloresttemplate.common.response.CommonResponseDto;
import com.choimory.helloresttemplate.xml.service.XmlApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/xml")
@Slf4j
public class XmlApiController {
    private final XmlApiService xmlApiService;

    @GetMapping
    public ResponseEntity<CommonResponseDto<?>> call(){
        return ResponseEntity.ok(CommonResponseDto.builder()
                .build());
    }
}
