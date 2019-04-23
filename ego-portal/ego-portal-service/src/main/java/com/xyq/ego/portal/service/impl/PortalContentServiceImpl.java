package com.xyq.ego.portal.service.impl;

import com.xyq.ego.portal.entity.PicResult;
import com.xyq.ego.portal.service.PortalContentService;
import com.xyq.ego.rpc.pojo.TbContent;
import com.xyq.ego.rpc.service.TbContentService;
import com.xyq.entity.PageResult;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PortalContentServiceImpl implements PortalContentService {
    //注入远程代理对象
    @Resource
    private TbContentService tbContentServiceProxy;

    /**
     * 根据类目id获取内容
     * @param cid
     * @return
     */
    @Cacheable(cacheNames="cotent_cache",key="#root.methodName+#cid")
    @Override
    public List<PicResult> loadContentByCidService(Long cid) {
        PageResult<TbContent> pageResult = tbContentServiceProxy.loadTbContentListServic(cid, 1, 10);
        List<PicResult> picResults = new ArrayList<>();
        for(TbContent t:pageResult.getRows()){
            PicResult picResult = new PicResult();
            picResult.setSrcb(t.getPic());
            picResult.setSrc(t.getPic2());
            picResult.setAlt(t.getTitle());
            picResult.setHeight(240);
            picResult.setHeightb(240);
            picResult.setWidth(670);
            picResult.setWidthb(670);
            picResult.setHref(t.getUrl());

            picResults.add(picResult);
        }
        return picResults;
    }
}
