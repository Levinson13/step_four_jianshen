package com.cn.wanxi.dao;

import com.cn.wanxi.dto.CoachBackDto;
import com.cn.wanxi.dto.CoachDto;
import com.cn.wanxi.dto.CoachFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.model.CoachModel;

import java.util.List;

public interface CoachDao {
    int add(CoachModel coachModel);

    int update(CoachModel coachModel);

    int delete(Integer id);

    CoachModel getOneCoachModel(Integer id);

    List<CoachBackDto> getCoachList();

    List<CoachBackDto> findCoachListByCondition(CoachFindDto condition, PageDto pageDto);

    int findAllCoachCount();

    List<CoachModel> getAllCoach();

}
