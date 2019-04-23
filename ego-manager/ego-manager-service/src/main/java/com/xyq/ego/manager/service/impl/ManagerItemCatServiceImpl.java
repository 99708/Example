package com.xyq.ego.manager.service.impl;

import com.xyq.ego.manager.service.ManagerItemCatService;
import com.xyq.ego.rpc.service.TbItemCatService;
import com.xyq.entity.TreeResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ManagerItemCatServiceImpl implements ManagerItemCatService {
    //注入远程代理对象
    @Resource
    private TbItemCatService tbItemCatServiceImpl;

    @Override
    public List<TreeResult> loadItemCatListService(Long id) {
        return tbItemCatServiceImpl.loadTbItemCatListService(id);
    }
}
