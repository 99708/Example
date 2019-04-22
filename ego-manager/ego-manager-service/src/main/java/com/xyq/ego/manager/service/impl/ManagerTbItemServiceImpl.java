package com.xyq.ego.manager.service.impl;

import com.xyq.ego.manager.service.ManagerTbItemService;
import com.xyq.ego.rpc.pojo.TbItem;
import com.xyq.ego.rpc.service.TbItemService;
import com.xyq.entity.EgoResult;
import com.xyq.entity.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerTbItemServiceImpl implements ManagerTbItemService {

    //注入远程代理对象
    @Resource
    private TbItemService tbItemServiceImpl;

    /**
     * 分页查询商品信息
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult<TbItem> loadItemListService(Integer page, Integer rows) {
        return tbItemServiceImpl.loadTbItemListService(page, rows);
    }

    /**
     * 商品信息的上架、下架、删除
     * @param ids
     * @param status
     * @return
     */
    @Override
    public EgoResult updateItemStatusService(String ids, Byte status) {
        String[] sids = ids.split(",");
        List<Long> idList = new ArrayList<Long>();
        for(String id:sids){
            idList.add(Long.parseLong(id));
        }
        return tbItemServiceImpl.updateTbTbItemStatusService(idList, status);
    }

    /**
     * 添加商品
     * @param tbItem
     * @param desc
     * @return
     */
    @Override
    public EgoResult saveTbItemService(TbItem tbItem, String desc, String itemParams) {
        return tbItemServiceImpl.saveTbItemService(tbItem, desc, itemParams);
    }

    @Override
    public EgoResult updateTbItemService(TbItem tbItem, String desc, String itemParams, Long itemParamId) {
        return tbItemServiceImpl.updateTbItemService(tbItem, desc, itemParams, itemParamId);
    }
}
