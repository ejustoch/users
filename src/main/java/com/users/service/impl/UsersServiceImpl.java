package com.users.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.users.config.Configuracion;
import com.users.model.UserResponse;
import com.users.model.backend.Data;
import com.users.model.backend.ResponseApiUsers;
import com.users.service.UsersService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private Configuracion properties;

    @Override
    public UserResponse user() {

        UserResponse response = new UserResponse();
        ResponseApiUsers responseBack = new ResponseApiUsers();

        responseBack = apiUsers();
        List<String> datalist = new ArrayList<String>();

        for (Data d : responseBack.getData()) {
            String data = "";
            data = d.getId() + "|" + d.getLast_name() + "|" + d.getEmail();
            datalist.add(data);
        }

        response.setData(datalist);

        return response;
    }

    public ResponseApiUsers apiUsers() {

        ResponseApiUsers response = null;

        try {
            StringBuilder str = new StringBuilder();
            str.append(properties.getEndpoint());

            System.out.println("users.getEndpoint :" + str.toString());

            URL url = new URL(str.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json; charset=utf-8");
            conn.addRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
            conn.setDoOutput(true);
            StringBuffer sb = new StringBuffer();

            System.out.println("users.getResponseCode :" + conn.getResponseCode());
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                    String line;

                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                    }
                    System.out.println("users.bodyresponse :" + sb.toString());
                    ObjectMapper mapper = new ObjectMapper();
                    response = mapper.readValue(sb.toString(), ResponseApiUsers.class);

                }
            }

        } catch (Exception e) {
            System.out.println("users.error :" + e);
        }
        return response;

    }

}
