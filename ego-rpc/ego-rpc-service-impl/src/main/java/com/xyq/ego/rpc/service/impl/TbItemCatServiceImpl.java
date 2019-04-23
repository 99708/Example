package com.xyq.ego.rpc.service.impl;

import com.xyq.ego.rpc.mapper.TbItemCatMapper;
import com.xyq.ego.rpc.pojo.TbItemCat;
import com.xyq.ego.rpc.pojo.TbItemCatExample;
import com.xyq.ego.rpc.service.TbItemCatService;
import com.xyq.entity.TreeResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TbItemCatServiceImpl implements TbItemCatService {

    //注入mapper接口实例化对象
    @Resource
    private TbItemCatMapper tbItemCatMapper;

    /**
     * 根据id加载该节点的子节点
     * @param id
     * @return
     */
    @Override
    public List<TreeResult> loadTbItemCatListService(Long id) {

        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(tbItemCatExample);
        List<TreeResult> treeResultList = new ArrayList<>();
        for(TbItemCat t:tbItemCats){
            TreeResult treeResult = new TreeResult();
            treeResult.setId(t.getId());
            treeResult.setText(t.getName());
            treeResult.setState(t.getIsParent()? "closed": "open");
            treeResultList.add(treeResult);
        }
        return treeResultList;
    }

    /**
     * 查询所有类目信息
     * @return
     */
    @Override
    public List<TbItemCat> loadTbItemCatService() {
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(tbItemCatExample);
        return tbItemCats;
    }
}
