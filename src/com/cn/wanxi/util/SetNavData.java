package com.cn.wanxi.util;

import com.cn.wanxi.model.NavModel;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class SetNavData {

    public static List<NavModel> setDataFromRedis(Jedis jedis, long length){
        List<String> navIds = jedis.lrange("navId", 0, length);
        List<String> navHrefs = jedis.lrange("navHref", 0, length);
        List<String> navTitles = jedis.lrange("navTitle", 0, length);
        List<String> navStatus = jedis.lrange("navStatus", 0, length);
        List<NavModel> navModelList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            NavModel navModel = new NavModel();
            navModel.setId(Integer.parseInt(navIds.get(i)));
            navModel.setHref(navHrefs.get(i));
            navModel.setTitle(navTitles.get(i));
            navModel.setStatus(Integer.parseInt(navStatus.get(i)));
            navModelList.add(navModel);
        }
        return navModelList;
    }

    public static List<NavModel> setDataFromDataBase(List<NavModel> navModelList,Jedis jedis){
        for (int i = 0; i < navModelList.size(); i++) {
            jedis.rpush("navId", navModelList.get(i).getId().toString());
            jedis.rpush("navHref", navModelList.get(i).getHref());
            jedis.rpush("navTitle", navModelList.get(i).getTitle());
            jedis.rpush("navStatus", navModelList.get(i).getStatus().toString());
        }
        return navModelList;
    }
}
