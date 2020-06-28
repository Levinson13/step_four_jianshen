package com.cn.wanxi.service;

import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.dto.StudentFindDto;
import com.cn.wanxi.model.StudentModel;

import java.util.List;

public interface IStudentService {
    int add(StudentModel studentModel);

    int update(StudentModel studentModel);

    int delete(Integer id);

    StudentModel getOneStudentModel(Integer id);

    ResultDto getStudentList();

    ResultDto findStudentListByCondition(StudentFindDto condition, PageDto page);

}
