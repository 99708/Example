package com.xyq.ego.rpc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xyq.ego.rpc.mapper.TbContentMapper;
import com.xyq.ego.rpc.pojo.TbContent;
import com.xyq.ego.rpc.pojo.TbContentExample;
import com.xyq.ego.rpc.service.TbContentService;
import com.xyq.entity.EgoResult;
import com.xyq.entity.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 网站内容处理
 */
@Service
public class TbContentServiceImpl implements TbContentService {
    //注入mapper对象
    @Resource
    private TbContentMapper tbContentMapper;

    /**
     * 分页查询网页内容
     * @param cid
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult<TbContent> loadTbContentListServic(Long cid, Integer page, Integer rows) {
        //创建分页插件对象
        PageHelper pageHelper = new PageHelper();
        //创建查询条件对象
        Page startPage = pageHelper.startPage(page, rows);
        TbContentExample tbContentExample = new TbContentExample();
        TbContentExample.Criteria criteria = tbContentExample.createCriteria();
        criteria.andCategoryIdEqualTo(cid);
        //执行查询
        List<TbContent> tbContents = tbContentMapper.selectByExample(tbContentExample);
        //创建结果对象
        PageResult<TbContent> pageResult = new PageResult<TbContent>();

        if(tbContents.size() > 0){
            pageResult.setRows(tbContents);
            pageResult.setTotal(startPage.getTotal());
            return pageResult;
        }
        return null;
    }

    /**
     * 网站内容的增加
     * @param tbContent
     * @return
     */
    @Override
    public EgoResult saveTbContentService(TbContent tbContent) {
        Date date = new Date();
        tbContent.setCreated(date);
        tbContent.setUpdated(date);
        int num = tbContentMapper.insertSelective(tbContent);
        if(num == 1){
            return EgoResult.ok();
        }
        return null;
    }

    /**
     * 网站内容的更新
     * @param tbContent
     * @return
     */
    @Override
    public EgoResult updateTbContentService(TbContent tbContent) {
        int num = tbContentMapper.updateByPrimaryKeySelective(tbContent);
        if(num == 1){
            return EgoResult.ok();
        }
        return null;
    }

    /**
     * 网站内容的删除
     * @param ids
     * @return
     */
    @Override
    public EgoResult deleteTbContentService(List<Long> ids) {
        TbContentExample tbContentExample = new TbContentExample();
        TbContentExample.Criteria criteria = tbContentExample.createCriteria();
        criteria.andIdIn(ids);
        int num = tbContentMapper.deleteByExample(tbContentExample);
        if(num == 1){
            return EgoResult.ok();
        }
        return null;
    }
}
