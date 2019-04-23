package com.xyq.ego.rpc.service;

import com.xyq.ego.rpc.pojo.TbContent;
import com.xyq.entity.EgoResult;
import com.xyq.entity.PageResult;

import java.util.List;

/**
 * 网页内容处理
 */
public interface TbContentService {
    /**
     * 分页查询网页内容
     * @param cid
     * @param page
     * @param rows
     * @return
     */
    public PageResult<TbContent> loadTbContentListServic(Long cid, Integer page, Integer rows);

    /**
     * 网站内容的增加
     * @param tbContent
     * @return
     */
    public EgoResult saveTbContentService(TbContent tbContent);

    /**
     * 网站内容的更新
     * @param tbContent
     * @return
     */
    public EgoResult updateTbContentService(TbContent tbContent);

    /**
     * 网站内容的删除
     * @param ids
     * @return
     */
    public EgoResult deleteTbContentService(List<Long> ids);

}
