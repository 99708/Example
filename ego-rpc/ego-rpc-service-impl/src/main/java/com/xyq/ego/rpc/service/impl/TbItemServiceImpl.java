package com.xyq.ego.rpc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xyq.ego.rpc.mapper.TbItemDescMapper;
import com.xyq.ego.rpc.mapper.TbItemMapper;
import com.xyq.ego.rpc.mapper.TbItemParamItemMapper;
import com.xyq.ego.rpc.pojo.TbItem;
import com.xyq.ego.rpc.pojo.TbItemDesc;
import com.xyq.ego.rpc.pojo.TbItemExample;
import com.xyq.ego.rpc.pojo.TbItemParamItem;
import com.xyq.ego.rpc.service.TbItemService;
import com.xyq.entity.EgoResult;
import com.xyq.entity.PageResult;
import com.xyq.utils.IDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TbItemServiceImpl implements TbItemService {

    //注入商品基本信息处理mapper对象
    @Resource
    private TbItemMapper tbItemMapper;

    //注入商品描述处理mapper对象
    @Resource
    private TbItemDescMapper tbItemDescMapper;

    //注入商品参数规格处理mapper对象
    @Resource
    private TbItemParamItemMapper tbItemParamItemMapper;

    /**
     * 商品信息的分页查询
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult<TbItem> loadTbItemListService(Integer page, Integer rows) {

        //分页
        Page startPage = PageHelper.startPage(page, rows);

        //查询结果
        TbItemExample tbItemExample = new TbItemExample();
        List<TbItem> tbItems = tbItemMapper.selectByExample(tbItemExample);

        //将分页查询结果封装
        PageResult<TbItem> pageResult = new PageResult<>();
        pageResult.setRows(tbItems);
        pageResult.setTotal(startPage.getTotal());
        //返回结果
        return pageResult;
    }

    /**
     * 商品信息的上架、下架、删除
     * @param itemid
     * @param status
     * @return
     */
    @Override
    public EgoResult updateTbTbItemStatusService(List<Long> itemid, Byte status) {
        //设置商品状态
        TbItem tbItem = new TbItem();
        tbItem.setStatus(status);
        //封装查询条件
        TbItemExample tbItemExample = new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andIdIn(itemid);
        int num = tbItemMapper.updateByExampleSelective(tbItem, tbItemExample);
        if(num > 0){
            return EgoResult.ok();
        }
        return null;
    }

    /**
     * 商品信息的添加
     * @param tbItem
     * @param desc
     * @param itemParams
     * @return
     */
    @Override
    public EgoResult saveTbItemService(TbItem tbItem, String desc, String itemParams) {
        //商品基本信息的添加
        Date date = new Date();
        //创建商品id
        long itemId = IDUtils.genItemId();
        tbItem.setId(itemId);
        tbItem.setUpdated(date);
        tbItem.setCreated(date);
        int selective = tbItemMapper.insertSelective(tbItem);
        //商品描述信息的添加
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        tbItemDesc.setItemDesc(desc);
        int selective1 = tbItemDescMapper.insertSelective(tbItemDesc);
        //商品参数规格添加
        TbItemParamItem tbItemParamItem = new TbItemParamItem();
        tbItemParamItem.setParamData(itemParams);
        tbItemParamItem.setItemId(itemId);
        tbItemParamItem.setCreated(date);
        tbItemParamItem.setUpdated(date);
        int num = tbItemParamItemMapper.insertSelective(tbItemParamItem);

        if(selective + selective1 + num == 3){
            return EgoResult.ok();
        }
        return null;
    }

    /**
     * 商品信息的更新
     * @param tbItem
     * @param desc
     * @return
     */
    @Override
    public EgoResult updateTbItemService(TbItem tbItem, String desc, String itemParams, Long itemParamId) {
        //更新商品信息
        Date date = new Date();
        tbItem.setUpdated(date);
        int num = tbItemMapper.updateByPrimaryKeySelective(tbItem);
        //更新商品描述
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(tbItem.getId());
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setUpdated(date);
        int num2 = tbItemDescMapper.updateByPrimaryKeySelective(tbItemDesc);
        //更新商品规格参数
        TbItemParamItem tbItemParamItem = new TbItemParamItem();
        tbItemParamItem.setId(itemParamId);
        tbItemParamItem.setItemId(tbItem.getId());
        tbItemParamItem.setUpdated(date);
        tbItemParamItem.setParamData(itemParams);
        int num3 = tbItemParamItemMapper.updateByPrimaryKeySelective(tbItemParamItem);
        if(num + num2 + num3 == 3){
            return EgoResult.ok();
        }
        return null;
    }

    /**
     * 根据商品id查询商品基本信息
     * @param id
     * @return
     */
    @Override
    public TbItem loadTbItemService(Long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }
}
