package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.CoachDao;
import com.cn.wanxi.dao.CoachPostDao;
import com.cn.wanxi.dao.NavDao;
import com.cn.wanxi.dao.impl.CoachDaoImpl;
import com.cn.wanxi.dao.impl.CoachPostDaoImpl;
import com.cn.wanxi.dao.impl.NavDaoImpl;
import com.cn.wanxi.dto.CoachDto;
import com.cn.wanxi.dto.CoachFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.model.CoachPostModel;
import com.cn.wanxi.service.ICoachService;
import com.cn.wanxi.util.SetCoachData;
import com.cn.wanxi.util.SetCoachPostData;
import com.cn.wanxi.util.SetNavData;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;

public class CoachServiceImpl implements ICoachService {

    private CoachDao coachDao = new CoachDaoImpl();

    private NavDao navDao = new NavDaoImpl();

    private CoachPostDao coachPostDao = new CoachPostDaoImpl();

    @Override
    public int add(CoachModel coachModel) {
        return coachDao.add(coachModel);
    }

    @Override
    public int update(CoachModel coachModel) {
        return coachDao.update(coachModel);
    }

    @Override
    public int delete(Integer id) {
        return coachDao.delete(id);
    }

    @Override
    public CoachModel getOneCoachModel(Integer id) {
        return coachDao.getOneCoachModel(id);
    }

    @Override
    public ResultDto getCoachList() {
        ResultDto resultDto = new ResultDto();
        resultDto.setCount(coachDao.findAllCoachCount());
        resultDto.setObject(coachDao.getCoachList());
        resultDto.setList(coachPostDao.findAll());
        return resultDto;
    }

    @Override
    public ResultDto findCoachListByCondition(CoachFindDto condition, PageDto pageDto) {
        ResultDto resultDto = new ResultDto();
        resultDto.setObject(coachDao.findCoachListByCondition(condition,pageDto));
        resultDto.setCount(coachDao.findAllCoachCount());
        resultDto.setList(coachPostDao.findAll());
        return resultDto;
    }

    @Override
    public CoachDto getCoachDto() {
        CoachDto coachDto = new CoachDto();
        Jedis jedis = new Jedis();
        long coachLength = jedis.llen("coachId");
        long coachPostLength = jedis.llen("coachPostId");
        long navLength = jedis.llen("navId");
        if (coachLength > 0 && coachPostLength > 0 && navLength > 0) {
            coachDto = setDataFromRedis(navLength, coachLength, coachPostLength, jedis);
        } else {
            coachDto = setDataFromDataBase(navLength, coachLength, coachPostLength);
        }
        return coachDto;
    }

    public CoachDto setDataFromRedis(long navLength, long coachLength, long coachPostLength, Jedis jedis){
        CoachDto coachDto = new CoachDto();
        coachDto.setNavModelList(SetNavData.setDataFromRedis(jedis,navLength));
        coachDto.setCoachModelList(SetCoachData.setDataFromRedis(jedis,coachLength));
        coachDto.setCoachPostModelList(SetCoachPostData.setCoachPostFromRedis(jedis,coachPostLength));
        return coachDto;
    }

    public CoachDto setDataFromDataBase(long navLength, long coachLength, long coachPostLength){
        CoachDto coachDto = new CoachDto();
        Jedis jedis = new Jedis();
        if (navLength <= 0) {
            coachDto.setNavModelList(SetNavData.setDataFromDataBase(navDao.getNavList(), jedis));
        } else {
            coachDto.setNavModelList(navDao.getNavList());
        }
        if (coachLength <= 0) {
            coachDto.setCoachModelList(SetCoachData.setDataFromDataBase(coachDao.getCoachList(), jedis));
        } else {
            coachDto.setCoachModelList(coachDao.getCoachList());
        }
        if (coachPostLength <= 0) {
            coachDto.setCoachPostModelList(SetCoachPostData.setCoachPostFromDataBase(coachPostDao.findAll(), jedis));
        } else {
            coachDto.setCoachPostModelList(coachPostDao.findAll());
        }
        return coachDto;
    }
}
