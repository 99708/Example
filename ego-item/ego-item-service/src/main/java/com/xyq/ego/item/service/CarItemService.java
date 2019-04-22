package com.xyq.ego.item.service;

import com.xyq.ego.item.entity.CarItem;
import com.xyq.entity.EgoResult;

import java.util.List;

/**
 * 用户购物车信息处理
 */
public interface CarItemService {
    /**
     * 将商品加入到购物车中
     * @param uid
     * @param itemid
     * @return
     */
    public CarItem saveItemToCarItem(Long uid, Long itemid);

    /**
     * 查看用户购物车中的商品
     * @param uid
     * @return
     */
    public List<CarItem> loadCarItemMapService(Long uid);

    /**
     * 更新用户的购物车中已有商品的数量
     * @param uid
     * @param itemid
     * @param num
     * @return
     */
    public EgoResult updateCarItemNum(Long uid, Long itemid, Integer num);

    /**
     * 根据商品id删除用户的购物车中已有商品
     * @param uid
     * @param itemid
     */
    public void deleteCarItemService(Long uid, Long itemid);

    /**
     * 清空用户购物车
     * @param uid
     */
    public void deleteCarItemAllService(Long uid);
}
