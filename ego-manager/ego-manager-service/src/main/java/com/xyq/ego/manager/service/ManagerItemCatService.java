package com.xyq.ego.manager.service;

import com.xyq.entity.TreeResult;

import java.util.List;

public interface ManagerItemCatService {
    /**
     * 根据id加载子节点
     * @param id
     * @return
     */
    public List<TreeResult> loadItemCatListService(Long id);
}
