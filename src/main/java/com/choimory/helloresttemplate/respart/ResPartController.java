package com.choimory.helloresttemplate.respart;

import com.choimory.helloresttemplate.common.response.CommonResponseDto;
import com.choimory.helloresttemplate.respart.service.ResPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/res")
public class ResPartController {
    private final ResPartService resPartService;

    @GetMapping("/xml")
    public ResponseEntity<CommonResponseDto<?>> xml() throws Exception {
        return ResponseEntity.ok(CommonResponseDto.builder()
                .data(resPartService.xml())
                .build());
    }

    @GetMapping("/json")
    public ResponseEntity<CommonResponseDto<?>> json() throws Exception {
        return ResponseEntity.ok(CommonResponseDto.builder()
                .data(resPartService.json())
                .build());
    }
}
