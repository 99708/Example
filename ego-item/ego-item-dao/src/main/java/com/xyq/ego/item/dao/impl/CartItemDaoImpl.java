package com.xyq.ego.item.dao.impl;

import com.xyq.ego.item.dao.CarItemDao;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;
@Repository
public class CartItemDaoImpl implements CarItemDao {
    //注入redisTemplate对象
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 将用户购物车中的商品信息缓存到redis库中
     * @param uid
     * @param map
     */
    @Override
    public void saveCarItemMap(String uid, Map<String, String> map) {
        //采用hash结构存储用户购物车
        redisTemplate.opsForHash().putAll(uid, map);
    }

    /**
     * 根据商品id获取用户购物车中的商品信息
     * @param uid
     * @param itemid
     * @return
     */
    @Override
    public String loadCarItem(String uid, String itemid) {
        String carItemStr = (String) redisTemplate.opsForHash().get(uid, itemid);
        return carItemStr;
    }

    /**
     * 获取用户的购物车
     * @param uid
     * @return
     */
    @Override
    public Map<String, String> loadCarItemMap(String uid) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        Map<String, String> map = hashOperations.entries(uid);
        return map;
    }

    /**
     * 根据商品id更新用户购物车中的商品数量
     * @param uid
     * @param itemid
     * @param caritem
     */
    @Override
    public void updateCarItemNum(String uid, String itemid, String caritem) {
        redisTemplate.opsForHash().put(uid, itemid, caritem);
    }

    /**
     * 根据商品id删除用户购物车中的商品
     * @param uid
     * @param itemid
     */
    @Override
    public void deleteCarItem(String uid, String itemid) {
        redisTemplate.opsForHash().delete(uid, itemid);
    }

    /**
     * 清空购物车
     * @param uid
     */
    @Override
    public void deleteCarItemAll(String uid) {
        redisTemplate.delete(uid);
    }
}
