package com.xyq.ego.rpc.service;

import com.xyq.ego.rpc.pojo.TbItemParam;
import com.xyq.entity.EgoResult;
import com.xyq.entity.PageResult;

import java.util.List;

/**
 * 规格参数模板处理
 */
public interface TbItemParamService {
    /**
     * 根据类名id查询规格参数模板
     * @param cid
     * @return
     */
    public EgoResult loadTbItemParamByCidService(Long cid);

    /**
     * 增加商品参数规格模板
     * @return
     */
    public EgoResult saveTbItemParamService(Long cid, String paramData);

    /**
     * 分页查询商品参数规格模板
     * @param page
     * @param rows
     * @return
     */
    public PageResult<TbItemParam> loadTbItemParamListService(Integer page, Integer rows);

    /**
     * 根据id批量删除商品参数规格模板信息
     * @param ids
     * @return
     */
    public EgoResult deleteTbItemParamService(List<Long> ids);
}
