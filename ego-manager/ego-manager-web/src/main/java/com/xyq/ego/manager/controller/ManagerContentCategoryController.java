package com.xyq.ego.manager.controller;

import com.xyq.ego.manager.service.ManagerContentCategoryServie;
import com.xyq.ego.rpc.pojo.TbContentCategory;
import com.xyq.entity.EgoResult;
import com.xyq.entity.TreeResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ManagerContentCategoryController {
    //注入service对象
    @Resource
    private ManagerContentCategoryServie managerContentCategoryServieImpl;

    /**
     * 处加载网页内容分类
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/content/category/list")
    public List<TreeResult> contentCategoryList(@RequestParam(defaultValue = "0") Long id){
        return managerContentCategoryServieImpl.loadTbContentCategroyListService(id);
    }

    /**
     * 处理加网页内容分类
     * @param tbContentCategory
     * @return
     */
    @ResponseBody
    @RequestMapping("/content/category/create")
    public EgoResult contentCategoryList(TbContentCategory tbContentCategory){
        return managerContentCategoryServieImpl.saveTbContentCategroyService(tbContentCategory);
    }

    /**
     * 处更新网页内容分类
     * @param tbContentCategory
     * @return
     */
    @ResponseBody
    @RequestMapping("/content/category/update")
    public EgoResult contentCategoryUpdate(TbContentCategory tbContentCategory){
        return managerContentCategoryServieImpl.updateTbContentCategroyService(tbContentCategory);
    }

    /**
     * 处理删除网页内容分类
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/content/category/delete/")
    public EgoResult contentCategoryDelete(Long id){
        return managerContentCategoryServieImpl.deleteTbContentCategroyService(id);
    }
}
