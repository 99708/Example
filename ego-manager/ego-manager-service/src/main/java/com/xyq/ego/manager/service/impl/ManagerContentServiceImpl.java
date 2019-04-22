package com.xyq.ego.manager.service.impl;

import com.xyq.ego.manager.service.ManagerContentService;
import com.xyq.ego.rpc.pojo.TbContent;
import com.xyq.ego.rpc.service.TbContentService;
import com.xyq.entity.EgoResult;
import com.xyq.entity.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 网页内容处理
 */
@Service
public class ManagerContentServiceImpl implements ManagerContentService {
    //注入远程代理对象
    @Resource
    private TbContentService tbContentServiceProxy;

    /**
     * 分页查询网页内容
     * @param cid
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult<TbContent> loadTbContentListServic(Long cid, Integer page, Integer rows) {
        return tbContentServiceProxy.loadTbContentListServic(cid, page, rows);
    }

    /**
     * 网站内容的增加
     * @param tbContent
     * @return
     */
    @Override
    public EgoResult saveTbContentService(TbContent tbContent) {
        return tbContentServiceProxy.saveTbContentService(tbContent);
    }

    /**
     * 网站内容的更新
     * @param tbContent
     * @return
     */
    @Override
    public EgoResult updateTbContentService(TbContent tbContent) {
        return tbContentServiceProxy.updateTbContentService(tbContent);
    }

    /**
     * 网站内容的删除
     * @param ids
     * @return
     */
    @Override
    public EgoResult deleteTbContentService(String ids) {
        String[] split = ids.split(",");
        List<Long> idList = new ArrayList<>();
        for(String s:split){
            idList.add(Long.parseLong(s));
        }
        return tbContentServiceProxy.deleteTbContentService(idList);
    }
}
