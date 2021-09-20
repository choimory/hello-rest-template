# 개요

- 스프링 어플리케이션 내에서 외부의 REST API를 다양한 형태로 호출하는 방법을 학습
  - GET 및 POST 요청 예제로 사용할 API
    - resttesttest.com의 api.
    - 해당 api는 요청자가 요청한 내용을 그대로 응답한다
    - GET `https://httpbin.org/get`
    - POST `https://httpbin.org/post` 
- JSON/XML 결과를 받아, 이를 파싱하는 방법을 학습
  - JSON 및 XML 파싱 예제로 사용할 API
    - 공공데이터 API의 서울시 공공주차장 API.
    - API 문서 : `http://data.seoul.go.kr/dataList/OA-13122/A/1/datasetView.do`
    - GET `http://openapi.seoul.go.kr:8088/sample/json/GetParkInfo/1/5/` (JSON)
    - GET `http://openapi.seoul.go.kr:8088/sample/xml/GetParkInfo/1/5/` (XML)

# 다룰 내용

## 외부 API 요청하기

- GET 방식의 호출
    - Request Parameter
    - URI 인코딩
- POST 방식의 호출
    - Request Body
- Request Header
    - Accpet
    - Content-type
    - Basic Auth 
    - Bearer Token
- Request Body
    - JSON 형식의 Request Body

## 응답 내용 파싱하기

- Response Header
  - HttpStatus 코드 검증
- Response Body
  - JSON 파싱
  - XML 파싱

# 스택

- Spring boot 2.3.12
- Spring Web
- Spring Web Services
- H2
- Spring REST Docs