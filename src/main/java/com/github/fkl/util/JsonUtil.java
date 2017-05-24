package com.github.fkl.util;

import com.github.fkl.bean.Test;
import com.github.fkl.util.json.JsonBase;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by kanglefan on 17-5-24.
 */
public class JsonUtil {

    private static JsonBase base;

    static {
        new JsonUtil("com.github.fkl.util.json.JacksonUtil");
    }

    private JsonUtil(String className) {
        try {
            Class clazz = Class.forName(className);
            if (clazz != null) {
                base = (JsonBase) Proxy.newProxyInstance(JsonBase.class.getClassLoader(),
                        new Class[]{JsonBase.class}, (InvocationHandler) clazz.newInstance());
            }
        } catch (Exception e) {}
    }

    public static String encode(Object obj) {
        return base.serialize(obj);
    }

    public static <T> T decode(String json, Class<T> type) {
        return base.deSerialize(json, type);
    }

    public static void main(String[] args) {
        System.out.println(JsonUtil.encode(new Test()));
    }
}
