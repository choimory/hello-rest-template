package com.choimory.helloresttemplate.common.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonJsonParser {
    public static boolean isStringJson(String str){
        return StringUtils.startsWithIgnoreCase(str, "{");
    }

    public static Object parseJsonStringToMap(String[] orderedKeyList, String jsonString) throws ParseException {
        JSONParser jsonParser = new JSONParser(jsonString);
        Map<String, Object> json = jsonParser.parseObject();
        Object result = new Object();

        for(int i=0; i<orderedKeyList.length; i++){
            if(i==0){
                result = json.get(orderedKeyList[i]);
            } else {
                if(result instanceof List){
                    List<Map<String, ?>> parent = (List<Map<String, ?>>) result;
                    List<Object> child = new ArrayList<>();
                    for (Map<String, ?> stringMap : parent) {
                        child.add(stringMap.get(orderedKeyList[i]));
                    }
                    result = child;
                }else if(result instanceof Map){
                    Map<String, ?> parent = (Map<String, ?>) result;
                    result = parent.get(orderedKeyList[i]);
                }else{
                    Map<String, ?> parent = new HashMap<>();
                    result = parent.get(orderedKeyList[i]);
                }
            }
        }

        return result;
    }
}
