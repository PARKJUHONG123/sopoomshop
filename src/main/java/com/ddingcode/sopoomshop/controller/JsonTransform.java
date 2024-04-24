package com.ddingcode.sopoomshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public final class JsonTransform {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonTransform() {
        throw new UnsupportedOperationException();
    }

    public static String getJsonString(List<?> list) {
        log.info("[JsonTransform] target : " + list);
        try {
            String result = objectMapper.writeValueAsString(list);
            log.info("[JsonTransform] result : " + result);
            return result;
        }
        catch (JsonProcessingException e) {
            log.error("[JsonTransform] error ", e);
        }
        return "";
    }
}
