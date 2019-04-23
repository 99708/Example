package com.xyq.ego.rpc.service;

import com.xyq.ego.rpc.pojo.TbContentCategory;
import com.xyq.entity.EgoResult;

import java.util.List;

/**
 * 网站内容分类处理
 */
public interface TbContentCategoryService {
    /**
     * 根据pid加载某个节点的所有子节点
     * @param pid
     * @return
     */
    public List<TbContentCategory> loadTbContentCategroyListService(Long pid);

    /**
     * 增加网页内容分类
     * @param tbContentCategory
     * @return
     */
    public EgoResult saveTbContentCategroyService(TbContentCategory tbContentCategory);

    /**
     * 更新网页内容分类
     * @param tbContentCategory
     * @return
     */
    public EgoResult updateTbContentCategroyService(TbContentCategory tbContentCategory);

    /**
     * 删除网页内容分类
     * @param id
     * @return
     */
    public EgoResult deleteTbContentCategroyService(Long id);
}
