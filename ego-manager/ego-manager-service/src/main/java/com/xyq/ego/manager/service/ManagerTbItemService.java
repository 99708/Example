package com.xyq.ego.manager.service;

import com.xyq.ego.rpc.pojo.TbItem;
import com.xyq.entity.EgoResult;
import com.xyq.entity.PageResult;

public interface ManagerTbItemService {
    /**
     * 分页查询商品信息
     * @param page
     * @param rows
     * @return
     */
    public PageResult<TbItem> loadItemListService(Integer page, Integer rows);

    /**
     * 商品的下架、删除、上架
     * @param ids
     * @param status
     * @return
     */
    public EgoResult updateItemStatusService(String ids, Byte status);
    /**
     * 添加商品
     * @param tbItem
     * @param desc
     * @return
     */
    public EgoResult saveTbItemService(TbItem tbItem, String desc, String itemParams);

    /**
     * 商品更新
     * @param tbItem
     * @param desc
     * @return
     */
    public EgoResult updateTbItemService(TbItem tbItem, String desc, String itemParams, Long itemParamId);
}
