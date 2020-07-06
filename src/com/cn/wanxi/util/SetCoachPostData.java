package com.cn.wanxi.util;

import com.cn.wanxi.model.CoachPostModel;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class SetCoachPostData {
    public static List<CoachPostModel> setCoachPostFromRedis(Jedis jedis , long coachPostLength){
        List<String> coachPostId = jedis.lrange("coachPostId", 0, coachPostLength);
        List<String> coachPostList = jedis.lrange("coachPostList", 0, coachPostLength);
        List<CoachPostModel> coachPostModelList = new ArrayList<>();
        for (int i = 0; i < coachPostLength; i++) {
            CoachPostModel coachPostModel = new CoachPostModel();
            coachPostModel.setId(Integer.parseInt(coachPostId.get(i)));
            coachPostModel.setPost(coachPostList.get(i));
            coachPostModelList.add(coachPostModel);
        }
        return coachPostModelList;
    }

    public static List<CoachPostModel> setCoachPostFromDataBase(List<CoachPostModel> coachPostModelList,Jedis jedis){
        for (int i = 0; i < coachPostModelList.size(); i++) {
            jedis.rpush("coachPostId", coachPostModelList.get(i).getId().toString());
            jedis.rpush("coachPostList", coachPostModelList.get(i).getPost());
        }
        return coachPostModelList;
    }
}
