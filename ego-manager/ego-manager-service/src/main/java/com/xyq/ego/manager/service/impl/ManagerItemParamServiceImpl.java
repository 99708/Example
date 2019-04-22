package com.xyq.ego.manager.service.impl;

import com.xyq.ego.manager.service.ManagerItemParamService;
import com.xyq.ego.rpc.pojo.TbItemParam;
import com.xyq.ego.rpc.service.TbItemParamService;
import com.xyq.entity.EgoResult;
import com.xyq.entity.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerItemParamServiceImpl implements ManagerItemParamService {

    //注入远程代理对象
    @Resource
    private TbItemParamService tbItemParamServiceProxy;

    @Override
    public EgoResult loadItemParamByCidService(Long cid) {
        return tbItemParamServiceProxy.loadTbItemParamByCidService(cid);
    }

    @Override
    public EgoResult saveTbItemParamService(Long cid, String paramData) {
        return tbItemParamServiceProxy.saveTbItemParamService(cid, paramData);
    }

    @Override
    public PageResult<TbItemParam> loadTbItemParamListService(Integer page, Integer rows) {
        return tbItemParamServiceProxy.loadTbItemParamListService(page, rows);
    }

    @Override
    public EgoResult deleteTbItemParamService(String ids) {
        String[] split = ids.split(",");
        List<Long> idList = new ArrayList<>();
        for(String s:split){
            idList.add(Long.parseLong(s));
        }
        return tbItemParamServiceProxy.deleteTbItemParamService(idList);
    }
}
