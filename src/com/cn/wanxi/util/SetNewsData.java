package com.cn.wanxi.util;

import com.cn.wanxi.dto.NewsBackDto;
import com.cn.wanxi.model.NewsModel;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class SetNewsData {
    public static List<NewsBackDto> setDataFromRedis(Jedis jedis, long length){
        List<String> newsId = jedis.lrange("newsId", 0, length);
        List<String> newsTitle = jedis.lrange("newsTitle", 0, length);
        List<String> newsImg = jedis.lrange("newsImg", 0, length);
        List<String> newsContent = jedis.lrange("newsContent", 0, length);
        List<String> newsCreateTime = jedis.lrange("newsCreateTime",0,length);
        List<String> newsType = jedis.lrange("newsType", 0, length);
        List<NewsBackDto> newsBackDtoList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            NewsBackDto newsBackDto = new NewsBackDto();
            NewsModel newsModel = new NewsModel();
            newsModel.setId(Integer.parseInt(newsId.get(i)));
            newsModel.setNewsTitle(newsTitle.get(i));
            newsModel.setNewsImg(newsImg.get(i));
            newsModel.setNewsContent(newsContent.get(i));
            newsModel.setCreateDate(newsCreateTime.get(i));
            newsBackDto.setNewsModel(newsModel);
            newsBackDto.setType(newsType.get(i));
            newsBackDtoList.add(newsBackDto);
        }
        return newsBackDtoList;
    }

    public static List<NewsBackDto> setDataFromDataBase(List<NewsBackDto> newsBackDtoList, Jedis jedis){
        for (int i = 0; i < newsBackDtoList.size(); i++) {
            jedis.rpush("newsId", newsBackDtoList.get(i).getNewsModel().getId().toString());
            jedis.rpush("newsTitle", newsBackDtoList.get(i).getNewsModel().getNewsTitle());
            jedis.rpush("newsImg", newsBackDtoList.get(i).getNewsModel().getNewsImg());
            jedis.rpush("newsContent", newsBackDtoList.get(i).getNewsModel().getNewsContent());
            jedis.rpush("newsCreateTime", newsBackDtoList.get(i).getNewsModel().getCreateDate());
            jedis.rpush("newsType", newsBackDtoList.get(i).getType());
        }
        return newsBackDtoList;
    }
}
