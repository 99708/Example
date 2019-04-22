package com.xyq.ego.manager.service.impl;

import com.xyq.ego.manager.service.ManagerContentCategoryServie;
import com.xyq.ego.rpc.pojo.TbContentCategory;
import com.xyq.ego.rpc.service.TbContentCategoryService;
import com.xyq.entity.EgoResult;
import com.xyq.entity.TreeResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 网站内容处理
 */
@Service
public class ManagerContentCategoryServieImpl implements ManagerContentCategoryServie {

    //注入远程代理对象
    @Resource
    private TbContentCategoryService tbContentCategoryServiceProxy;

    /**
     * 根据pid加载某个节点的所有子节点
     * @param pid
     * @return
     */
    @Override
    public List<TreeResult> loadTbContentCategroyListService(Long pid) {
        List<TbContentCategory> tbContentCategories = tbContentCategoryServiceProxy.loadTbContentCategroyListService(pid);
        List<TreeResult> treeResultList = new ArrayList<TreeResult>();
        for(TbContentCategory tbContentCategory:tbContentCategories){
            TreeResult treeResult = new TreeResult();
            treeResult.setText(tbContentCategory.getName());
            treeResult.setId(tbContentCategory.getId());
            treeResult.setState(tbContentCategory.getIsParent()?"closed":"open");
            treeResultList.add(treeResult);
        }
        return treeResultList;
    }

    /**
     * 增加网页内容分类
     * @param tbContentCategory
     * @return
     */
    @Override
    public EgoResult saveTbContentCategroyService(TbContentCategory tbContentCategory) {
        //远程调用
        EgoResult egoResult = tbContentCategoryServiceProxy.saveTbContentCategroyService(tbContentCategory);
        return egoResult;
    }

    /**
     * 更新网页内容分类
     * @param tbContentCategory
     * @return
     */
    @Override
    public EgoResult updateTbContentCategroyService(TbContentCategory tbContentCategory) {
        return tbContentCategoryServiceProxy.updateTbContentCategroyService(tbContentCategory);
    }

    /**
     * 删除网页内容分类
     * @param id
     * @return
     */
    @Override
    public EgoResult deleteTbContentCategroyService(Long id) {
        return tbContentCategoryServiceProxy.deleteTbContentCategroyService(id);
    }
}
