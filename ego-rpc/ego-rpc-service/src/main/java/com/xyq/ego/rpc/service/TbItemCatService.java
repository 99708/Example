package com.xyq.ego.rpc.service;

import com.xyq.ego.rpc.pojo.TbItemCat;
import com.xyq.entity.TreeResult;

import java.util.List;

public interface TbItemCatService {
    /**
     * 根据id加载节点的子节点
     * @param id
     * @return
     */
    public List<TreeResult> loadTbItemCatListService(Long id);

    /**
     * 查询所有类目
     * @return
     */
    public List<TbItemCat> loadTbItemCatService();
}
