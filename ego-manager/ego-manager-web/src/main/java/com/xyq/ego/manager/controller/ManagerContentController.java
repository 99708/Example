package com.xyq.ego.manager.controller;

import com.xyq.ego.manager.service.ManagerContentService;
import com.xyq.ego.rpc.pojo.TbContent;
import com.xyq.entity.EgoResult;
import com.xyq.entity.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ManagerContentController {
    //注入service对象
    @Resource
    private ManagerContentService managerContentServiceImpl;

    /**
     * 处理分页查询网页内容
     * @param categoryId
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("/content/query/list")
    public PageResult<TbContent> contentQueryList(Long categoryId, Integer page, Integer rows){
        return managerContentServiceImpl.loadTbContentListServic(categoryId, page, rows);
    }

    /**
     * 处理网站内容的增加
     * @param tbContent
     * @return
     */
    @ResponseBody
    @RequestMapping("/content/save")
    public EgoResult contentSave(TbContent tbContent){
        return managerContentServiceImpl.saveTbContentService(tbContent);
    }

    /**
     * 处理网站内容的更新
     * @param tbContent
     * @return
     */
    @ResponseBody
    @RequestMapping("/rest/content/edit")
    public EgoResult restContentEdit(TbContent tbContent){
        return managerContentServiceImpl.updateTbContentService(tbContent);
    }

    /**
     * 处理网站内容的删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/content/delete")
    public EgoResult contentQueryList(String ids){
        return managerContentServiceImpl.deleteTbContentService(ids);
    }
}
