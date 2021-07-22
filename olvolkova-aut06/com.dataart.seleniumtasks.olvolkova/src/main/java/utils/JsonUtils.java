package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.ApplicationJson;

public class JsonUtils {
    public static <T>T jsonToJavaObject(String json, Class<T> classType) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, classType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
