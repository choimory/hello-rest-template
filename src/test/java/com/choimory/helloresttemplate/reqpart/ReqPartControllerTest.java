package com.choimory.helloresttemplate.reqpart;

import com.choimory.helloresttemplate.reqpart.dto.request.ReqPartRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class ReqPartControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void GET_방식_TEST() throws Exception {
        /*Given*/
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("page", "1");
        requestParams.add("param1", "value111");
        requestParams.add("param2", "value222");
        requestParams.add("param3", "value333");

        /*When*/
        mockMvc.perform(MockMvcRequestBuilders.get("/req")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .params(requestParams))
                /*Then*/
                .andDo(print());
    }

    @Test
    void POST_방식_TEST() throws Exception {
        /*Given*/
        ReqPartRequestDto requestBody = ReqPartRequestDto.builder()
                .page(1)
                .param1("val111")
                .param2("val222")
                .param3("val333")
                .build();

        /*When*/
        mockMvc.perform(MockMvcRequestBuilders.post("/req")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(requestBody)))
                /*Then*/
                .andDo(print());
    }
}