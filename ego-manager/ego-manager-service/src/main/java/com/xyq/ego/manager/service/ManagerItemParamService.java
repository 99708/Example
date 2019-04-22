package com.xyq.ego.manager.service;

import com.xyq.ego.rpc.pojo.TbItemParam;
import com.xyq.entity.EgoResult;
import com.xyq.entity.PageResult;

/**
 * 商品规格参数管理接口
 */
public interface ManagerItemParamService {
    /**
     * 根据类目id查询商品参数规格模板
     * @param cid
     * @return
     */
    public EgoResult loadItemParamByCidService(Long cid);

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
    public EgoResult deleteTbItemParamService(String ids);
}
