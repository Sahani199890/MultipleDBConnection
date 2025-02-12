package com.abhideveloper.multipledbconnection.config.security;

import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.tomcat.util.codec.binary.Base64;

public class JWTTokenDecoder {

    String name;
    String email;
    String picture;

    public static JWTTokenDecoder getDecoded(String encodedToken) throws UnsupportedEncodingException  {
        String[] pieces = encodedToken.split("\\.");
        String b64payload = pieces[1];
        String jsonString = new String(Base64.decodeBase64(b64payload), "UTF-8");
        return new Gson().fromJson(jsonString, JWTTokenDecoder.class);
    }

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}