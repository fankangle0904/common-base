package com.github.fkl.util.json;

/**
 * Created by kanglefan on 17-5-24.
 */
public interface JsonBase {

    String serialize(Object obj);

    <T> T deSerialize(String json,  Class<T> type);
}
