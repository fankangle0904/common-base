package com.github.fkl.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fkl.exception.JsonException;

/**
 * Created by kanglefan on 17-4-24.
 */
public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        //TODO 个性化设置ObjectMapper
    }

    public static String encode(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new JsonException("encode exception", e);
        }
    }

    public static <T> T decode(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (Exception e) {
            throw new JsonException("decode exception", e);
        }
    }
}
