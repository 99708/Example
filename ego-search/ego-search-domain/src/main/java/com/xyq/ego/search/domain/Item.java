package com.xyq.ego.search.domain;

import org.apache.solr.client.solrj.beans.Field;

public class Item {
    @Field("id")
    private String id;
    @Field("title")
    private String title;
    @Field("sell_point")
    private String sell_point;
    @Field("catalog_name")
    private String catalog_name;
    @Field("price")
    private Long price;
    @Field("image")
    private String image;
    @Field("cid")
    private Long cid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSell_point() {
        return sell_point;
    }

    public void setSell_point(String sell_point) {
        this.sell_point = sell_point;
    }

    public String getCatalog_name() {
        return catalog_name;
    }

    public void setCatalog_name(String catalog_name) {
        this.catalog_name = catalog_name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String[] getImages() {
        return image.split(",");
    }
}
