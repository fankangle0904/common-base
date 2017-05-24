package com.github.fkl.util.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fkl.exception.JsonException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by kanglefan on 17-4-24.
 */
public class JacksonUtil implements JsonBase, InvocationHandler {

    //TODO 个性化设置ObjectMapper
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this, args);
    }

    @Override
    public String serialize(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new JsonException("encode exception", e);
        }
    }

    @Override
    public <T> T deSerialize(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (Exception e) {
            throw new JsonException("decode exception", e);
        }
    }
}
