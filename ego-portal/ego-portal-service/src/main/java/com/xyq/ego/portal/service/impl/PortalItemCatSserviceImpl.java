package com.xyq.ego.portal.service.impl;

import com.xyq.ego.portal.entity.CatNode;
import com.xyq.ego.portal.entity.ItemCat;
import com.xyq.ego.portal.service.PortalItemCatSservice;
import com.xyq.ego.rpc.pojo.TbItemCat;
import com.xyq.ego.rpc.service.TbItemCatService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PortalItemCatSserviceImpl implements PortalItemCatSservice {

    //注入远程代理对象
    @Resource
    private TbItemCatService tbItemCatServiceProxy;

    /**
     * 加载门户首页的类目信息
     * @return
     */
    @Cacheable(cacheNames="item_cat_cache",key="#root.methodName")
    @Override
    public ItemCat loadTbItemCatService() {
        List<TbItemCat> tbItemCats = tbItemCatServiceProxy.loadTbItemCatService();
        List<?> itemCatChild = getItemCatChild(0L, tbItemCats);
        ItemCat itemCat = new ItemCat();
        itemCat.setData(itemCatChild);
        return itemCat;
    }

    /**
     * 对类目信息进行遍历，得到有层级关系的类目信息
     * @param pid
     * @param itemCats
     * @return
     */
    private List<?> getItemCatChild(Long pid,List<TbItemCat> itemCats){

        //盛放指定分类下的所有子分类信息
        List resultList = new ArrayList();

        for (TbItemCat itemCat : itemCats) {

            //递归便利的退出条件
            if (itemCat.getParentId().equals(pid)) {
                if (itemCat.getIsParent()) {
                    //如果itemCat代表一级分类或者二级分类

                    CatNode catNode = new CatNode();

                    if (itemCat.getParentId().longValue() == 0) {
                        //如果是一级分类    "<a href='/products/1.html'>图书、音像、电子书刊</a>",
                        catNode.setName("<a href='/products/" + itemCat.getId() + ".html'>" + itemCat.getName() + "</a>");
                    } else {
                        //如果是二级分类    "电子书刊",
                        catNode.setName(itemCat.getName());
                    }
                    //"/products/2.html",
                    catNode.setUrl("/products/" + itemCat.getId() + ".html");
                    //进行递归调用
                    catNode.setList(getItemCatChild(itemCat.getId(), itemCats));
                    //将节点添加到list集合中
                    resultList.add(catNode);
                } else {
                    //如果itemCat表示三级分类   "/products/3.html|电子书",
                    resultList.add("/products/" + itemCat.getId() + ".html|" + itemCat.getName());
                }
            }
        }
        return resultList;


    }

}
