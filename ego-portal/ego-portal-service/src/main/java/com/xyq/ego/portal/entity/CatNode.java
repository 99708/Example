package com.xyq.ego.portal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class CatNode implements Serializable{
    @JsonProperty(value = "u")
    private String url;
    @JsonProperty(value = "n")
    private String name;
    @JsonProperty(value = "i")
    private List<?> list;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
