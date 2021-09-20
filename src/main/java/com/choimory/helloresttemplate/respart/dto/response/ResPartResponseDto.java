package com.choimory.helloresttemplate.respart.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Builder
@Getter
@RequiredArgsConstructor
public class ResPartResponseDto {
    private final String parkingName;
    private final String addr;
    private final String parkingCode;
    private final String parkingType;
    private final String parkingTypeNm;
    private final String operationRule;
    private final String operationRuleNm;
    private final String tel;
    private final String capacity;
    private final String payYn;
    private final String payNm;
    private final String nightFreeOpen;
    private final String nightFreeOpenNm;
    private final String weekdayBeginTime;
    private final String weekdayEndTime;
    private final String weekendBeginTime;
    private final String weekendEndTime;
    private final String holidayBeginTime;
    private final String holidayEndTime;
    private final String syncTime;
    private final String saturdayPayYn;
    private final String saturdayPayNm;
    private final String holidayPayYn;
    private final String holidayPayNm;
    private final String fulltimeMonthly;
    private final String grpParknm;
    private final String rates;
    private final String timeRate;
    private final String addRates;
    private final String addTimeRate;
    private final String busRates;
    private final String busTimeRate;
    private final String busAddTimeRate;
    private final String busAddRates;
    private final String dayMaximum;
    private final String lat;
    private final String lng;
    private final String assignCode;
    private final String assignCodeNm;
}
