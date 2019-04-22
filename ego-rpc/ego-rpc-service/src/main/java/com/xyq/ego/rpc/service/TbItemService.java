package com.xyq.ego.rpc.service;

import com.xyq.ego.rpc.pojo.TbItem;
import com.xyq.entity.EgoResult;
import com.xyq.entity.PageResult;

import java.util.List;

/**
 * 商品基本信息处理接口
 */
public interface TbItemService {
    /**
     * 商品信息的分页查询
     * @param page
     * @param rows
     * @return
     */
    public PageResult<TbItem> loadTbItemListService(Integer page, Integer rows);

    /**
     * 商品的上架、下架、删除
     * @param itemid
     * @param status
     * @return
     */
    public EgoResult updateTbTbItemStatusService(List<Long> itemid, Byte status);

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

    /**
     * 根据商品id查询商品基本信息
     * @param id
     * @return
     */
    public TbItem loadTbItemService(Long id);


}
