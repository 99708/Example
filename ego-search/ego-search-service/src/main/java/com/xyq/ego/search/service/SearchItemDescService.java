package com.xyq.ego.search.service;

/**
 * 商品描述信息查询
 */
public interface SearchItemDescService {
    /**
     * 根据商品id查询商品描述信息
     * @param id
     * @return
     */
    public String loadItemDescService(Long id);
}
