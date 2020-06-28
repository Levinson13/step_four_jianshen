package com.cn.wanxi.dao;

import com.cn.wanxi.dto.CoachFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.model.CoachModel;

import java.util.List;

public interface CoachDao {
    int add(CoachModel coachModel);

    int update(CoachModel coachModel);

    int delete(Integer id);

    CoachModel getOneCoachModel(Integer id);

    List<CoachModel> getCoachList();

    List<CoachModel> findCoachListByCondition(CoachFindDto condition, PageDto pageDto);

    int findAllCoachCount();

}
