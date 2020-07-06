package com.cn.wanxi.util;

import com.cn.wanxi.dto.CoachBackDto;
import com.cn.wanxi.model.CoachModel;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class SetCoachData {

    public static void di(Object object){

    }

    public static List<CoachBackDto> setDataFromRedis(Jedis jedis, long length){
        List<String> coachIds = jedis.lrange("coachId", 0, length);
        List<String> coachName = jedis.lrange("coachName", 0, length);
        List<String> coachPost = jedis.lrange("coachPost", 0, length);
        List<String> coachImg = jedis.lrange("coachImg", 0, length);
        List<String> coachCreateTime = jedis.lrange("coachCreateTime", 0, length);
//        List<String> coachPost = jedis.lrange("coachPost", 0, length);
        List<CoachBackDto> coachBackDtoList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            CoachModel coachModel = new CoachModel();
            CoachBackDto coachBackDto = new CoachBackDto();
            coachModel.setId(Integer.parseInt(coachIds.get(i)));
            coachModel.setCoachName(coachName.get(i));
            coachModel.setCoachImg(coachImg.get(i));
            coachModel.setCreateDate(coachCreateTime.get(i));
            coachBackDto.setCoachModel(coachModel);
            coachBackDto.setPost(coachPost.get(i));
            coachBackDtoList.add(coachBackDto);
        }
        return coachBackDtoList;
    }

    public static List<CoachBackDto> setDataFromDataBase(List<CoachBackDto> coachBackDtoList, Jedis jedis){
        for (int i = 0; i < coachBackDtoList.size(); i++) {
            jedis.rpush("coachId", coachBackDtoList.get(i).getCoachModel().getId().toString());
            jedis.rpush("coachName", coachBackDtoList.get(i).getCoachModel().getCoachName());
//            jedis.rpush("coachPost", coachBackDtoList.get(i).getCoachModel().getCoachPost().toString());
            jedis.rpush("coachImg", coachBackDtoList.get(i).getCoachModel().getCoachImg());
            jedis.rpush("coachCreateTime", coachBackDtoList.get(i).getCoachModel().getCreateDate());
            jedis.rpush("coachPost", coachBackDtoList.get(i).getPost());
        }
        return coachBackDtoList;
    }
}
