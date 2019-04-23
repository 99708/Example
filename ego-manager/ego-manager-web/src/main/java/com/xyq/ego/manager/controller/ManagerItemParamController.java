package com.xyq.ego.manager.controller;

import com.xyq.ego.manager.service.ManagerItemParamService;
import com.xyq.ego.rpc.pojo.TbItemParam;
import com.xyq.entity.EgoResult;
import com.xyq.entity.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ManagerItemParamController {
    //注入service层对象
    @Resource
    private ManagerItemParamService managerItemParamServiceImpl;

    /**
     * 声明单元方法处理根据类目id查询商品参数规格模板
     * @param cid
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("item/param/query/itemcatid/{cid}")
    public EgoResult itemParamQuery(@PathVariable Long cid){
        return managerItemParamServiceImpl.loadItemParamByCidService(cid);
    }

    /**
     * 声明单元方法处理添加商品参数规格模板
     * @param cid
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("/item/param/save/{cid}")
    public EgoResult itemParamSave(@PathVariable Long cid, String paramData){
        return managerItemParamServiceImpl.saveTbItemParamService(cid, paramData);
    }

    /**
     * 声明单元方法处理分页查询商品参数规格模板
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("/item/param/list")
    public PageResult<TbItemParam> itemParamList(Integer page, Integer rows){
        return managerItemParamServiceImpl.loadTbItemParamListService(page, rows);
    }

    /**
     * 声明单元方法处理批量删除商品参数规格模板
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/item/param/delete")
    public EgoResult itemParamList(String ids){
        return managerItemParamServiceImpl.deleteTbItemParamService(ids);
    }


}
