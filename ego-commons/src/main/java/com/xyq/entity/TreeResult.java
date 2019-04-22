package com.xyq.entity;

import java.io.Serializable;

/**
 * 栏目树返回结果
 */
public class TreeResult implements Serializable{
    /**
     * 栏目id
     */
    private Long id;
    /**
     * 栏目名称
     */
    private String text;
    /**
     * 栏目状态
     */
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
