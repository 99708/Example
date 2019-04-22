package com.xyq.ego.search.domain;

import java.util.List;

public class ItemResult {
    private List<Item> list;
    private Long maxpage;
    private Long total;

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    public Long getMaxpage() {
        return maxpage;
    }

    public void setMaxpage(Long maxpage) {
        this.maxpage = maxpage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
