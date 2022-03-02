package com.users.model.backend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id")
    private String  id;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("email")
    private String email;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("first_name")
    private String first_name;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("last_name")
    private String last_name;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("avatar")
    private String avatar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    
}
