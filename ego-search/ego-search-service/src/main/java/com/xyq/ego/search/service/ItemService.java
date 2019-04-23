package com.xyq.ego.search.service;

import com.xyq.ego.rpc.pojo.TbItem;
import com.xyq.ego.search.domain.ItemResult;
import org.apache.solr.client.solrj.SolrServerException;

public interface ItemService {
    /**
     * 根据检索条件检索商品信息
     * @param kws
     * @param page
     * @return
     */
    public ItemResult loadItemListService(String kws, Integer page) throws SolrServerException;

    /**
     * 根据商品id查询商品基本信息
     * @param id
     * @return
     */
    public TbItem loadTbItemService(Long id);
}
