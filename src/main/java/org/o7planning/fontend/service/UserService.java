package org.o7planning.fontend.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    public static final String REST_SERVICE_URI = "http://localhost:8081/login/";
    RestTemplate restTemplate = new RestTemplate();

    public Boolean checkUser(String email, String password){
        Map<String, String> map = new HashMap<String,String>();
        map.put("email",email);
        map.put("password", password);
        return restTemplate.postForObject(REST_SERVICE_URI, map, String.class).equals("true") ? true : false;
    }

    public static void main(String[] args) {
        UserService u = new UserService();
        System.out.println("login: "+u.checkUser("do", "hai"));
    }
}
