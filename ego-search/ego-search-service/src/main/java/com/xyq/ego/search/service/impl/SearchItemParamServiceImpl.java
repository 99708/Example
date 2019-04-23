package com.xyq.ego.search.service.impl;

import com.xyq.ego.rpc.pojo.TbItemParamItem;
import com.xyq.ego.rpc.service.TbItemParamItemService;
import com.xyq.ego.search.service.SearchItemParamService;
import com.xyq.entity.EgoResult;
import com.xyq.utils.JsonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SearchItemParamServiceImpl implements SearchItemParamService {
    //注入远程代理对象
    @Resource
    private TbItemParamItemService tbItemParamItemServiceProxy;

    /**
     * 根据商品id查询商品规格参数
     * @param itemid
     * @return
     */
    @Override
    public String loadItemParamsService(Long itemid) {
        EgoResult egoResult = tbItemParamItemServiceProxy.loadTbItemParamItemByItemIdServices(itemid);
        if(egoResult != null){
            TbItemParamItem data = (TbItemParamItem) egoResult.getData();
            String paramData = data.getParamData();
            List<Map> maps = JsonUtils.jsonToList(paramData, Map.class);
            String itemParamItem = getItemParamItem(maps);
            return itemParamItem;
        }

        return null;
    }

    private static String getItemParamItem(List<Map> listMap) {
        StringBuffer sb = new StringBuffer();
        sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
        sb.append("    <tbody>\n");
        //遍历规格参数组
        for (Map m1 : listMap) {
            sb.append("        <tr>\n");
            sb.append("            <th class=\"tdTitle\" colspan=\"2\">" + m1.get("group") + "</th>\n");
            sb.append("        </tr>\n");
            List<Map> list2 = (List<Map>) m1.get("params");
            //遍历规格参数组中的项目
            for (Map m2 : list2) {
                sb.append("        <tr>\n");
                sb.append("            <td class=\"tdTitle\">" + m2.get("k") + "</td>\n");
                sb.append("            <td>" + m2.get("v") + "</td>\n");
                sb.append("        </tr>\n");
            }
        }
        sb.append("    </tbody>\n");
        sb.append("</table>");
        // 返回html片段
        return sb.toString();
    }

}
