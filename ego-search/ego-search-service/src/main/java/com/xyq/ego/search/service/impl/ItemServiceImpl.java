package com.xyq.ego.search.service.impl;

import com.xyq.ego.rpc.pojo.TbItem;
import com.xyq.ego.rpc.service.TbItemService;
import com.xyq.ego.search.dao.ItemDao;
import com.xyq.ego.search.domain.Item;
import com.xyq.ego.search.domain.ItemResult;
import com.xyq.ego.search.service.ItemService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {
    //注入dao层对象
    @Resource
    private ItemDao itemDaoImpl;

    //注入远程代理对象
    @Resource
    private TbItemService tbitemServiceProxy;
    /**
     * 根据检索条件检索商品信息
     * @param kws
     * @param page
     * @return
     */
    @Override
    public ItemResult loadItemListService(String kws, Integer page) throws SolrServerException {
        //创建SolrQuery对象封装检索条件
        SolrQuery solrQuery = new SolrQuery();
        //设置默认检索字段
        solrQuery.set("df", "kws");
        //设置主检索字段
        if(!StringUtils.isEmpty(kws)){
            solrQuery.setQuery(kws);
        }else{
            solrQuery.set("q", "*:*");
        }
        //设置分页
        Integer rows = 20;
        Integer startPage = (page - 1)*rows;
        solrQuery.setStart(startPage);
        solrQuery.setRows(rows);
        //开启高亮
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("title");
        solrQuery.setHighlightSimplePre("<font color='red'>");
        solrQuery.setHighlightSimplePost("</font>");

        //执行查询
        QueryResponse queryResponse = itemDaoImpl.loadItemList(solrQuery);
        SolrDocumentList results = queryResponse.getResults();
        //将Document对象转为List
        DocumentObjectBinder documentObjectBinder = new DocumentObjectBinder();
        List<Item> beans = documentObjectBinder.getBeans(Item.class, results);
        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
        //替换高亮数据
        for(Item item:beans){
            Map<String, List<String>> stringListMap = highlighting.get(item.getId());
            List<String> title = stringListMap.get("title");
            if(title != null && title.size()>0){
                item.setTitle(title.get(0));
            }
        }
        //创建结果对象
        ItemResult itemResult = new ItemResult();
        itemResult.setList(beans);
        //获取总记录数
        long numFound = results.getNumFound();
        //获取总页数
        long pageCount = (long) Math.ceil(numFound*1.0/rows);
        itemResult.setTotal(numFound);
        itemResult.setMaxpage(pageCount);
        return itemResult;
    }

    /**
     * 根据商品id查询商品基本信息
     * @param id
     * @return
     */
    @Override
    public TbItem loadTbItemService(Long id) {
        return tbitemServiceProxy.loadTbItemService(id);
    }
}
