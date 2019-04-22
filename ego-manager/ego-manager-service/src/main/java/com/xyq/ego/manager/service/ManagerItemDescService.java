package com.xyq.ego.manager.service;

import com.xyq.entity.EgoResult;

public interface ManagerItemDescService {
    /**
     * 根据id获取商品描述信息
     * @param id
     * @return
     */
    public EgoResult loadTbItemDescByIdService(Long id);
}
