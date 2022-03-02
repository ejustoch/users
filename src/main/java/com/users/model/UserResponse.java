package com.users.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class UserResponse {
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
    
    
}
