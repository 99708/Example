package com.xyq.ego.search.dao.impl;

import com.xyq.ego.search.dao.ItemDao;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ItemDaoImpl implements ItemDao {
    //注入httpsolrserver对象
    @Resource
    private CloudSolrServer server;

    /**
     * 根据检索条件检索商品信息
     * @param params
     * @return
     */
    @Override
    public QueryResponse loadItemList(SolrQuery params) throws SolrServerException {
        return server.query(params);
    }
}
