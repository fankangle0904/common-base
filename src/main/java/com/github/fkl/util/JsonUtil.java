package com.github.fkl.util;

import com.github.fkl.bean.Test;
import com.github.fkl.util.json.JsonBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * Created by kanglefan on 17-5-24.
 */
public class JsonUtil {

    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static final String CONF_PATH = "/system.properties";
    private static final String CONST_CLASS = "json.class.name";
    private static JsonBase base;

    static {
        try {
            // 读取配置文件获取类
            Properties properties = new Properties();
            InputStream in = JsonUtil.class.getResourceAsStream(CONF_PATH);
            if (in == null) {
                throw new RuntimeException("input stream get fail");
            }
            properties.load(in);
            new JsonUtil(properties.getProperty(CONST_CLASS));
        } catch (Exception e) {
            logger.error("JsonUtil static exec error", e);
        }
    }

    private JsonUtil(String className) {
        try {
            Class clazz = Class.forName(className);
            if (clazz != null) {
                base = (JsonBase) Proxy.newProxyInstance(JsonBase.class.getClassLoader(),
                        new Class[]{JsonBase.class}, (InvocationHandler) clazz.newInstance());
            }
        } catch (Exception e) {
            logger.error("JsonUtil init error", e);
        }
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
