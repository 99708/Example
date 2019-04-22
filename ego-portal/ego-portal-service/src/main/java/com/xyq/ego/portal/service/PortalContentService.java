package com.xyq.ego.portal.service;

import com.xyq.ego.portal.entity.PicResult;

import java.util.List;

/**
 * 首页内容处理
 */
public interface PortalContentService {
    /**
     * 根据内容类目id获取图片信息
     * @param cid
     * @return
     */
    public List<PicResult> loadContentByCidService(Long cid);
}
