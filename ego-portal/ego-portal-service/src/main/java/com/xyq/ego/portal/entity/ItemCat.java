package com.xyq.ego.portal.entity;

import java.io.Serializable;
import java.util.List;

public class ItemCat implements Serializable{

    private List<?> data;

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
