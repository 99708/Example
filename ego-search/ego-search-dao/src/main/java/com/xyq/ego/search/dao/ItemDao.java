package com.xyq.ego.search.dao;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;

public interface ItemDao {
    /**
     * 根据检索条件检索商品信息
     * @param params
     * @return
     */
    public QueryResponse loadItemList(SolrQuery params) throws SolrServerException;
}
