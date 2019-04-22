package com.xyq.ego.item.service.impl;

import com.xyq.ego.item.dao.CarItemDao;
import com.xyq.ego.item.entity.CarItem;
import com.xyq.ego.item.service.CarItemService;
import com.xyq.ego.rpc.pojo.TbItem;
import com.xyq.ego.rpc.service.TbItemService;
import com.xyq.entity.EgoResult;
import com.xyq.utils.JsonUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarItemServiceImpl implements CarItemService{

    //注入dao对象
    @Resource
    private CarItemDao carItemDaoImpl;

    //注入远程代理对象
    @Resource
    private TbItemService tbItemServiceProxy;
    /**
     * 将商品加入到购物车中
     * @param uid
     * @param itemid
     * @return
     */
    @Override
    public CarItem saveItemToCarItem(Long uid, Long itemid) {
        //获取用户购物车
        Map<String, String> map = null;
        map= carItemDaoImpl.loadCarItemMap(uid + "");
        if(StringUtils.isEmpty(map)){
           map = new HashMap<>();
        }
        //添加商品到用户购物车
        CarItem carItem = null;
        String carItemStr = map.get(itemid + "");
        if(StringUtils.isEmpty(carItemStr)){
            carItem = new CarItem();
            TbItem tbItem = tbItemServiceProxy.loadTbItemService(itemid);
            carItem.setTbItem(tbItem);
            carItem.setNum(1);
        }else {
            carItem = JsonUtils.jsonToPojo(carItemStr, CarItem.class);
            carItem.setNum(carItem.getNum()+1);
        }
        carItemStr = JsonUtils.objectToJson(carItem);
        map.put(itemid+"", carItemStr);
        //添加用户购物车的到redis库中
        carItemDaoImpl.saveCarItemMap(uid+"", map);
        //返回用户购物车中的商品信息
        return carItem;
    }

    /**
     * 查看用户购物车中的商品
     * @param uid
     * @return
     */
    @Override
    public List<CarItem> loadCarItemMapService(Long uid) {
        //创建结果对象
        List<CarItem> carItems = new ArrayList<>();
        //查询用户购物车
        Map<String, String> map = carItemDaoImpl.loadCarItemMap(uid + "");
        if(map != null){
            for(Map.Entry<String, String> entry:map.entrySet()){
                CarItem carItem = JsonUtils.jsonToPojo(entry.getValue(), CarItem.class);
                carItems.add(carItem);
            }
        }

        return carItems;
    }

    /**
     * 更新用户的购物车中已有商品的数量
     * @param uid
     * @param itemid
     * @param num
     * @return
     */
    @Override
    public EgoResult updateCarItemNum(Long uid, Long itemid, Integer num) {
        //查询用户购物车中的商品信息
        String carItemStr = carItemDaoImpl.loadCarItem(uid + "", itemid + "");
        CarItem carItem = JsonUtils.jsonToPojo(carItemStr, CarItem.class);
        carItem.setNum(num);
        carItemDaoImpl.updateCarItemNum(uid+"", itemid+"",JsonUtils.objectToJson(carItem));
        return EgoResult.ok();
    }

    /**
     * 根据商品id删除用户的购物车中已有商品
     * @param uid
     * @param itemid
     */
    @Override
    public void deleteCarItemService(Long uid, Long itemid) {
        carItemDaoImpl.deleteCarItem(uid+"", itemid+"");
    }

    /**
     * 清空用户购物车
     * @param uid
     */
    @Override
    public void deleteCarItemAllService(Long uid) {
        carItemDaoImpl.deleteCarItemAll(uid+"");
    }
}
