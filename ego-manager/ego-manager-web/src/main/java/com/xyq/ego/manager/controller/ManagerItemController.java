package com.xyq.ego.manager.controller;

import com.xyq.ego.manager.service.ManagerTbItemService;
import com.xyq.ego.rpc.pojo.TbItem;
import com.xyq.entity.EgoResult;
import com.xyq.entity.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ManagerItemController {

    //注入自己的service实例对象
    @Resource
    private ManagerTbItemService managerTbItemServiceImpl;

    /**
     * 处理分页商品查询请求
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("/item/list")
    public PageResult<TbItem> itemList(Integer page, Integer rows){
        return managerTbItemServiceImpl.loadItemListService(page, rows);
    }

    /**
     * 处理商品的下架请求
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/rest/item/instock")
    public EgoResult restItemInstock(String ids){
        return managerTbItemServiceImpl.updateItemStatusService(ids, (byte)2);
    }

    /**
     * 处理商品的上架请求
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/rest/item/reshelf")
    public EgoResult restItemReshelf(String ids){
        return managerTbItemServiceImpl.updateItemStatusService(ids, (byte)1);
    }

    /**
     * 处理商品的删除请求
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/rest/item/delete")
    public EgoResult restItemDelete(String ids){
        return managerTbItemServiceImpl.updateItemStatusService(ids, (byte)3);
    }

    /**
     * 处理添加商品请求
     * @param tbItem
     * @param desc
     * @return
     */
    @ResponseBody
    @RequestMapping("/item/save")
    public EgoResult itemSave(TbItem tbItem, String desc, String itemParams){
       return managerTbItemServiceImpl.saveTbItemService(tbItem, desc, itemParams);
    }

    /**
     * 处理更新商品请求
     * @param tbItem
     * @param desc
     * @return
     */
    @ResponseBody
    @RequestMapping("/rest/item/update")
    public EgoResult itemUpate(TbItem tbItem, String desc, String itemParams, Long itemParamId){
        return managerTbItemServiceImpl.updateTbItemService(tbItem, desc, itemParams, itemParamId);
    }

}
