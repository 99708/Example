package com.xyq.ego.item.dao;

import java.util.Map;

/**
 * 用户购物车信息处理
 */
public interface CarItemDao {
    /**
     * 将用户购物车中的商品信息缓存到redis库中
     * @param uid
     * @param map
     */
    public void saveCarItemMap(String uid, Map<String, String> map);

    /**
     * 根据用户id和商品id查询购物车中商品信息
     * @param uid
     * @param itemid
     * @return
     */
    public String loadCarItem(String uid, String itemid);

    /**
     * 根据用户id获取用户购物车
     * @param uid
     * @return
     */
    public Map<String, String> loadCarItemMap(String uid);

    /**
     * 更新用户的购物车中已有商品的数量
     * @param uid
     * @param itemid
     * @param caritem
     */
    public void updateCarItemNum(String uid, String itemid, String caritem);

    /**
     * 根据商品id删除用户的购物车中已有商品
     * @param uid
     * @param itemid
     */
    public void deleteCarItem(String uid, String itemid);

    /**
     * 清空用户购物车
     * @param uid
     */
    public void deleteCarItemAll(String uid);

}
