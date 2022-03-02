package com.users.model.backend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Support {
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("url")
    private String url;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("text")
    private String text;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
}
