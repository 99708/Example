package com.xyq.ego.rpc.service.impl;

import com.xyq.ego.rpc.mapper.TbContentCategoryMapper;
import com.xyq.ego.rpc.pojo.TbContentCategory;
import com.xyq.ego.rpc.pojo.TbContentCategoryExample;
import com.xyq.ego.rpc.service.TbContentCategoryService;
import com.xyq.entity.EgoResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TbContentCategroyServiceImpl implements TbContentCategoryService {

    //注入mapper对象
    @Resource
    private TbContentCategoryMapper tbContentCategoryMapper;

    /**
     * 根据pid加载某个节点的所有子节点
     * @param pid
     * @return
     */
    @Override
    public List<TbContentCategory> loadTbContentCategroyListService(Long pid) {
        //创建
        try {
            TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
            TbContentCategoryExample.Criteria criteria = tbContentCategoryExample.createCriteria();
            criteria.andParentIdEqualTo(pid);
            List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByExample(tbContentCategoryExample);
            return tbContentCategories;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 增加网页内容分类
     * @param tbContentCategory
     * @return
     */
    @Override
    public EgoResult saveTbContentCategroyService(TbContentCategory tbContentCategory) {
        //添加网页内容子节点
        Date date = new Date();
        tbContentCategory.setCreated(date);
        tbContentCategory.setUpdated(date);
        tbContentCategory.setIsParent(false);
        tbContentCategory.setStatus(1);
        tbContentCategory.setSortOrder(1);
        int num = tbContentCategoryMapper.insertSelective(tbContentCategory);

        //更新父节点的状态
        TbContentCategory record = new TbContentCategory();
        record.setIsParent(true);
        record.setUpdated(date);
        TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = tbContentCategoryExample.createCriteria();
        criteria.andIdEqualTo(tbContentCategory.getParentId());
        int num2 = tbContentCategoryMapper.updateByExampleSelective(record, tbContentCategoryExample);
        if(num + num2 == 2){
            return EgoResult.ok();
        }

        return null;
    }

    /**
     * 更新网页内容分类
     * @param tbContentCategory
     * @return
     */
    @Override
    public EgoResult updateTbContentCategroyService(TbContentCategory tbContentCategory) {
        Date date = new Date();
        tbContentCategory.setUpdated(date);
        int num = tbContentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
        if(num == 1){
            return EgoResult.ok();
        }
        return null;
    }

    /**
     * 删除网页内容分类节点
     * @param id
     * @return
     */
    @Override
    public EgoResult deleteTbContentCategroyService(Long id) {

        Date date = new Date();

        //查询父节点的子节点数量信息
        TbContentCategory tbContentCategory = tbContentCategoryMapper.selectByPrimaryKey(id);
        TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = tbContentCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(tbContentCategory.getParentId());
        long num = tbContentCategoryMapper.countByExample(tbContentCategoryExample);
        if(num == 1){
            //更新父节点信息
            TbContentCategory tbContentCategory1 = new TbContentCategory();
            tbContentCategory1.setIsParent(false);
            tbContentCategory1.setUpdated(date);
            TbContentCategoryExample tbContentCategoryExample1 = new TbContentCategoryExample();
            TbContentCategoryExample.Criteria criteria1 = tbContentCategoryExample1.createCriteria();
            criteria1.andIdEqualTo(tbContentCategory.getParentId());
            tbContentCategoryMapper.updateByExampleSelective(tbContentCategory1,tbContentCategoryExample1);
        }

        //删除节点
        int num3 = tbContentCategoryMapper.deleteByPrimaryKey(id);
        if(num3 == 1){
            return EgoResult.ok();
        }
        return null;
    }
}
