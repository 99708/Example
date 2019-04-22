package com.xyq.ego.item.entity;

import com.xyq.ego.rpc.pojo.TbItem;

import java.io.Serializable;

public class CarItem implements Serializable{
    private TbItem tbItem; //购物车中的商品信息
    private Integer num; //购物车中该商品的数量

    public TbItem getTbItem() {
        return tbItem;
    }

    public void setTbItem(TbItem tbItem) {
        this.tbItem = tbItem;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
