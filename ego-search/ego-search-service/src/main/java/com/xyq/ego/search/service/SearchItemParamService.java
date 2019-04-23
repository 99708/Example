package com.xyq.ego.search.service;

/**
 * 商品规格参数处理
 */
public interface SearchItemParamService {
    /**
     * 根据商品id查询商品规格参数信息
     * @param itemid
     * @return
     */
    public String loadItemParamsService(Long itemid);
}
