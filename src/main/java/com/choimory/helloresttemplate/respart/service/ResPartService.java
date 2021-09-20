package com.choimory.helloresttemplate.respart.service;

import com.choimory.helloresttemplate.common.exception.CustomException;
import com.choimory.helloresttemplate.common.parser.CommonJsonParser;
import com.choimory.helloresttemplate.common.parser.CommonXmlParser;
import com.choimory.helloresttemplate.common.response.CommonResponseCode;
import com.choimory.helloresttemplate.respart.dto.response.ResPartResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ResPartService {
    @Value("${respart.api.xml}")
    private String xmlUrl;
    @Value("${respart.api.json}")
    private String jsonUrl;

    public List<ResPartResponseDto> xml() throws Exception {
        /*호출*/
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(xmlUrl, HttpMethod.GET, null, String.class);

        /*응답코드 확인*/
        responseValidation(response);
        if(!CommonXmlParser.isStringXml(response.getBody())){
            throw new CustomException(CommonResponseCode.INTERNAL_SERVER_ERROR.getCode(), "응답값이 Xml이 아님");
        }

        /*파싱*/
        List<Map<String, ?>> result = CommonXmlParser.parseXmlStringToListMap(response.getBody(), "row");
        List<ResPartResponseDto> dtos = rowsToDtos(result);

        return dtos;
    }

    public List<ResPartResponseDto> json() throws Exception {
        /*호출*/
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(jsonUrl, HttpMethod.GET, null, String.class);

        /*응답코드 확인*/
        responseValidation(response);
        if(!CommonJsonParser.isStringJson(response.getBody())){
            throw new CustomException(CommonResponseCode.INTERNAL_SERVER_ERROR.getCode(), "응답값이 Json이 아님");
        }

        /*파싱*/
        Object result = CommonJsonParser.parseJsonStringToMap(new String[]{"GetParkInfo", "row"}, response.getBody());
        List<ResPartResponseDto> dtos = rowsToDtos((List<Map<String,?>>) result);

        return dtos;
    }

    private void responseValidation(ResponseEntity<?> response) throws Exception {
        if(response.getStatusCodeValue() != 200){
            throw new CustomException(CommonResponseCode.INTERNAL_SERVER_ERROR.getCode(), "외부 API 응답오류");
        };
    }

    private List<ResPartResponseDto> rowsToDtos(List<Map<String, ?>> rows){
        List<ResPartResponseDto> dtos = new ArrayList<>();
        rows.forEach(row -> {
            dtos.add(ResPartResponseDto.builder()
                    .parkingName((String) row.get("PARKING_NAME"))
                    .addr((String)row.get("ADDR"))
                    .parkingCode((String)row.get("PARKING_CODE"))
                    .parkingType((String)row.get("PARKING_TYPE"))
                    .parkingTypeNm((String)row.get("PARKING_TYPE_NM"))
                    .operationRule((String)row.get("OPERATION_RULE"))
                    .operationRuleNm((String)row.get("OPERATION_RULE_NM"))
                    .tel((String)row.get("TEL"))
                    .capacity(row.get("CAPACITY").toString())
                    .payYn((String)row.get("PAY_YN"))
                    .payNm((String)row.get("PAY_NM"))
                    .nightFreeOpen((String)row.get("NIGHT_FREE_OPEN"))
                    .nightFreeOpenNm((String)row.get("NIGHT_FREE_OPEN_NM"))
                    .weekdayBeginTime((String)row.get("WEEKDAY_BEGIN_TIME"))
                    .weekdayEndTime((String)row.get("WEEKDAY_END_TIME"))
                    .weekendBeginTime((String)row.get("WEEKEND_BEGIN_TIME"))
                    .weekendEndTime((String)row.get("WEEKEND_END_TIME"))
                    .holidayBeginTime((String)row.get("HOLIDAY_BEGIN_TIME"))
                    .holidayEndTime((String)row.get("HOLIDAY_END_TIME"))
                    .syncTime((String)row.get("SYNC_TIME"))
                    .saturdayPayYn((String)row.get("SATURDAY_PAY_YN"))
                    .saturdayPayNm((String)row.get("SATURDAY_PAY_NM"))
                    .holidayPayYn((String)row.get("HOLIDAY_PAY_YN"))
                    .holidayPayNm((String)row.get("HOLIDAY_PAY_NM"))
                    .fulltimeMonthly((String)row.get("FULLTIME_MONTHLY"))
                    .grpParknm((String)row.get("GRP_PARKNM"))
                    .rates(row.get("RATES").toString())
                    .timeRate(row.get("TIME_RATE").toString())
                    .addRates(row.get("ADD_RATES").toString())
                    .addTimeRate(row.get("ADD_TIME_RATE").toString())
                    .busRates(row.get("BUS_RATES").toString())
                    .busTimeRate(row.get("BUS_TIME_RATE").toString())
                    .busAddTimeRate(row.get("BUS_ADD_TIME_RATE").toString())
                    .busAddRates(row.get("BUS_ADD_RATES").toString())
                    .dayMaximum(row.get("DAY_MAXIMUM").toString())
                    .lat(row.get("LAT").toString())
                    .lng(row.get("LNG").toString())
                    .assignCode((String)row.get("ASSIGN_CODE"))
                    .assignCodeNm((String)row.get("ASSIGN_CODE_NM"))
                    .build());
        });

        return dtos;
    }
}
