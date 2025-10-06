package com.saucedemo.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class UserLoader {

    public static String getUsername(String userKey) {
        return getField(userKey, "username");
    }

    public static String getPassword(String userKey) {
        return getField(userKey, "password");
    }

    private static String getField(String userKey, String field) {
        try {
            InputStream is = UserLoader.class.getClassLoader().getResourceAsStream("data/users.json");
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(is);
            return root.get(userKey).get(field).asText();
        } catch (Exception e) {
            throw new RuntimeException("Could not read user data", e);
        }
    }
}
