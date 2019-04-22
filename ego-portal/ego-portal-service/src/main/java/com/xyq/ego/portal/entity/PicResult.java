package com.xyq.ego.portal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PicResult implements Serializable{
    @JsonProperty("srcB")
    private String srcb;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("alt")
    private String alt;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("src")
    private String src;
    @JsonProperty("widthB")
    private Integer widthb;
    @JsonProperty("href")
    private String href;
    @JsonProperty("heightB")
    private Integer heightb;

    public String getSrcb() {
        return srcb;
    }

    public void setSrcb(String srcb) {
        this.srcb = srcb;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getWidthb() {
        return widthb;
    }

    public void setWidthb(Integer widthb) {
        this.widthb = widthb;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getHeightb() {
        return heightb;
    }

    public void setHeightb(Integer heightb) {
        this.heightb = heightb;
    }
}
