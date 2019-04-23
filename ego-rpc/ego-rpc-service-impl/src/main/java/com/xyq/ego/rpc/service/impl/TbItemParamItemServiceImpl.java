package com.xyq.ego.rpc.service.impl;

import com.xyq.ego.rpc.mapper.TbItemParamItemMapper;
import com.xyq.ego.rpc.pojo.TbItemParamItem;
import com.xyq.ego.rpc.pojo.TbItemParamItemExample;
import com.xyq.ego.rpc.service.TbItemParamItemService;
import com.xyq.entity.EgoResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品参数规格模板内容处理
 */
@Service
public class TbItemParamItemServiceImpl implements TbItemParamItemService {

    //注入mapper接口对象
    @Resource
    private TbItemParamItemMapper tbItemParamItemMapper;

    /**
     *根据商品id查询商品参数规格模板内容
     * @param itemId
     * @return
     */
    @Override
    public EgoResult loadTbItemParamItemByItemIdServices(Long itemId) {

        //创建结果对象
        EgoResult egoResult = new EgoResult();

        TbItemParamItemExample tbItemParamItemExample = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = tbItemParamItemExample.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<TbItemParamItem> tbItemParamItems = tbItemParamItemMapper.selectByExampleWithBLOBs(tbItemParamItemExample);
        if(tbItemParamItems.size() > 0){
            egoResult.setData(tbItemParamItems.get(0));
            egoResult.setStatus(200);
            return egoResult;
        }
        return null;
    }
}
