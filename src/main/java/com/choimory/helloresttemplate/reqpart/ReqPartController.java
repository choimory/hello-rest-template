package com.choimory.helloresttemplate.reqpart;

import com.choimory.helloresttemplate.common.response.CommonResponseDto;
import com.choimory.helloresttemplate.reqpart.dto.request.ReqPartRequestDto;
import com.choimory.helloresttemplate.reqpart.service.ReqPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/req")
public class ReqPartController {
    private final ReqPartService reqPartService;

    @GetMapping
    public ResponseEntity<CommonResponseDto<?>> get(final ReqPartRequestDto param) throws Exception {
        return ResponseEntity.ok(CommonResponseDto.builder()
                .data(reqPartService.get(param))
                .build());
    }

    @PostMapping
    public ResponseEntity<CommonResponseDto<?>> post(@RequestBody(required = false) final ReqPartRequestDto param) throws Exception {
        return ResponseEntity.ok(CommonResponseDto.builder()
                .data(reqPartService.post(param))
                .build());
    }
}
