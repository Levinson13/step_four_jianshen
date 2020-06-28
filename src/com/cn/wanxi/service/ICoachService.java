package com.cn.wanxi.service;

import com.cn.wanxi.dto.CoachDto;
import com.cn.wanxi.dto.CoachFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.model.CoachModel;

import java.util.List;

public interface ICoachService {
    int add(CoachModel coachModel);

    int update(CoachModel coachModel);

    int delete(Integer id);

    CoachModel getOneCoachModel(Integer id);

    ResultDto getCoachList();

    ResultDto findCoachListByCondition(CoachFindDto condition, PageDto pageDto);

    CoachDto getCoachDto();
}
