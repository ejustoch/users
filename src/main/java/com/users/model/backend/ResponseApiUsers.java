package com.users.model.backend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseApiUsers {
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("page")
    private String page;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("per_page")
    private String per_page;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("total")
    private String total;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("total_pages")
    private String total_pages;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    private List<Data> data;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("support")
    private Support support;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPer_page() {
        return per_page;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
    
    
}
